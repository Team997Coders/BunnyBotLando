package frc.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveGrabber extends Command {

  private boolean mToGrabOrNotToGrab = false;

  public MoveGrabber(boolean toGrabOrNotToGrab) {
    mToGrabOrNotToGrab = toGrabOrNotToGrab;
  }

  @Override
  protected void execute() {
    if (mToGrabOrNotToGrab) Robot.mArm.grab();
    else Robot.mArm.ungrab();
  }

  @Override
  protected boolean isFinished() { return true; }

}