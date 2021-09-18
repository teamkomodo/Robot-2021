package frc.robot.core;

public final class Globals {
    public static boolean driveDirection;
    public static int ball_counter;
    public static double LEDoffset=-.06;
    public static int LEDmode = 22;
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
    public static double revolverintakevarible;
    public static boolean angle;
    public static boolean check_flag;
    public static boolean angle_turn;
    public static boolean angle_flag;
    public static double speed;
    public static boolean tA_flag;
    public static double tA;
    public static boolean reverse;
    public static boolean Shootflag;
    public static double linecounter;
    public static boolean turn2angle;
    public static double turn1angle;
    public static int autonomous_stage;
    public static int stage_counter;
    public static double automode;
    public static boolean intake_flag;
    public static boolean intaketimer_flag;
    public static boolean anticlog_flag;
    public static boolean anticlogtimer_flag;
    public static boolean shooter_lineup;
    public static boolean RPM_good;
    public static boolean flip_flag;
    public static boolean ball_pickedup;
    public static double origonal_ball;
    public static int ball_stage_count;
    public static boolean ball_reset;
    public static double Vilocity1;
    public static boolean target_covered;
    public static boolean ball_intheintake;
    public static boolean revolver_delay_flag;
    public static boolean reset_ball_cycle;
    public static boolean Ball_down;
    public static boolean Ball_up;
    public static boolean antianti_flag;
    public static double distance_to_target;
    public Globals (){
        distance_to_target = 0;
        antianti_flag = false;
        reset_ball_cycle = false;
        revolver_delay_flag = false;
        ball_intheintake = false;
        target_covered = false;
        Vilocity1 = 0;
        ball_reset = false;
        origonal_ball = 0;
        ball_stage_count = 0;
        RPM_good = false;
        driveDirection = false;
        shooter_lineup= false;
        anticlogtimer_flag = false;
        anticlog_flag = false;
        revolverintakevarible = 0;
        intaketimer_flag = false;
        intake_flag = false;
        check_flag = false;
        Shootflag = false;
        angle = false;
        speed = 0.0;
        tA = 0.0;
        tA_flag = false;
        angle_turn = false;
        turn2angle = false;
        turn1angle = (0.0);
        Seetarget = false;
        SwitchFlag = false;
        VisionFlag = false;
        UserControl = true;
        vision = false;
        driveType = false;
        reverse = false;
        angle_flag = false;
        automode = 0;
        flip_flag = false;
        Ball_down = false;
        Ball_up = false;
        ball_counter = 3;
        autonomous_stage = 0; //use slider to change
        stage_counter = 0;

    }

}