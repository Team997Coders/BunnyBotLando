package frc.robot.util;

import java.util.ArrayList;

public class JoystickOverlord {

  private static ArrayList<JoystickChildSacrifice> mMyChildren;

  public static void CommenceTheRitual() {
    mMyChildren.forEach(x -> x.SacrificeYourself());
  }

  public static void AddAChildToTheSacrificialPool(JoystickChildSacrifice sacrifice) {
    mMyChildren.add(sacrifice);
  }

  public interface JoystickChildSacrifice {
    public void SacrificeYourself();
  }

}