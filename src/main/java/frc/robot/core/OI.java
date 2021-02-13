package frc.robot.core;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 

public final class OI {
    //init all joystics, motor controllers, and io devices here
    public Joystick gamepad;
    public TalonFX motor1;
    public TalonFX motor2;
    public TalonFX motor3;
    public TalonFX motor4;
    
    public OI(){
        //assign values here
        gamepad = new Joystick(robotMap.gamepad);
        motor1 = new WPI_TalonFX(12);
        motor2 = new WPI_TalonFX(13);
        motor3 = new WPI_TalonFX(15);
        motor4 = new WPI_TalonFX(11);
    }
}
