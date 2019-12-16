package frc.robot.commands.auto.routines;

import org.team997coders.spartanlib.math.Vector2;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.RobotMap;
import frc.robot.commands.arm.SetpointArm;
import frc.robot.commands.drive.OrientDrive;
import frc.robot.commands.grabber.MoveGrabber;

public class AutoPickupBucket extends CommandGroup {

  public AutoPickupBucket() {
    addSequential(new OrientDrive(new Vector2(0, RobotMap.FieldValues.STATION_TO_BUCKET_GRAB),
      RobotMap.Preferences.AUTO_DRIVE_SPEED, RobotMap.Preferences.AUTO_ROTATE_SPEED));
    addSequential(new SetpointArm(0, true));
    addSequential(new MoveGrabber(true));
    addSequential(new SetpointArm(40, true));
  }

}