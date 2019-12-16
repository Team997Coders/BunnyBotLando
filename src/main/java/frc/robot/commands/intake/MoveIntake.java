package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveIntake extends Command {

  private double mSpeed = 0.0;

  public MoveIntake(double speed) {
    requires(Robot.mIntake);
    mSpeed = speed;
  }

  @Override
  protected void execute() {
    Robot.mIntake.setSpeed(mSpeed);
  }

  @Override
  protected boolean isFinished() { return false; }

  @Override
  protected void end() {
    Robot.mIntake.setSpeed(0.0);
  }

  @Override
  protected void interrupted() { end(); }
}
