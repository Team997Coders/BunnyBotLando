package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arm.MoveArm;
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

    armMotor = new TalonSRX(RobotMap.Ports.ARM_TALON);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);

    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.GRABBER_SOLENOID_A, RobotMap.Ports.GRABBER_SOLENOID_B); 

    sensorCollection = new SensorCollection(armMotor);
  }

  public void setSpeed(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(ControlMode.PercentOutput, speed);
    }
  }

  public void setAngle(double angle) {
    double encoderRange = RobotMap.Values.ARM_DOWN - RobotMap.Values.ARM_UP;
    armMotor.set(ControlMode.Position, encoderRange * (angle / RobotMap.Values.ARM_DEGREES_RANGE)); // TODO: definitely change
  }

  public boolean getTopSwitch() {
    return sensorCollection.isFwdLimitSwitchClosed();
  }

  public double getAngle() {
    return RobotMap.Values.ARM_DEGREES_RANGE * (getEncoderTicks() / (RobotMap.Values.ARM_DOWN - RobotMap.Values.ARM_UP/* This part is gonna change */));
  }

  public double getEncoderTicks(){
    return armMotor.getSelectedSensorPosition(0);
  }

  public void grab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    grabberEjected = true;
  }
  
  public void ungrab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
    grabberEjected = false;
  }

  public void updateSmartDashboard(){
    SmartDashboard.putBoolean("Arm/Grabber Deployed", grabberEjected);
    SmartDashboard.putNumber("Arm/Encoder Val", getEncoderTicks());
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }
}
