/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ConveyorMove extends Command {

  private double mSpeed = 0.0;

  public ConveyorMove(double speed) {
    requires(Robot.mIntake);
    mSpeed = speed;
  }

  @Override
  protected void execute() {
    Robot.mIntake.setSpeed(mSpeed);
  }

  @Override
  protected boolean isFinished() { return false; }

  @Override
  protected void end() {
    Robot.mIntake.setSpeed(0.0);
  }

  @Override
  protected void interrupted() { end(); }
}
