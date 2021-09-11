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

    public static CANSparkMax shooter_motor1;
    public static CANSparkMax shooter_motor2;
    public static CANSparkMax shooter_intake;
    public static CANPIDController shooterPIDcontroller1;
    public static CANPIDController shooterPIDcontroller2;
    public static CANPIDController shooterintakePID;
    public static CANEncoder shooter_encoder1;
    public static CANEncoder shooter_encoder2;
    public static CANEncoder shooter_intake_encoder;
    
    public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

    public OI() {
        //assign values here
        gamepad = new Joystick(RobotMap.GAMEPAD);
        lJoystick = new Joystick(1); // Change later
        rJoystick = new Joystick(2);
        motor1 = new WPI_TalonFX(12);
        motor2 = new WPI_TalonFX(13);
        motor3 = new WPI_TalonFX(15);
        motor4 = new WPI_TalonFX(11);
        motor2.follow(motor1);
        motor4.follow(motor3);

        kP = 5e-5; 
        kI = 1e-6;
        kD = 0; 
        kIz = 0; 
        kFF = 0.000156; 
        kMaxOutput = 1; 
        kMinOutput = -1;

        drive = new DifferentialDrive(motor1, motor3);

        table = NetworkTableInstance.getDefault().getTable("ObjectDetection");
        vision = table.getEntry("targets");

        hopper_motor = new TalonSRX(1);
        // climb motor 4, 5
        intake_motor = new TalonSRX(3);

        shooter_motor1 = new CANSparkMax(14, MotorType.kBrushless);
        shooter_motor2 = new CANSparkMax(11, MotorType.kBrushless);
        shooter_intake = new CANSparkMax(12, MotorType.kBrushless);
        shooterPIDcontroller1 = shooter_motor1.getPIDController();
        shooterPIDcontroller2 = shooter_motor2.getPIDController();
        shooterintakePID = shooter_intake.getPIDController();
        shooter_intake_encoder = shooter_intake.getEncoder();
        /*
        shooterPIDcontroller1.setP(0.0012000000);      //8e-80
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
        shooterintakePID.setFF(0.000156);
        shooterintakePID.setOutputRange(-1, 1);
        */

        shooterPIDcontroller1.setP(kP);
        shooterPIDcontroller1.setI(kI);
        shooterPIDcontroller1.setD(kD);
        shooterPIDcontroller1.setIZone(kIz);
        shooterPIDcontroller1.setFF(kFF);
        shooterPIDcontroller1.setOutputRange(kMinOutput, kMaxOutput);
        shooterPIDcontroller2.setP(kP);
        shooterPIDcontroller2.setI(kI);
        shooterPIDcontroller2.setD(kD);
        shooterPIDcontroller2.setIZone(kIz);
        shooterPIDcontroller2.setFF(kFF);
        shooterPIDcontroller2.setOutputRange(kMinOutput, kMaxOutput);
        shooterintakePID.setP(kP);
        shooterintakePID.setI(kI);
        shooterintakePID.setD(kD);
        shooterintakePID.setIZone(kIz);
        shooterintakePID.setFF(kFF);
        shooterintakePID.setOutputRange(kMinOutput, kMaxOutput);
        
    
    }
}
