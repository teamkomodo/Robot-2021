package frc.robot.core;
import frc.robot.commands.*;
import frc.robot.core.*;

public final class recursiveCode {
    //declare functions here 
    public Joystickcontrols Drive;
    public void recursivecode(){

        //call functions here (recursive)
        Drive = new Joystickcontrols();
        //this code will be run for as long as the robot is enabled
        Drive.drive_funct("tankDrive");
    }
}
