package frc.robot.core;

import com.ctre.phoenix.motorcontrol.ControlMode;


public final class JoystickControls {

    public DriveMode driveFunc(DriveMode driveMode) {
        switch (driveMode) {
            case TANK:
                OI.drive.tankDrive(OI.lJoystick.getRawAxis(RobotMapEnum.L_JOYSTICK_Y.getMap()), OI.rJoystick.getRawAxis(RobotMapEnum.R_JOYSTICK_Y.getMap()));
                break;
            case ARCADE:
                OI.drive.arcadeDrive(OI.rJoystick.getRawAxis(RobotMapEnum.L_JOYSTICK_Y.getMap()), OI.rJoystick.getRawAxis(RobotMapEnum.L_JOYSTICK_X.getMap()));
                break;
        }
        return driveMode;
    }

    public void intakeFunc() {
        if (OI.gamepad.getRawButtonPressed(RobotMapEnum.A_BUTTON.getMap())) {
            OI.intake_motor.set(ControlMode.PercentOutput, 1);
        } else if (OI.gamepad.getRawButtonPressed(RobotMapEnum.B_BUTTON.getMap())) {
            OI.intake_motor.set(ControlMode.PercentOutput, -1);
        }
    }
}
