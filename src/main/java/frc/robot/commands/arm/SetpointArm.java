package frc.robot.commands.arm;

import org.team997coders.spartanlib.math.MathUtils;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetpointArm extends Command {

  private double mAngle = 0.0;
  private boolean mWait = false;

  public SetpointArm(double angle, boolean wait) {
    requires(Robot.mArm);

    mAngle = angle; mWait = wait;
  }

  @Override
  protected void execute() {
    Robot.mArm.setAngle(mAngle);
  }

  @Override
  protected boolean isFinished() {
    if (mWait) {
      return MathUtils.epsilon(Robot.mArm.getAngle(), mAngle, 2);
    } else {
      return true;
    }
  }

}