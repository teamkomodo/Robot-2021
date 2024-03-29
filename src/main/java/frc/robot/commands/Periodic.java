package frc.robot.commands;

import frc.robot.core.JoystickControls;
import frc.robot.core.OI;

public final class Periodic {
    //Init all initializers
    OI OI;
    JoystickControls Drive;

    public Periodic(String periodicMode) {
        //run all initializers
        switch (periodicMode) {
            case "robotPeriodic":
                //robot Init
                OI = new OI();
                break;
            case "autonomousPeriodic":
                //auto Init
                break;
            case "teleopPeriodic":
                Drive = new JoystickControls();
                Drive.driveFunc("tankDrive");
                //teleop Init
                break;
            case "testPeriodic":
                //test Init
                break;
        }

    }
}