package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickDPad implements JoystickOverlord.JoystickChildSacrifice {

  private int mFov = -1;
  private Joystick mGamepad;
  private boolean isDown = true;
  private Command mCommand;

  public JoystickDPad(Joystick gamepad, int fov) {
    mFov = fov;
    mGamepad = gamepad;

    JoystickOverlord.AddAChildToTheSacrificialPool(this);
  }

  public void whenPressed(Command com) {
    this.mCommand = com;
  }

  @Override
  public void SacrificeYourself() {

    int pov = mGamepad.getPOV(0);

    if (pov == mFov) {
      if (!isDown) {
        isDown = true;
        mCommand.start();
      }
    } else {
      isDown = false;
    }
  }

}