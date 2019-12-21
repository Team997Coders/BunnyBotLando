package frc.robot.commands.auto;

import org.team997coders.spartanlib.controllers.SpartanPID;
import org.team997coders.spartanlib.helpers.SwerveMixerData;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import java.util.concurrent.TimeUnit;

public class AutoDriveTo extends Command {

  private double angle;
  private double distance;
  private double finalAngle;
  private SpartanPID drivePid = new SpartanPID(RobotMap.Values.AUTO_DRIVE_PID);
  private SpartanPID anglePid = new SpartanPID(RobotMap.Values.AUTO_TURN_PID);

  /**
   * @param angle      Angle to drive towards. 0 is forward, increases clockwise.
   * @param distance   Distance (feet) to move
   * @param finalAngle Angle the robot should end facing.
   */
  public AutoDriveTo(double angle, double distance, double finalAngle) {
    requires(Robot.mSwerve);
    this.angle = angle;
    this.distance = distance;
    this.finalAngle = finalAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    drivePid.reset();
    anglePid.reset();

    drivePid.setSetpoint(distance);
    anglePid.setSetpoint(angle);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentAngle = Robot.mSwerve.getYaw();
    double fieldAngle = currentAngle;
    double directionMod = 1;

    if (Math.abs(finalAngle - currentAngle) > 180) {
      currentAngle -= 360;
      directionMod = -1;
    }

    // double rawAngleOutput = anglePid.WhatShouldIDo(currentAngle, deltaT);

    // double rawDriveOutput = drivePid.WhatShouldIDo(dist, deltaT);

    double[] normalizationArray = {
        // rawDriveOutput * Math.cos(angle),
        // rawDriveOutput * Math.sin(angle)
    };

    normalizationArray = normalize(normalizationArray);

    double forwardSpeed = normalizationArray[0];
    double strafeSpeed = normalizationArray[1];
    // double finalAngleOutput = rawAngleOutput * directionMod;
    // SwerveMixerData dat = Robot.mSwerve.getSwerveData(forwardSpeed, strafeSpeed,
    // finalAngleOutput, fieldAngle);
    // Robot.mSwerve.setSwerveInput(dat);
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

  private double[] normalize(double[] normalizationArray) {
    double max = 1;

    for (double speed : normalizationArray) {
      if (speed > max) {
        max = speed;
      }
    }

    double mod = 1;
    if (max > 1) {
      mod = 1 / max;

      for (int i = 0; i < 2; i++) {
        normalizationArray[i] *= mod;
      }
    }

    return normalizationArray;
  }
}