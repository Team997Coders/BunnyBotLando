package frc.robot.commands;

import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveDriveController extends Command {

  public SwerveDriveController() { }

  @Override
  protected void execute() {

    double f = -Robot.getOi().getAxis(0);
    double s = Robot.getOi().getAxis(0);
    double r = Robot.getOi().getAxis(0);

    SwerveMixerData dat = Robot.getSwerve().getSwerveData(f, s, r);
    Robot.getSwerve().setSwerveInput(dat);

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}