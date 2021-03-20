package frc.robot.commands;
import frc.robot.core.*;

public final class periodic {
    //init all initializers
    OI oi;
    robotMap RobotMap;
    Globalvaribles globalvaribles;
    drive Drive;
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
                Drive = new drive();
                //teleop init
            break;
            case "testPeriodic":
                //test init
            break;
        }

    }
}