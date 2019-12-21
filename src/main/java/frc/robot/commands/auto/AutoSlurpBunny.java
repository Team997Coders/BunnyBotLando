package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class AutoSlurpBunny extends CommandGroup {

  public AutoSlurpBunny() {
    addSequential(new SetArmAngle(RobotMap.Values.armBunny));
    addSequential(new ConveyorMove(-1), 3);
    addSequential(new SetArmAngle(RobotMap.Values.armUp));

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