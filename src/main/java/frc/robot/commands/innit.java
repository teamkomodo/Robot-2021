package frc.robot.commands;
import frc.robot.core.*;

public final class innit {
    //init all initializers
    OI oi;
    robotMap RobotMap;
    public innit(String initMode){
        //run all initializers
        switch(initMode){
            case "robotInit":
                //robot init
                oi = new OI();
                RobotMap = new robotMap();
            break;
            case "autonomousInit":
                //auto init
            break;
            case "teleopInit":
                //teleop init
            break;
            case "testInit":
                //test init
            break;
        }

    }
}
