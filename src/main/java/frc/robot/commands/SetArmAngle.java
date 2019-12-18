package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetArmAngle extends Command {

  double angle;

  public SetArmAngle(double perc) {
    this.angle = perc;
  }

  @Override
  protected void execute() {
    Robot.arm.setAngle(angle);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

}