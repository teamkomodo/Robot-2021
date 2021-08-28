package frc.robot.commands;
import frc.robot.core.*;
import frc.robot.core.joystickControls;

public final class periodic {
    //init all initializers
    OI oi;
    robotMap RobotMap;
    Globalvaribles globalvaribles;
    joystickControls Drive;
    public periodic(String pediodicMode){
        //run all initializers
        switch(pediodicMode){
            case "robotPeriodic":
                //robot init
                oi = new OI();
                globalvaribles = new Globalvaribles();
                RobotMap = new robotMap();
            break;
            case "autonomousPeriodic":
                //auto init
            break;
            case "teleopPeriodic":
                Drive = new joystickControls();
                Drive.driveFunc("tankDrive");
                //teleop init
            break;
            case "testPeriodic":
                //test init
            break;
        }

    }
}