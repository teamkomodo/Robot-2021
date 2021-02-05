package frc.robot.core;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.*;

public class Robot extends TimedRobot {
  //import other files here
  public static recursiveCode RecursiveCode;
  public init Init;

  @Override
  public void robotInit() {
    //Called when the robot is initializing 
    Init = new init("robotInit");
  }

  @Override
  public void robotPeriodic() {
    //Called when the robot is running (we probably wont use this)
  }

  @Override
  public void autonomousInit() {
    //Called when the robot is initializing 
    Init = new init("autonomousInit");
  }
  
  @Override
  public void autonomousPeriodic() {
    //put auto routine here
  }

  @Override
  public void teleopInit() {
    //Called when the teleop is initializing 
    Init = new init("teleopInit");
  }

  @Override
  public void teleopPeriodic() {
    //put teleop code here
    RecursiveCode = new recursiveCode();
  }

  @Override
  public void testInit() {
    //Called when the test mode is initializing (can be turned on in driver station)
    Init = new init("testInit");
  }

  @Override
  public void testPeriodic() {
    //Called when the test mode is running (can be turned on in driver station)
  }
}
