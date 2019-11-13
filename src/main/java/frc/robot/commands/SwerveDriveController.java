package frc.robot.commands;

import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveDriveController extends Command {

  public SwerveDriveController() {
    requires(Robot.mSwerve);
  }

  @Override
  protected void initialize() {
    Robot.mSwerve.gyro.reset();
  }

  @Override
  protected void execute() {

    double f = -Robot.mOi.getAxis(1);
    double s = Robot.mOi.getAxis(0);
    double r = Robot.mOi.getAxis(4);

    double angle = -Robot.mSwerve.gyro.getYaw();
    while (angle < 0) angle += 360;
    while (angle >= 360) angle -= 360;

    SwerveMixerData dat = Robot.mSwerve.getSwerveData(f, s, r, angle);
    Robot.mSwerve.setSwerveInput(dat);

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}