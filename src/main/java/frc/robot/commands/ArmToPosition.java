/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArmToPosition extends Command {

	private double position;

	public ArmToPosition(double position) {
		requires(Robot.m_arm);
		this.position = position;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {

		Robot.m_arm.armToPositionTEMP(position);

	}

	@Override
	protected boolean isFinished() {
		return (Math.abs(Robot.m_arm.getEncoderTicks() - position) < RobotMap.Values.armTolerance);
	}

	@Override
	protected void end() {
		Robot.m_arm.setSpeed(0);
	}

	@Override
	protected void interrupted() {
		System.out.println("ArmToPosition command interrupted! :(");
		end();
	}
}