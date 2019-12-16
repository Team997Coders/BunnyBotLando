package frc.robot.commands.auto.arsenal;

import org.team997coders.spartanlib.limelight.LimeLight;
import org.team997coders.spartanlib.math.MathUtils;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class VisionApproachTarget extends Command {

  private double mMaxTargetArea = 0.0, mMaxDriveSpeed = 0.0, mMaxRotateSpeed = 0.0, mGyroLock = Double.NaN;

  public VisionApproachTarget(double maxTargetArea, double maxDriveSpeed, double maxRotateSpeed) {
    requires(Robot.mSwerve);
    mMaxTargetArea = maxTargetArea; mMaxDriveSpeed = maxDriveSpeed; mMaxRotateSpeed = maxRotateSpeed;
  }

  public VisionApproachTarget(double maxTargetArea, double maxDriveSpeed, double maxRotateSpeed, double gyroLock) {
    requires(Robot.mSwerve);
    mMaxTargetArea = maxTargetArea; mMaxDriveSpeed = maxDriveSpeed; mMaxRotateSpeed = maxRotateSpeed; mGyroLock = gyroLock;
  }

  @Override
  protected void initialize() {
    if (!Double.isFinite(mGyroLock)) mGyroLock = Robot.mSwerve.getYaw();
  }

  @Override
  protected void execute() {
    double xOutput = 0.0, yOutput = 0.0, gyroOutput = 0.0;

    if (Robot.mLimeLight.getDouble(LimeLight.TARGET_VISIBLE, 0.0) != 0) {
      yOutput = MathUtils.clamp(
        (mMaxTargetArea - Robot.mLimeLight.getDouble(LimeLight.TARGET_AREA, 0.0)) * RobotMap.Values.DRIVE_TARGET_CONSTANTS.P,
        -mMaxRotateSpeed, mMaxRotateSpeed
      );

      xOutput = MathUtils.clamp(
        -(Robot.mLimeLight.getDouble(LimeLight.TARGET_X, 0.0) - Robot.mSwerve.getYaw()) * RobotMap.Values.STRAFE_TARGET_CONSTANTS.P,
        -mMaxDriveSpeed, mMaxDriveSpeed
      );
    }

    gyroOutput = MathUtils.clamp(
      (Robot.limRange(mGyroLock - Robot.mSwerve.getYaw(), -180, 180)) * RobotMap.Values.ROTATION_CORRECTION_CONSTANTS.P,
      -mMaxRotateSpeed, mMaxRotateSpeed
    );

    Robot.mSwerve.setSwerveInput(
      Robot.mSwerve.getSwerveData(yOutput, xOutput, gyroOutput, Robot.mSwerve.getYaw())
    );
  }

  @Override
  protected boolean isFinished() {
    // Close enough to the target
    return MathUtils.epsilon(mMaxTargetArea, Robot.mLimeLight.getDouble(LimeLight.TARGET_AREA, 0.0), 0.1);
  }

}