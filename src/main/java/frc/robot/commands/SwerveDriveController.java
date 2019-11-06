package frc.robot.commands;

import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveDriveController extends Command {

  public SwerveDriveController() {
    requires(Robot.mSwerve);
  }

  @Override
  protected void execute() {

    double f = -Robot.mOi.getAxis(1);
    double s = Robot.mOi.getAxis(0);
    double r = Robot.mOi.getAxis(4);

    SwerveMixerData dat = Robot.mSwerve.getSwerveData(f, s, r);
    Robot.mSwerve.setSwerveInput(dat);

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}