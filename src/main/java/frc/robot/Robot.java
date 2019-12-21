package frc.robot;

//test comment 2
import org.team997coders.spartanlib.helpers.threading.SpartanRunner;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.Swerve;
import frc.robot.util.UpdateSwervePID;

import frc.robot.commands.auto.*;
import frc.robot.commands.*;
//import frc.robot.commands.AutoDriveToBucket;
//import frc.robot.commands.AutoPickUpBucket;
//import frc.robot.commands.AutoPickUpBunny;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.Swerve;
import frc.robot.util.JoystickOverlord;
import frc.robot.util.UpdateSwervePID;

public class Robot extends TimedRobot {

  public static long mDeltaT = 0;
  private long mLastUpdate = 0;
  public static final boolean IS_TUNING = false;

  public static final int TUNING_ID = 3;

  public static Swerve mSwerve;
  public static OI mOi;
  public static Arm mArm;
  public static ConveyorBelt mIntake;
  public static SpartanRunner mRunner;
  private UpdateSwervePID mPidTuner = null;

  Command mAutonomousCommand;
  SendableChooser<Command> mChooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    if (IS_TUNING) mPidTuner = new UpdateSwervePID(TUNING_ID); // Set to tune front right module

    mRunner = new SpartanRunner(20);

    mSwerve = new Swerve();
    mArm = new Arm();
    mIntake = new ConveyorBelt();

    mOi = new OI();

    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    //chooser.addOption("My Auto", new MyAutoCommand());
    //chooser.addOption("Touch Bucket", new AutoDriveToBucket());
    //chooser.addOption("Pick up Bucket", new AutoPickUpBucket());
    //chooser.addOption("Pick up Bunnies", new AutoPickUpBunny()); //TODO: Add auto bases intake control before running this

    mChooser.setDefaultOption("Do Nothing", new AutoDoNothing());
    mChooser.addOption("Pick up bucket", new AutoPickUpBucket());
    mChooser.addOption("Slurp Bunny", new AutoSlurpBunny());
    SmartDashboard.putData("Auto mode", mChooser);
  }
  
  @Override
  public void robotPeriodic() {

    mSwerve.updateSmartDashboard();
    mIntake.updateSmartDashboard();
    mArm.updateSmartDashboard();

    mDeltaT = System.currentTimeMillis() - mLastUpdate;

    JoystickOverlord.CommenceTheRitual();
  }

  @Override
  public void disabledInit() {
    //arm.setAngle(arm.getPercentUp());
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    if (IS_TUNING) mPidTuner.update();
  }

  @Override
  public void autonomousInit() {
    mAutonomousCommand = mChooser.getSelected();

    if (mAutonomousCommand != null) {
      mAutonomousCommand.start();
    }

    //arm.stopUsingPID();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (mAutonomousCommand != null) {
      mAutonomousCommand.cancel();
    }

    //arm.stopUsingPID();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

}
