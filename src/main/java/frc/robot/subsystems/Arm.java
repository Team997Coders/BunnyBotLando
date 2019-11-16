package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * TODO: make a description
 */
public class Arm extends Subsystem {

  // need fxs for getting encoder values
  WPI_VictorSPX armMotor; // TODO: Make private

  private DoubleSolenoid grabberSolenoid;

  public boolean grabberEjected = false;

  public Arm() {
    // TODO: Add current limits. Also use limit switches
    armMotor = new WPI_VictorSPX(RobotMap.Ports.armMotor);
    grabberSolenoid = new DoubleSolenoid(RobotMap.Ports.grabberSolenoidPort1, RobotMap.Ports.grabberSolenoidPort2); 
  }

  // TODO: Rename this to like 'setSpeed' or something because move
  //   doesn't tell you if its speed or position
  public void move(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(speed);
    }
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
