package frc.robot.core;
import frc.robot.core.OI;

import frc.robot.core.Globalvaribles;
import frc.robot.core.robotMap;

public final class Joystickcontrols {


    public Joystickcontrols(){
    }public String drive_funct(String name){
            switch (name){
                case "tankdrive":
                    OI.drive.tankDrive(OI.gamepad.getRawAxis(robotMap.Ljoyy), OI.gamepad.getRawAxis(robotMap.Rjoyy));
                    break;
                case "arcadedrive":
                    OI.drive.arcadeDrive(OI.gamepad.getRawAxis(robotMap.Ljoyy), OI.gamepad.getRawAxis(robotMap.Ljoyx));
                    break;
            }
    return name;      
    }
}
