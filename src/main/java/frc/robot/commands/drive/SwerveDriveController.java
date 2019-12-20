package frc.robot.commands.drive;

import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

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
    double f = -Robot.mOi.getGamepad0Axis(RobotMap.Ports.leftYaxis);
    double s = Robot.mOi.getGamepad0Axis(RobotMap.Ports.leftXaxis);
    double r = Robot.mOi.getGamepad0Axis(RobotMap.Ports.rightXaxis);

    double angle = -Robot.mSwerve.getYaw();

    SwerveMixerData dat = Robot.mSwerve.getSwerveData(f, s, r, angle);
    Robot.mSwerve.setSwerveInput(dat);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}