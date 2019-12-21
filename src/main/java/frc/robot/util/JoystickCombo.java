package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.util.JoystickOverlord.JoystickChildSacrifice;

public class JoystickCombo implements JoystickChildSacrifice {

  private int[] buttons;
  private Joystick gamepad;
  private Runnable run;

  public JoystickCombo(Joystick gamepad, int... buttons) {
    this.buttons = buttons;
    this.gamepad = gamepad;

    JoystickOverlord.AddAChildToTheSacrificialPool(this);
  }

  public void setRunnable(Runnable run) {
    this.run = run;
  }

  @Override
  public void SacrificeYourself() {
    int a = 0;

    for (int i = 0; i < buttons.length; i++) {
      if (gamepad.getRawButton(buttons[i])) {
        a += 1;
      }
    }

    if (a >= buttons.length) {
      run.run();
    }
  }

}