package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ZeroSwerve extends Command {

  @Override
  protected void execute() {
    Robot.mSwerve.resetGyro();
  }

  @Override
  protected boolean isFinished() { return true; }

}