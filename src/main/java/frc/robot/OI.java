package frc.robot;

import frc.robot.commands.intake.MoveIntake;
import frc.robot.commands.arm.SetpointArm;
import frc.robot.commands.drive.SetModuleAngle;
import frc.robot.commands.drive.ZeroSwerve;

import org.team997coders.spartanlib.oi.controllers.Logitech;

/**
 * TODO: Maybe we should make this a static class???
 */
public class OI {

  private Logitech mGamepad1, mGamepad2;

  public OI() {

    mGamepad1 = new Logitech(RobotMap.Ports.GAMEPAD_1);
    mGamepad2 = new Logitech(RobotMap.Ports.GAMEPAD_2);
    
    mGamepad2.mRightBumper.whileHeld(new MoveIntake(RobotMap.Preferences.INTAKE_SPEED_OUT));
    mGamepad2.mLeftBumper.whileActive(new MoveIntake(RobotMap.Preferences.INTAKE_SPEED_IN)); // MARK: Not too sure wtf is going on here

    if (Robot.IS_TUNING) {
      mGamepad1.mA.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 0));
      mGamepad1.mB.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 90));
      mGamepad1.mX.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 180));
      mGamepad1.mY.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 45));
    } else {
      mGamepad1.mA.whenPressed(new ZeroSwerve());
    }

    mGamepad2.mA.whenPressed(new SetpointArm(0.0, false));
    mGamepad2.mY.whenPressed(new SetpointArm(RobotMap.Values.ARM_DEGREES_RANGE, false));
    mGamepad2.mX.whenPressed(new SetpointArm(40, false));
  }

  public Logitech getGamepad1() { return mGamepad1; }
  public Logitech getGamepad2() { return mGamepad2; }

}
