package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * TODO: make a description
 */
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

//subsystem for anything and everything related to the arm on the robot
//the arm is the big one that moves up and down
public class Arm extends Subsystem {

  private WPI_VictorSPX armMotor;

  private DoubleSolenoid grabberSolenoid;

  public boolean grabberEjected = false;

  public Arm() {
    // TODO: Add current limits. Also use limit switches
    armMotor = new WPI_VictorSPX(RobotMap.Ports.armMotor);
    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.grabberSolenoidPort1, RobotMap.Ports.grabberSolenoidPort2); 
  }

  public void setSpeed(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(speed);
    }
  }

  public double getEncoderTicks(){
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    return armMotor.getSelectedSensorPosition(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void launchGrabber(){
    grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    grabberEjected = true;
  }
  public void stopGrabber(){
    grabberSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void updateSmartDashBoard(){
    SmartDashboard.putBoolean("Robot Grabber Deployed", grabberEjected);
  }
}
