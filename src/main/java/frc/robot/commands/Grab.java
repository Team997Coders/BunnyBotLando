package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Grab extends Command {

  private boolean grab = false;

  public Grab(boolean grab) {
    this.grab = grab;
  }

  @Override
  protected void execute() {
    if (grab) {
      Robot.mArm.grab();
    } else {
      Robot.mArm.ungrab();
    }
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}