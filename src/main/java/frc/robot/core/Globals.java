package frc.robot.core;

public final class Globals {
    public static int ball_counter;
    public static double LEDoffset=-.06;
    public static int LEDmode = 12;
    public static boolean[] lineloopflag ={
            false,
            false
    };
    public static boolean Seetarget;
    public static boolean SwitchFlag;
    public static boolean VisionFlag;
    public static boolean UserControl;
    public static boolean[] buttonDone = {
            false,
            false,
            false
    };
    public static boolean vision;
    public static boolean driveType;
    public static boolean angle;
    public static boolean check_flag;
    public static boolean angle_turn;
    public static double speed;
    public static boolean tA_flag;
    public static double tA;
    public static boolean reverse;
    public static boolean Shootflag;
    public static double linecounter;
    public Globals(){
        check_flag = false;
        Shootflag = false;
        angle = false;
        speed = 0.0;
        tA = 0.0;
        tA_flag = false;
        angle_turn = false;
        Seetarget = false;
        SwitchFlag = false;
        VisionFlag = false;
        UserControl = true;
        vision = false;
        driveType = false;
        reverse = false;
        ball_counter = 3; //use slider to change
    }

}