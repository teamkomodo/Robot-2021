package frc.robot.core;
import edu.wpi.first.wpilibj.Joystick;


public final class OI {
    //init all joystics, motor controllers, and io devices here
    public Joystick gamepad;
    public OI(){
        //assign values here
        gamepad = new Joystick(robotMap.gamepad);
    }
}
