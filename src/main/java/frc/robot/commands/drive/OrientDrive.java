package frc.robot.commands.drive;

import org.team997coders.spartanlib.math.MathUtils;
import org.team997coders.spartanlib.math.Vector2;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class OrientDrive extends Command {

  private double mMaxDriveSpeed = 0.0, mMaxRotateSpeed = 0.0, mGyroLock = Double.NaN;
  private Vector2 mDistance = null;
  private Vector2 mTravelled;

  public OrientDrive(Vector2 distance, double maxDriveSpeed, double maxRotateSpeed) {
    requires(Robot.mSwerve);
    mDistance = distance; mMaxDriveSpeed = maxDriveSpeed; mMaxRotateSpeed = maxRotateSpeed;
    mTravelled = new Vector2(0, 0);
  }

  public OrientDrive(Vector2 distance, double maxDriveSpeed, double maxRotateSpeed, double gyroLock) {
    requires(Robot.mSwerve);
    mDistance = distance; mMaxDriveSpeed = maxDriveSpeed; mMaxRotateSpeed = maxRotateSpeed;
    mTravelled = new Vector2(0, 0);
    mGyroLock = gyroLock;
  }

  @Override
  protected void initialize() {
    Robot.mSwerve.setDriveEncoders(0.0);
    if (!Double.isFinite(mGyroLock)) mGyroLock = Robot.mSwerve.getYaw();
  }

  @Override
  protected void execute() {
    double x = Robot.mSwerve.getSpeedVector(true).x * Robot.mDeltaT;
    double y = Robot.mSwerve.getSpeedVector(true).y * Robot.mDeltaT;
    mTravelled.x += x;
    mTravelled.y += y;

    double xOutput = MathUtils.clamp(
      (mDistance.x - mTravelled.x) * RobotMap.Values.DRIVE_FEET_CONSTANTS.P,
      -mMaxDriveSpeed, mMaxDriveSpeed
    );
    double yOutput = MathUtils.clamp(
      (mDistance.y - mTravelled.y) * RobotMap.Values.DRIVE_FEET_CONSTANTS.P,
      -mMaxDriveSpeed, mMaxDriveSpeed
    );

    double gyroOutput = MathUtils.clamp(
      (Robot.limRange(mGyroLock - Robot.mSwerve.getYaw(), -180, 180)) * RobotMap.Values.ROTATION_CORRECTION_CONSTANTS.P
      , -mMaxRotateSpeed, mMaxRotateSpeed
    );

    Robot.mSwerve.setSwerveInput(
      Robot.mSwerve.getSwerveData(yOutput, xOutput, gyroOutput, Robot.mSwerve.getYaw())
    );
  }

  @Override
  protected boolean isFinished() {
    return
      MathUtils.epsilon(mTravelled.x, mDistance.x, 0.2) // X is good
      && MathUtils.epsilon(mTravelled.y, mDistance.y, 0.2) // Y is good
      && MathUtils.epsilon(mGyroLock, Robot.mSwerve.getYaw(), 3); // Yaw is good
  }

}