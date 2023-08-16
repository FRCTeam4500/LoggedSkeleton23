package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

public class Constants {

	public static class TelemetryConstants {

		public static Mode getMode() {
			return RobotBase.isReal() ? Mode.REAL : Mode.REPLAY;
		}

		public static enum Mode {
			/** Running on a real robot. */
			REAL,

			/** Running a physics simulator. */
			SIM,

			/** Replaying from a log file.
			 *  TODO: Setup project for REPLAY mode.
			 */
			REPLAY,
		}
	}
}
