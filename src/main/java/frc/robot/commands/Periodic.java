package frc.robot.commands;
import frc.robot.core.*;
import frc.robot.core.JoystickControls;

public final class Periodic {
    //Init all initializers
    OI OI;
    frc.robot.core.RobotMap RobotMap;
    JoystickControls Drive;
    public Periodic(String periodicMode){
        //run all initializers
        switch(periodicMode){
            case "robotPeriodic":
                //robot Init
                OI = new OI();
                RobotMap = new RobotMap();
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