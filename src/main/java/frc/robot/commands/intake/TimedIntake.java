package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TimedIntake extends Command {

  private double mMiliSeconds = 0.0, mStartTime = 0.0, mSpeed = 0.0;

  public TimedIntake(double seconds, double speed) {
    mMiliSeconds = (int)(seconds * 1000);
    mSpeed = speed;
  }

  @Override
  protected void initialize() {
    mStartTime = System.currentTimeMillis();
  }

  @Override
  protected void execute() {
    Robot.mIntake.setSpeed(mSpeed);
  }

  @Override
  protected boolean isFinished() {
    return mStartTime + mMiliSeconds < System.currentTimeMillis();
  }

}