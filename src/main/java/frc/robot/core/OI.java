package frc.robot.core;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.networktables.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANEncoder;



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

    public CANSparkMax shooter_motor1;
    public CANSparkMax shooter_motor2;
    public CANSparkMax shooter_intake;
    public static CANPIDController shooterPIDcontroller1;
    public static CANPIDController shooterPIDcontroller2;
    public static CANPIDController shooterintakePID;
    public CANEncoder shooter_encoder1;
    public CANEncoder shooter_encoder2; 

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

        shooter_motor1 = new CANSparkMax(14, MotorType.kBrushless);
        shooter_motor2 = new CANSparkMax(11, MotorType.kBrushless);
        shooter_intake = new CANSparkMax(12, MotorType.kBrushless);

        /*shooterPIDcontroller1.setP(0.0012000000);      //8e-80
        shooterPIDcontroller1.setI(.0000016);     //.25e-6
        shooterPIDcontroller1.setD(0.2);          //0
        shooterPIDcontroller1.setIZone(0);      //0
        shooterPIDcontroller1.setFF(.0005);         //.000015
        shooterPIDcontroller1.setOutputRange(0, 1);
        shooterPIDcontroller2.setP(0.0012000000);
        shooterPIDcontroller2.setI(.0000016);
        shooterPIDcontroller2.setD(0.2);
        shooterPIDcontroller2.setIZone(0);
        shooterPIDcontroller2.setFF(.0005);
        shooterPIDcontroller2.setOutputRange(-1, 0);
        shooterintakePID.setP(5e-5);
        shooterintakePID.setI(1e-6);
        shooterintakePID.setD(0);
        shooterintakePID.setIZone(0);
        shooterintakePID.setFF(0);
        shooterintakePID.setOutputRange(-1, 1);
        */
        
        shooterPIDcontroller1 = shooter_motor1.getPIDController();
        shooterPIDcontroller2 = shooter_motor2.getPIDController();
        shooterintakePID = shooter_intake.getPIDController();
    
    }
}
