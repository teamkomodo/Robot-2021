package frc.robot.core;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.*;

public class Robot extends TimedRobot {
    //import other files here
    public static RecursiveCode recursiveFunc;
    public frc.robot.commands.Init Init;

    @Override
    public void robotInit() {
        //Called when the robot is initializing
        Init = new Init("robotInit");
    }

    @Override
    public void robotPeriodic() {
        //Called when the robot is running (we probably wont use this)
    }

    @Override
    public void autonomousInit() {
        //Called when the robot is initializing
        Init = new Init("autonomousInit");
    }

    @Override
    public void autonomousPeriodic() {
        //put auto routine here
    }

    @Override
    public void teleopInit() {
        //Called when the teleop is initializing
        Init = new Init("teleopInit");
    }

    @Override
    public void teleopPeriodic() {
        //put teleop code here
        // OI.drive.arcadeDrive(OI.gamepad.getRawAxis(RobotMap.Ljoyy), OI.gamepad.getRawAxis(RobotMap.Ljoyx));
        recursiveFunc = new RecursiveCode();
    }

    @Override
    public void testInit() {
        //Called when the test mode is initializing (can be turned on in driver station)
        Init = new Init("testInit");
    }

    @Override
    public void testPeriodic() {
        //Called when the test mode is running (can be turned on in driver station)
    }
}
