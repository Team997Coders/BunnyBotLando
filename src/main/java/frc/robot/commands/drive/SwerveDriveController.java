package frc.robot.commands.drive;

import org.team997coders.spartanlib.helpers.SwerveMixerData;
import org.team997coders.spartanlib.oi.controllers.Logitech;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class SwerveDriveController extends Command {

  public SwerveDriveController() {
    requires(Robot.mSwerve);
  }

  @Override
  protected void initialize() {
    Robot.mSwerve.resetGyro();
  }

  @Override
  protected void execute() {
    double f = -Robot.mOi.getGamepad1().getAxis(Logitech.Axis.LEFT_Y);
    double s = Robot.mOi.getGamepad1().getAxis(Logitech.Axis.LEFT_Y);
    double r = Robot.mOi.getGamepad1().getAxis(Logitech.Axis.LEFT_Y);

    double angle = -Robot.mSwerve.getYaw();

    SwerveMixerData dat = Robot.mSwerve.getSwerveData(f, s, r, angle);
    Robot.mSwerve.setSwerveInput(dat);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}