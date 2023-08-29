package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.RobotBase;
import swervelib.math.Matter;
import swervelib.parser.PIDFConfig;

public class Constants {

	public static class SwerveModuleConstants {

		public static final double[] kTurnPID = { 0.8, 0, 0 };
		public static final double kNEOSteerP = 3.0;

		/*
		 * {Static Gain, FeedForward, Proportional Gain, ModuleID for Tuning}
		 */
		public static final double[] kFrontLeftTuningVals = {
			0.015,
			0.19,
			0.15,
			0,
		};
		public static final double[] kFrontRightTuningVals = {
			0.015,
			0.19,
			0.15,
			1,
		};
		public static final double[] kBackLeftTuningVals = {
			0.015,
			0.19,
			0.15,
			2,
		};
		public static final double[] kBackRightTuningVals = {
			0.015,
			0.19,
			0.15,
			3,
		};
	}

	public static class SwerveConstants {

		public static final double ROBOT_MASS = 125 * 0.453592; // 32lbs * kg per pound
		public static final Matter CHASSIS = new Matter(
			new Translation3d(0, 0, Units.inchesToMeters(8)),
			ROBOT_MASS
		);
		public static final double LOOP_TIME = 0.10; // velocity lag and command loop time (seconds)

		public static final PIDFConfig xAutoPID = new PIDFConfig(0.7, 0, 0);
		public static final PIDFConfig yAutoPID = new PIDFConfig(0.7, 0, 0);
		public static final PIDFConfig angleAutoPID = new PIDFConfig(
			0.4,
			0,
			0.01
		);

		public static final double MAX_SPEED = 4;
		public static final double MAX_ACCELERATION = 2;

		// Hold time on motor brakes when disabled
		public static final double WHEEL_LOCK_TIME = 10; // seconds

		// Joystick Deadband
		public static final double LEFT_X_DEADBAND = 0.01;
		public static final double LEFT_Y_DEADBAND = 0.01;
	}

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
