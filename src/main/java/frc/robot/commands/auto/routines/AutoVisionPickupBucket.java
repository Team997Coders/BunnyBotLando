package frc.robot.commands.auto.routines;

import org.team997coders.spartanlib.math.Vector2;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.drive.OrientDrive;

public class AutoVisionPickupBucket extends CommandGroup {

  public AutoVisionPickupBucket() {
    addSequential(new OrientDrive(new Vector2(0, 4),
      RobotMap.Preferences.AUTO_DRIVE_SPEED, RobotMap.Preferences.AUTO_ROTATE_SPEED,
      -90)); // TODO: Fix gyro correction
  }

}