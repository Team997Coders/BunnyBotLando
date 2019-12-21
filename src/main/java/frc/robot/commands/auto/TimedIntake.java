package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.Robot;

public class TimedIntake extends Command {

  private long miliSec = 0, startTime = 0;

  public TimedIntake(long miliSec) {
    this.miliSec = miliSec;
  }

  @Override
  protected void initialize() {
    startTime = System.currentTimeMillis();
  }

  @Override
  protected void execute() {
    //Robot.conveyorBelt.
  }

  @Override
  protected boolean isFinished() {
    // TODO Auto-generated method stub
    return false;
  }

}