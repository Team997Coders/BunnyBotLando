package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetModuleAngle extends Command {

  private int mID;
  private double mAngle;

  public SetModuleAngle(int ID, double angle) {
    this.mID = ID;
    this.mAngle = angle;
  }

  @Override
  protected void execute() {
    Robot.mSwerve.getModule(mID).setTargetAngle(mAngle);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
