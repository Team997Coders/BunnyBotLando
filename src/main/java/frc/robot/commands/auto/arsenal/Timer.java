package frc.robot.commands.auto.arsenal;

import edu.wpi.first.wpilibj.command.Command;

public class Timer extends Command {

  private long mWait = 0;
  private long mStarted = 0;

  public Timer(double seconds) {
    mWait = (long)(seconds * 1000);
  }

  @Override
  protected void initialize() {
    mStarted = System.currentTimeMillis();
  }

  @Override
  protected boolean isFinished() {
    return mStarted + mWait < System.currentTimeMillis();
  }

}