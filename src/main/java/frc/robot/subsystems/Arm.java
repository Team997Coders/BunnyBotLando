package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

//subsystem for anything and everything related to the arm on the robot
//the arm is the big one that moves up and down
public class Arm extends Subsystem {

  // TODO: need fxs for getting encoder values
  private WPI_VictorSPX armMotor;

  public Arm() {
    // TODO: Add current limits. Also use limit switches
    armMotor = new WPI_VictorSPX(RobotMap.Ports.armMotor);
  }

  public void setSpeed(double speed) {
    if (Math.abs(speed) > 0.05) {
      armMotor.set(speed);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
