package frc.robot.core;

import com.revrobotics.ControlType;

public final class RecursiveCode {
    public JoystickControls Drive;
    private static String driveType = "tankDrive";

    public RecursiveCode() {
        //call functions here (recursive)
        Drive = new JoystickControls();
        //this code will be run for as long as the robot is enabled
        if(driveType == "orchestraDrive") {
            Drive.driveFunc(driveType);
        } else {
            if(Globals.UserControl){
                Drive.driveFunc(driveType);
                Drive.intakeFunc();
                Drive.shooterFunc();
                Drive.climberFunc();
            }else{
                Drive.visionFunc();
            }
            
        }
    }
}
