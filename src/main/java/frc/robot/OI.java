package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ConveyorMove;
import frc.robot.commands.drive.SetModuleAngle;
import frc.robot.commands.drive.ZeroSwerve;

import org.team997coders.spartanlib.gamepad.Logitech;
import org.team997coders.spartanlib.math.MathUtils;

public class OI {

  private Joystick[] mGamepads;

  private JoystickButton mA, mB, mX, mY;
  private JoystickButton mRightBumper, mLeftBumper;

  public OI() {

    mGamepads = new Joystick[5];

    mGamepads[RobotMap.Ports.GAMEPAD_1] = new Joystick(RobotMap.Ports.GAMEPAD_1);
    mGamepads[RobotMap.Ports.GAMEPAD_2] = new Joystick(RobotMap.Ports.GAMEPAD_2);

    mA = new JoystickButton(mGamepads[0], 1);
    mB = new JoystickButton(mGamepads[0], 2);
    mX = new JoystickButton(mGamepads[0], 3);
    mY = new JoystickButton(mGamepads[0], 4);

    mRightBumper = new JoystickButton(mGamepads[0], Logitech.Buttons.RIGHT_BUMPER);
    mLeftBumper = new JoystickButton(mGamepads[0], Logitech.Buttons.LEFT_BUMPER);
    
    mRightBumper.whileHeld(new ConveyorMove(RobotMap.Preferences.INTAKE_SPEED_OUT));
    mLeftBumper.whileHeld(new ConveyorMove(RobotMap.Preferences.INTAKE_SPEED_IN)); // MARK: Not too sure wtf is going on here

    if (Robot.IS_TUNING) {
      mA.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 0));
      mB.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 90));
      mX.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 180));
      mY.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 45));
    } else {
      mA.whenPressed(new ZeroSwerve());
    }
  }

  public double getAxis(int gamepad, int axis) {
    return MathUtils.deadband(mGamepads[gamepad].getRawAxis(axis), 0.05);
  }

}
