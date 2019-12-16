package frc.robot.commands.auto.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.arm.SetpointArm;
import frc.robot.commands.intake.TimedIntake;

public class AutoOneBunny extends CommandGroup {

  public AutoOneBunny() {
    addSequential(new SetpointArm(0.0, true));
    addSequential(new TimedIntake(0.5, RobotMap.Preferences.INTAKE_SPEED_AUTO_IN));
    addSequential(new SetpointArm(RobotMap.Values.ARM_DEGREES_RANGE, true));
  }

}