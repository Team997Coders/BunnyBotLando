package frc.robot;

import java.io.IOException;

import org.team997coders.spartanlib.helpers.threading.SpartanRunner;
import org.team997coders.spartanlib.limelight.LimeLight;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.auto.routines.AutoDoNothing;
import frc.robot.commands.auto.routines.AutoOneBunny;
import frc.robot.commands.auto.routines.AutoPickupBucket;
import frc.robot.commands.auto.routines.AutoTouchABucket;
import frc.robot.commands.auto.routines.AutoVisionPickupBucket;
import frc.robot.subsystems.Swerve;
import frc.robot.util.ConstantsManager;
import frc.robot.util.UpdateSwervePID;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;

public class Robot extends TimedRobot {

  // General Use
  private long mLastUpdate = 0;
  public static long mDeltaT = 0;
  
  // Tuning Stuff
  public static final boolean IS_TUNING = true;
  public static final int TUNING_ID = 0;

  // Subsystems
  public static Intake mIntake;
  public static Arm mArm;
  public static Swerve mSwerve;
  public static OI mOi;
  public static SpartanRunner mRunner;
  public static LimeLight mLimeLight;
  private UpdateSwervePID mPidTuner = null;

  private Command mAutonomousCommand;
  private SendableChooser<Command> mChooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    try { ConstantsManager.Init(); }
    catch (IOException e) { e.printStackTrace(); }

    if (IS_TUNING) mPidTuner = new UpdateSwervePID(TUNING_ID); // Set to tune front right module

    mRunner = new SpartanRunner(20);
    mSwerve = new Swerve();
    mIntake = new Intake();
    mArm = new Arm();
    mLimeLight = new LimeLight();

    mOi = new OI();

    mChooser.setDefaultOption("Do Nothing", new AutoDoNothing());
    mChooser.addOption("Pickup 1 Bunny", new AutoOneBunny());
    mChooser.addOption("Touch Bucket", new AutoTouchABucket());
    mChooser.addOption("Pickup Bucket", new AutoPickupBucket());
    mChooser.addOption("Vision Pickup Bucket", new AutoVisionPickupBucket());
    SmartDashboard.putData("Auto mode", mChooser);

    displayConstants();
    //displayConstants(RobotMap.class, "");
  }
  
  @Override
  public void robotPeriodic() {
    updateSmartDashboard();

    mDeltaT = System.currentTimeMillis() - mLastUpdate;
  }

  @Override
  public void disabledInit() {
    if (ConstantsManager.hasInit) ConstantsManager.SaveData();
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

    if (ConstantsManager.hasInit) ConstantsManager.LoadData();
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

    if (ConstantsManager.hasInit) ConstantsManager.LoadData();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() { }

  public void updateSmartDashboard() {
    mSwerve.updateSmartDashboard();
    mIntake.updateSmartDashboard();
    mArm.updateSmartDashboard();
  }

  public static double limRange(double val, double min, double max) {
    while (val >= max) val -= Math.abs(min - max);
    while (val < min) val += Math.abs(min - max);
    return val;
  }

  public void displayConstants() {
    // TODO: Fill this with the constants until I can create the automatic one
  }

  /*public void displayConstants(Class cls, String parent) {
    for (Field f: cls.getFields()) {
      if (f.getType() == Class.class) {
        displayConstants(f.getClass(), parent + cls.getName() + "/");
      } else {
        if (f.getType() == double.class || f.getType() == int.class || f.getType() == String.class || f.getType() == boolean.class) {

        } else if (f.getType() == double[].class || f.getType() == int[].class) {
          
        }
      }
    }
  }*/

}
