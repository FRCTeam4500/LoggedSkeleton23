package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class OperatorController extends CommandJoystick {

	private static OperatorController instanceOperatorController = null;

	private OperatorController(int port) {
		super(port);
	}

	/**
	 * Creates a new instance of the OperatorController. If the instance is null, it will create a new one.
	 * Should be called
	 * @param port
	 * @return
	 */
	public static synchronized OperatorController getInstance(int port) {
		if (instanceOperatorController == null) {
			instanceOperatorController = new OperatorController(port);
		}
		return instanceOperatorController;
	}

	/**
	 * Returns the instance of the OperatorController. If the instance is null, it will return null.
	 * @return
	 */
	public static synchronized OperatorController getInstance() {
		return instanceOperatorController;
	}
}
