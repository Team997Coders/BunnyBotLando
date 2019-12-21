/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.drive.SwerveDriveController;

import org.team997coders.spartanlib.controllers.SpartanPID;
import org.team997coders.spartanlib.helpers.SwerveMixerData;
import org.team997coders.spartanlib.math.MathUtils;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

public class AutoDriveForward extends Command {

    private SpartanPID drivePid;
    private SpartanPID anglePid;
    private double targetAngle;
    private double total;

  public AutoDriveForward(double distance) {
    requires(Robot.mSwerve);
    drivePid = new SpartanPID(RobotMap.Values.AUTO_DRIVE_PID);
    anglePid = new SpartanPID(RobotMap.Values.AUTO_TURN_PID);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      targetAngle = Robot.mSwerve.getYaw();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentAngle = Robot.mSwerve.getYaw();
    double fieldAngle = currentAngle;
    double directionMod = 1;
    
    if (Math.abs(targetAngle - currentAngle) > 180) {
        currentAngle -= 360;
        directionMod = -1;
    }
    
    double rawAngleOutput = anglePid.WhatShouldIDo(currentAngle, Robot.mDeltaT);
    double finalAngleOutput = rawAngleOutput * directionMod;

    SwerveModule[] modules = Robot.mSwerve.getModules();
    for(SwerveModule module : modules) {
        total += module.getSpeedVector().getMagnitude() / (double)Robot.mDeltaT;
    }
    double currentDistance = total / 4;
    

    double rawDistanceOutput = drivePid.WhatShouldIDo(currentDistance, Robot.mDeltaT);
    double finalDistanceOutput = MathUtils.clamp(rawDistanceOutput, -1, 1);

      SwerveMixerData dat = Robot.mSwerve.getSwerveData(finalDistanceOutput, 0, finalAngleOutput, Robot.mSwerve.getYaw());
      Robot.mSwerve.setSwerveInput(dat);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}