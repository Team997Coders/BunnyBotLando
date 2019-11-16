package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.SetModuleAngle;
import frc.robot.commands.ZeroSwerve;
import org.team997coders.spartanlib.math.MathUtils;

public class OI {

  private Joystick gamepad;

  private JoystickButton mA, mB, mX, mY;

  public OI() {
    gamepad = new Joystick(0);

    mA = new JoystickButton(gamepad, 1);
    mB = new JoystickButton(gamepad, 2);
    mX = new JoystickButton(gamepad, 3);
    mY = new JoystickButton(gamepad, 4);

    if (Robot.IS_TUNING) {
      mA.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 0));
      mB.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 90));
      mX.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 180));
      mY.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 45));
    } else {
      mA.whenPressed(new ZeroSwerve());
    }
  }

  public double getAxis(int axis) {
    return MathUtils.deadband(gamepad.getRawAxis(axis), 0.05);
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
