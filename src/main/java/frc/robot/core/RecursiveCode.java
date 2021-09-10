package frc.robot.core;

public final class RecursiveCode {
    public JoystickControls Drive;

    public RecursiveCode() {
        //call functions here (recursive)
        Drive = new JoystickControls();
        //this code will be run for as long as the robot is enabled
        Drive.driveFunc("tankDrive");
        Drive.intakeFunc();
    }
}
