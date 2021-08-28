package frc.robot.core;

public final class recursiveCode {
    public recursiveCode() {
        recursiveFunc();
    }
    //declare functions here 
    public joystickControls Drive;
    public void recursiveFunc(){
        //call functions here (recursive)
        Drive = new joystickControls();
        //this code will be run for as long as the robot is enabled
        Drive.driveFunc("arcadeDrive");
        Drive.intakeFunc();
    }

}
