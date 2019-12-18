package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
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
  public double bucketUpEncoderTicks;
  public Arm() {
    armMotor = new TalonSRX(RobotMap.Ports.armMotor);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
    zeroEncoderTicks();
    //armMotor.configClosedLoopPeakOutput(0, .7);

    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.grabberSolenoidPort1, RobotMap.Ports.grabberSolenoidPort2); 

    sensorCollection = new SensorCollection(armMotor);
    
   
  }

  public void armToPositionTEMP(double position) { } 
  //TODO replace with Rohan's actual code.

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
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
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

  public void moveClaw(boolean direction) {
    if (direction) {
      grab();
    } else {
      ungrab();
    }
  }

  public void setAngle(double perc) {

  }

  public double getPercentUp(){

    final double currentEncoderTicks = getEncoderTicks();
    final double percentUp = (currentEncoderTicks-RobotMap.Values.armMinEncoderTicks/(RobotMap.Values.armMaxEncoderTicks- RobotMap.Values.armMinEncoderTicks));
    return percentUp;
  }
  public void updateSmartDashboard(){
    SmartDashboard.putBoolean("Arm/Grabber Deployed", grabberEjected);
    SmartDashboard.putNumber("Arm/Encoder Val", getEncoderTicks());
    SmartDashboard.putNumber("Arm Percent UP", getPercentUp());
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }

}
