package frc.robot.core;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;
import edu.wpi.first.networktables.*;
import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Servo;



public final class OI {
    //Init all joysticks, motor controllers, and io devices here
    public static Joystick gamepad;
    public static Joystick lJoystick;
    public static Joystick rJoystick;
    public static WPI_TalonFX motor1;
    public static WPI_TalonFX motor2;
    public static WPI_TalonFX motor3;
    public static WPI_TalonFX motor4;
    public static DifferentialDrive drive;
    public static NetworkTable table;
    public static NetworkTableEntry vision;

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

    public static AHRS navx;

    public static Servo swivle;

    public static Orchestra mainOrchestra;
    
    public static double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

    public static NetworkTableEntry tx;
    public static NetworkTableEntry ty;
    public static NetworkTableEntry ta;
    public static NetworkTableEntry tv;

    public static double lx;
    public static double ly;
    public static double la;
    public static double lv;

    public static double temp1;
    public static double temp2;

    public static Timer shotclock_timer;
    public static Timer intake_timer;
    public static Timer anitclog_timer;
    public static Timer Limelight_timer;
    public static Timer ball_timer;
    public static Timer revolver_timer;
    public static Timer revolver_timer_delay;
    public static Timer cL_timer;
    public static Timer auto_timer;
    public static Timer auto_hopper_tTimer;
    public static Timer target_blocked_Timer;

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

        swivle = new Servo(0);

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
        
        mainOrchestra = new Orchestra();
        mainOrchestra.addInstrument(new TalonFX(motor1.getDeviceID()));
        mainOrchestra.addInstrument(new TalonFX(motor2.getDeviceID()));
        mainOrchestra.addInstrument(new TalonFX(motor3.getDeviceID()));
        mainOrchestra.addInstrument(new TalonFX(motor4.getDeviceID()));
        mainOrchestra.loadMusic("mainOrchestra.chrp");

    }
}
