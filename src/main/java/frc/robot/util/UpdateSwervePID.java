package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class UpdateSwervePID {

  public double lastP, lastI, lastD;

  public UpdateSwervePID() {
    lastP = RobotMap.Values.azimuthP;
    lastI = RobotMap.Values.azimuthI;
    lastD = RobotMap.Values.azimuthD;

    SmartDashboard.putNumber("swerve/aziP", lastP);
    SmartDashboard.putNumber("swerve/aziI", lastI);
    SmartDashboard.putNumber("swerve/aziD", lastD);

    SmartDashboard.setPersistent("swerve/aziP");
    SmartDashboard.setPersistent("swerve/aziI");
    SmartDashboard.setPersistent("swerve/aziD");
  }

  public void Update() {
    double p = SmartDashboard.getNumber("swerve/aziP", 0.0);
    double i = SmartDashboard.getNumber("swerve/aziI", 0.0);
    double d = SmartDashboard.getNumber("swerve/aziD", 0.0);

    if ((p != lastP || i != lastI) || d != lastD) {
      Robot.swerve.updateAzimuthPID(p, i, d);
    }
  }

}