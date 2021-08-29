package frc.robot.core;

//DON'T MESS WITH THIS FILE (unless you really want to i guess)

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
    private Main() {
    }

    public static void main(String... args) {
        RobotBase.startRobot(frc.robot.core.Robot::new);
    }
}
