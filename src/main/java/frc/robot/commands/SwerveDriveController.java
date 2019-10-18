package frc.robot.commands;

import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveDriveController extends Command {

  public SwerveDriveController() {

  }

  @Override
  protected void execute() {

    double f = -Robot.m_oi.getAxis(0);
    double s = Robot.m_oi.getAxis(0);
    double r = Robot.m_oi.getAxis(0);

    SwerveMixerData dat = Robot.swerve.SwerveMixer(f, s, r);
    Robot.swerve.setSwerveInput(dat);

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}