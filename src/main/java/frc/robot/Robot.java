/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.team997coders.spartanlib.helpers.threading.SpartanRunner;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoDoNothing;
import frc.robot.subsystems.Swerve;
import frc.robot.util.UpdateSwervePID;

public class Robot extends TimedRobot {

  public static final boolean IS_TUNING = true;

  public static final int TUNING_ID = 0;

  public static Swerve mSwerve;
  public static OI mOi;
  public static SpartanRunner mRunner;
  private UpdateSwervePID mPidTuner = null;

  Command mAutonomousCommand;
  SendableChooser<Command> mChooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    if (IS_TUNING) mPidTuner = new UpdateSwervePID(0); // Set to tune front right module

    mRunner = new SpartanRunner(20);

    mSwerve = new Swerve();

    mOi = new OI();
    mChooser.setDefaultOption("Do Nothing", new AutoDoNothing());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", mChooser);
  }
  
  @Override
  public void robotPeriodic() {
    mSwerve.updateSmartDashboard();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    mAutonomousCommand = mChooser.getSelected();

    if (mAutonomousCommand != null) {
      mAutonomousCommand.start();
    }
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
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    if (IS_TUNING) mPidTuner.update();
  }

  @Override
  public void testPeriodic() {
  }

}
