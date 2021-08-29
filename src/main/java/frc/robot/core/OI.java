package frc.robot.core;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.networktables.*;


public final class OI {
    //Init all joysticks, motor controllers, and io devices here
    public static Joystick gamepad;
    public static Joystick lJoystick;
    public static Joystick rJoystick;
    public WPI_TalonFX motor1;
    public WPI_TalonFX motor2;
    public WPI_TalonFX motor3;
    public WPI_TalonFX motor4;
    public static DifferentialDrive drive;
    public NetworkTable table;
    public NetworkTableEntry vision;

    public static TalonSRX intake_motor;
    public static TalonSRX cp_motor;
    public static TalonSRX hopper_motor;
    public static TalonSRX outake_motor;

    /* public CANSparkMax shooter_motor1;
    public CANSparkMax shooter_motor2;
    public CANSparkMax shooter_intake;
    public CANPIDController shooterPIDcontroller1;
    public CANPIDController shooterPIDcontroller2;
    public CANPIDController shooterintakePID;
    public CANEncoder shooter_encoder1;
    public CANEncoder shooter_encoder2; */

    public OI() {
        //assign values here
        gamepad = new Joystick(RobotMap.GAMEPAD);
        lJoystick = new Joystick(0); // Change later
        rJoystick = new Joystick(1);
        motor1 = new WPI_TalonFX(12);
        motor2 = new WPI_TalonFX(13);
        motor3 = new WPI_TalonFX(15);
        motor4 = new WPI_TalonFX(11);
        motor2.follow(motor1);
        motor4.follow(motor3);

        drive = new DifferentialDrive(motor1, motor3);

        table = NetworkTableInstance.getDefault().getTable("ObjectDetection");
        vision = table.getEntry("targets");

        hopper_motor = new TalonSRX(1);
        // climb motor 4, 5
        intake_motor = new TalonSRX(3);
    }
}
