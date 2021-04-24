package frc.robot.core;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import frc.robot.core.Globalvaribles;
import edu.wpi.first.networktables.*;


public final class OI {
    //init all joystics, motor controllers, and io devices here
    public static Joystick gamepad;
    public WPI_TalonFX motor1;
    public WPI_TalonFX motor2;
    public WPI_TalonFX motor3;
    public WPI_TalonFX motor4;
    public static DifferentialDrive drive;
    public NetworkTable table;
    public NetworkTableEntry vision;




    public OI(){
        //assign values here
        gamepad = new Joystick(robotMap.gamepad);
        motor1 = new WPI_TalonFX(12);
        motor2 = new WPI_TalonFX(13);
        motor3 = new WPI_TalonFX(15);
        motor4 = new WPI_TalonFX(11);
        motor2.follow(motor1);
        motor4.follow(motor3);

        drive = new DifferentialDrive(motor1,motor3);

        table = NetworkTableInstance.getDefault().getTable("ObjectDetection");
        vision = table.getEntry("targets");
    }
}
