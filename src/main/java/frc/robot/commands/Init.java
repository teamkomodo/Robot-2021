package frc.robot.commands;
import frc.robot.core.*;

public final class Init {
    //Init all initializers
    public static OI OI;
    frc.robot.core.RobotMap RobotMap;
    public Init(String initMode){
        //run all initializers
        switch(initMode){
            case "robotInit":
                //robot Init
                OI = new OI();
                RobotMap = new RobotMap();
            break;
            case "autonomousInit":
                //auto Init
            break;
            case "teleopInit":
                //teleop Init
            break;
            case "testInit":
                //test Init
            break;
        }

    }
}
