package frc.robot.core;

import com.ctre.phoenix.motorcontrol.ControlMode;


public final class JoystickControls {

    public String driveFunc(String name) {
        switch (name) {
            case "tankDrive":
                OI.drive.tankDrive(OI.lJoystick.getRawAxis(RobotMap.L_JOYSTICK_Y), OI.rJoystick.getRawAxis(RobotMap.R_JOYSTICK_Y));
                break;
            case "arcadeDrive":
                OI.drive.arcadeDrive(OI.rJoystick.getRawAxis(RobotMap.L_JOYSTICK_Y), OI.rJoystick.getRawAxis(RobotMap.L_JOYSTICK_X));
                break;
        }
        return name;
    }

    public void intakeFunc() {
        if (OI.gamepad.getRawButtonPressed(RobotMap.A_BUTTON)) {
            OI.intake_motor.set(ControlMode.PercentOutput, 1);
        } else if (OI.gamepad.getRawButtonPressed(RobotMap.B_BUTTON)) {
            OI.intake_motor.set(ControlMode.PercentOutput, -1);
        }
    }
}
