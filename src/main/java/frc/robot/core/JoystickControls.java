package frc.robot.core;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ControlType;

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
            OI.intake_motor.set(ControlMode.PercentOutput, .75);
            OI.hopper_motor.set(ControlMode.PercentOutput, .6);
        } else if (OI.gamepad.getRawButtonPressed(RobotMap.B_BUTTON)) {
            OI.intake_motor.set(ControlMode.PercentOutput, -.8);
            OI.hopper_motor.set(ControlMode.PercentOutput, -.6);
        }
    if (OI.gamepad.getRawButtonReleased(RobotMap.A_BUTTON)) {
        OI.intake_motor.set(ControlMode.PercentOutput, 0);
        OI.hopper_motor.set(ControlMode.PercentOutput, 0);
    } else if (OI.gamepad.getRawButtonReleased(RobotMap.B_BUTTON)) {
        OI.intake_motor.set(ControlMode.PercentOutput, 0);
        OI.hopper_motor.set(ControlMode.PercentOutput, 0);
    }
    }
    public void shooterFunc(){
        OI.shooterPIDcontroller1.setReference(5700, ControlType.kVelocity);
        OI.shooterPIDcontroller2.setReference(5700, ControlType.kVelocity);
        if(OI.gamepad.getRawButtonPressed(RobotMap.R_TRIGGER)){
            OI.shooterPIDcontroller1.setReference(5700, ControlType.kVelocity);
            OI.shooterPIDcontroller2.setReference(5700, ControlType.kVelocity); 
            OI.shooterintakePID.setReference(1000, ControlType.kVelocity);
        } else if(OI.gamepad.getRawButtonReleased(RobotMap.R_TRIGGER)){
            OI.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
            OI.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);    
            OI.shooterintakePID.setReference(0, ControlType.kVelocity);
        }
    }

}
