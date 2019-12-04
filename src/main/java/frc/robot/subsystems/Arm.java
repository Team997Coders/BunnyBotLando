package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveArm;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

//subsystem for anything and everything related to the arm on the robot
//the arm is the big one that moves up and down
public class Arm extends Subsystem {

  private TalonSRX armMotor;
  private SensorCollection sensorCollection;

  private DoubleSolenoid grabberSolenoid;

  public boolean grabberEjected = false;
  public double peakOutput = .7;

  public Arm() {
    armMotor = new TalonSRX(RobotMap.Ports.armMotor);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    
    armMotor.configClosedLoopPeakOutput(0, .7);
    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.grabberSolenoidPort1, RobotMap.Ports.grabberSolenoidPort2); 

    sensorCollection = new SensorCollection(armMotor);
  }

  public void setSpeed(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(ControlMode.PercentOutput, speed);
    }
  }

  public boolean getTopSwitch() {
    return sensorCollection.isFwdLimitSwitchClosed();
  }

  public double getEncoderTicks(){
    return armMotor.getSelectedSensorPosition(0);
  }

  public void zeroEncoderTicks() {
    armMotor.setSelectedSensorPosition(0, 0, 10);
  }

  public void grab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    grabberEjected = true;
  }
  
  public void ungrab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kOff);
    grabberEjected = false;
  }

  public void updateSmartDashboard(){
    SmartDashboard.putBoolean("Robot Grabber Deployed", grabberEjected);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }
}
