package frc.robot.commands.arm;

import org.team997coders.spartanlib.oi.controllers.Logitech;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class MoveArm extends Command {

  public MoveArm() {
    requires(Robot.mArm);
  }

  @Override
  protected void execute() {
    Robot.mArm.setSpeed(
      -Robot.mOi.getGamepad2().getAxis(Logitech.Axis.LEFT_Y)
      * RobotMap.Preferences.ARM_SPEED_MAX
    );
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.mArm.setSpeed(0);
  }

  @Override
  protected void interrupted() { end(); }
}
