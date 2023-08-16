package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

	public RobotContainer() {} // TODO: Create Constructor Methods

	public Command getAutonomousCommand() {
		return null; // TODO: CHANGE
	}

	public void teleopInit() {
		Command auton = getAutonomousCommand();
		if (auton != null) {
			auton.cancel();
		}
	}

	public void disabledInit() {}
}
