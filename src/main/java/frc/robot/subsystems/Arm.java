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

  public boolean kGrabberClosed = false;
  public double kPeakOutout = .7;

  /* Nonzero to block the config until success, zero to skip checking */
  final int kTimeoutMs = 30;

  public Arm() {
    armMotor = new TalonSRX(RobotMap.Ports.armMotor);

    armMotor.configFactoryDefault();

    zeroEncoderTicks();

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

  public int getEncoderTicks(){
    return armMotor.getSelectedSensorPosition(0);
  }

  public void zeroEncoderTicks() {
    // zero the relative encoder count
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);
    armMotor.setSelectedSensorPosition(0, 0, kTimeoutMs);
  }

  public void grab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    kGrabberClosed = true;
  }
  
  public void ungrab(){
    grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
    kGrabberClosed = false;
  }

  public void updateSmartDashboard(){
    SmartDashboard.putBoolean("Arm/Grabber Deployed", kGrabberClosed);
    SmartDashboard.putNumber("Arm/Encoder Val", getEncoderTicks());
    SmartDashboard.putNumber("Arm/Ange", ToDeg(getEncoderTicks()));
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }

  public void initQuadrature() {
		/* get the absolute pulse width position */
		int pulseWidth = armMotor.getSensorCollection().getPulseWidthPosition();

		/**
		 * Mask out the bottom 12 bits to normalize to [0,4095],
		 * or in other words, to stay within [0,360) degrees 
		 */
		pulseWidth = pulseWidth & 0xFFF;

		/* Update Quadrature position */
	  armMotor.getSensorCollection().setQuadraturePosition(pulseWidth, kTimeoutMs);
  }
  
  	/**
	 * @param units CTRE mag encoder sensor units 
	 * @return degrees rounded to tenths.
	 */
	double ToDeg(int units) {
		double deg = units * 360.0 / 4096.0;

		/* truncate to 0.1 res */
		deg *= 10.0;
		deg = (int) deg;
		deg /= 10.0;

		return deg;
	}

}
