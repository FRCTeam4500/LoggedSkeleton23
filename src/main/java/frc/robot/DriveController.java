package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class DriveController extends CommandXboxController {

	private static DriveController instanceDriveController = null;

	private DriveController(int Connectedport) {
		super(Connectedport);
	}

	/**
	 * Creates a new instance of the controller. If the controller is null, it will create a new one.
	 * Should be called first before getIntstance() to ensure that the controller is not null.
	 * @param Connectedport
	 * @return controller type "DriveController"
	 */
	public static synchronized DriveController getInstance(int Connectedport) {
		if (instanceDriveController == null) {
			instanceDriveController = new DriveController(Connectedport);
		}
		return instanceDriveController;
	}

	/**
	 * Gets the instance of the controller. If the controller is null, it will return null.
	 * @return
	 */
	public static synchronized DriveController getInstance() {
		return instanceDriveController;
	}
}
