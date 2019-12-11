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
public class ZeroArm extends Command {

  public ZeroArm() {
    requires(Robot.arm);
  }

  @Override
  protected void execute() {
    Robot.arm.setSpeed(-0.2);
  }

  @Override
  protected boolean isFinished() {
    if (Robot.arm.getTopSwitch()) {
      Robot.arm.zeroEncoderTicks();
      return true;
    }
    return false;
  }

  @Override
  protected void end() {
    Robot.arm.setSpeed(0);
  }

  @Override
  protected void interrupted() { end(); }
}
