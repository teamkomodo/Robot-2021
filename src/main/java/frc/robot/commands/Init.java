package frc.robot.commands;

import frc.robot.core.*;

public final class Init {
    //Init all initializers
    public static OI OI;

    public Init(InitMode initMode) {
        //run all initializers
        switch (initMode) {
            case ROBOT:
                //robot Init
                OI = new OI();
                break;
            case AUTONOMOUS:
                //auto Init
                break;
            case TELEOP:
                //teleop Init
                break;
            case TEST:
                //test Init
                break;
        }

    }
}
