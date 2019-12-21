package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Failsafe extends Command {

  @Override
  protected void execute() {
    Scheduler.getInstance().add(new Grab(false));
    Scheduler.getInstance().add(new SetArmAngle(1));
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

}