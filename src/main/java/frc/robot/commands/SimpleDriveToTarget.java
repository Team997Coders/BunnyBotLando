/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import org.team997coders.spartanlib.helpers.SwerveMixerData;
import org.team997coders.spartanlib.limelight.LimeLight;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class SimpleDriveToTarget extends Command {
  public SimpleDriveToTarget() {
    requires(Robot.mSwerve);
  }

  @Override
  protected void initialize() {
    Robot.mLimeLight.setDouble(LimeLight.LED_MODE, LimeLight.LEDState.ForceOn);
    Robot.mLimeLight.setDouble(LimeLight.CAMERA_MODE, LimeLight.CameraState.VisionProccessing);
  }

  @Override
  protected void execute() {
    if(Robot.mLimeLight.getDouble(LimeLight.TARGET_VISIBLE, 0) == 1) {
      double error = (RobotMap.Values.VISION_TARGET_SIZE - Robot.mLimeLight.getDouble(LimeLight.TARGET_AREA, 0)); 
      double output = error * RobotMap.Values.VISION_P; //janky P-loop for a janky command >.>
      SwerveMixerData dat = Robot.mSwerve.getSwerveData(output, 0, 0);
      Robot.mSwerve.setSwerveInput(dat);
    }
  }

  @Override
  protected boolean isFinished() {
    return (Math.abs(Robot.mLimeLight.getDouble(LimeLight.TARGET_AREA, 0) - RobotMap.Values.VISION_TARGET_SIZE) <= RobotMap.Values.VISION_TOLERANCE);
    //target area defaults to 0 if no target is found. This may result in infinite looping.
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mLimeLight.setDouble(LimeLight.LED_MODE, LimeLight.LEDState.ForceOff);
    SwerveMixerData dat = Robot.mSwerve.getSwerveData(0, 0, 0);
    Robot.mSwerve.setSwerveInput(dat);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
