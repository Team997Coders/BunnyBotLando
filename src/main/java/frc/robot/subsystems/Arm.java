package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * TODO: make a description
 */
public class Arm extends Subsystem {

  // need fxs for getting encoder values
  WPI_VictorSPX armMotor; // TODO: Make private

  public Arm() {
    // TODO: Add current limits. Also use limit switches
    armMotor = new WPI_VictorSPX(RobotMap.Ports.armMotor);
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
}
