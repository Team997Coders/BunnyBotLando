package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;

import edu.wpi.first.wpilibj.AnalogInput;
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
    //zeroEncoderTicks();
    //armMotor.configClosedLoopPeakOutput(0, .7);

    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.grabberSolenoidPort1, RobotMap.Ports.grabberSolenoidPort2); 

    armMotor.configFactoryDefault(10);
    armMotor.clearStickyFaults(10);

    sensorCollection = new SensorCollection(armMotor);
    sensorCollection.getAnalogIn();
    armMotor.config_kP(0, RobotMap.Values.armP);
    armMotor.config_kI(0, 0.0);
    armMotor.config_kD(0, 0.0);
    //armMotor.configNominalOutputForward(0.75, 10);
    //armMotor.configNominalOutputReverse(-0.75, 10);
    //armMotor.configClosedLoopPeakOutput(0, 0.5, 10);
    //armMotor.configForwardSoftLimitThreshold()
  }

  public void setSpeed(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(ControlMode.PercentOutput, speed * 0.8);
      //armMotor.set
    }
    SmartDashboard.putNumber("Sped", speed);
  }

  public boolean getTopSwitch() {
    return sensorCollection.isFwdLimitSwitchClosed();
  }

  public double getEncoderTicks(){
    return armMotor.getSelectedSensorPosition(0);
  }

  public double getEncoderTickAbsolute() {
    return sensorCollection.getAnalogIn();
  }

  public void zeroEncoderTicks() {
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
    armMotor.setSelectedSensorPosition(0, 0, 10);
  }

  public void grab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    grabberEjected = true;
  }
  
  public void ungrab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
    grabberEjected = false;
  }

  public void setAngle(double perc) {
    double range = RobotMap.Values.armMaxEncoderTicks - RobotMap.Values.armMinEncoderTicks;
    
    double offset = perc * range;
    double ticks = offset + RobotMap.Values.armMinEncoderTicks;
    armMotor.set(ControlMode.Position, ticks);
    
  }

 

  public double getPercentUp(){
    double range = RobotMap.Values.armMaxEncoderTicks - RobotMap.Values.armMinEncoderTicks;
    final double currentEncoderTicks = getEncoderTicks();
    final double percentUp = ((currentEncoderTicks - RobotMap.Values.armMinEncoderTicks) / range);
    return percentUp;
  }
  public void updateSmartDashboard(){
    //SmartDashboard.putBoolean("Arm/Grabber Deployed", grabberEjected());
    SmartDashboard.putNumber("Arm/Encoder Val", getEncoderTicks());
    SmartDashboard.putNumber("Arm/Arm Percent UP", getPercentUp());
    SmartDashboard.putNumber("Arm/Encoder Absolute Val", getEncoderTickAbsolute());
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }

}
