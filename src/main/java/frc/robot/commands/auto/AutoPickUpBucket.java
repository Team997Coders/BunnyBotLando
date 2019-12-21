/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.auto.*;
import frc.robot.commands.*;

public class AutoPickUpBucket extends CommandGroup {
  
    public AutoPickUpBucket() {
        addSequential(new AutoDriveForward(RobotMap.FieldValues.STATION_TO_BUCKET_GRAB)); //TODO
        addSequential(new ArmToPosition(RobotMap.Values.armGroundHeight));
        addSequential(new Grab(true));
        addSequential(new ArmToPosition(RobotMap.Values.armMaxEncoderTicks));
    }
    // Add Commands here:t
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  
}