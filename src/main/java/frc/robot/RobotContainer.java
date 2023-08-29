package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.SwerveConstants;
import frc.robot.commands.baseCommands.AbsoluteDrive;
import frc.robot.commands.baseCommands.AbsoluteFieldDrive;
import frc.robot.commands.baseCommands.TeleopDrive;
import frc.robot.subsystem.swerve.Swerve;

public class RobotContainer {

	Swerve swerve = new Swerve();

	CommandJoystick operatorController = new CommandJoystick(1);
	CommandXboxController driveController = new CommandXboxController(0);

	public RobotContainer() {
		configureBindings();

		// Applies deadbands and inverts controls because joysticks
		// are back-right positive while robot
		// controls are front-left positive
		AbsoluteDrive closedAbsoluteDrive = new AbsoluteDrive(
			swerve,
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftY(),
					SwerveConstants.LEFT_Y_DEADBAND
				),
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftX(),
					SwerveConstants.LEFT_X_DEADBAND
				),
			() -> -driveController.getRightX(),
			() -> -driveController.getRightY(),
			false
		);

		AbsoluteFieldDrive closedFieldAbsoluteDrive = new AbsoluteFieldDrive(
			swerve,
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftY(),
					SwerveConstants.LEFT_Y_DEADBAND
				),
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftX(),
					SwerveConstants.LEFT_X_DEADBAND
				),
			() -> driveController.getRightTriggerAxis(),
			false
		);
		TeleopDrive simClosedFieldRel = new TeleopDrive(
			swerve,
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftY(),
					SwerveConstants.LEFT_Y_DEADBAND
				),
			() ->
				MathUtil.applyDeadband(
					driveController.getLeftX(),
					SwerveConstants.LEFT_X_DEADBAND
				),
			() -> driveController.getRawAxis(2),
			() -> true,
			false,
			true
		);
		TeleopDrive closedFieldRel = new TeleopDrive(
			swerve,
			() ->
				MathUtil.applyDeadband(
					operatorController.getY(),
					SwerveConstants.LEFT_Y_DEADBAND
				),
			() ->
				MathUtil.applyDeadband(
					operatorController.getX(),
					SwerveConstants.LEFT_X_DEADBAND
				),
			() -> -operatorController.getRawAxis(3),
			() -> true,
			false,
			true
		);

		swerve.setDefaultCommand(
			!RobotBase.isSimulation()
				? closedAbsoluteDrive
				: closedFieldAbsoluteDrive
		);
	}

	void configureBindings() {
		driveController
			.a()
			.toggleOnTrue(new InstantCommand(() -> swerve.zeroGyro()));
	}

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
