package frc.robot.core;
import frc.robot.core.OI;

import frc.robot.core.Globalvaribles;
import frc.robot.core.robotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;


public final class joystickControls {

    public joystickControls() {

    } 
    public String driveFunc(String name){
            switch (name){
                case "tankDrive":
                    OI.drive.tankDrive(OI.lJoystick.getRawAxis(robotMap.Ljoyy), OI.rJoystick.getRawAxis(robotMap.Rjoyy));
                    break;
                case "arcadeDrive":
                    OI.drive.arcadeDrive(OI.rJoystick.getRawAxis(robotMap.Ljoyy), OI.rJoystick.getRawAxis(robotMap.Ljoyx));
                    break;
            }
    return name;      
    }

    public void intakeFunc() {
        if(OI.gamepad.getRawButtonPressed(robotMap.abutton)) {
             OI.intake_motor.set(ControlMode.PercentOutput, 1);
        } else if(OI.gamepad.getRawButtonPressed(robotMap.bbutton)) {
            OI.intake_motor.set(ControlMode.PercentOutput, -1);
        }
    }
}
