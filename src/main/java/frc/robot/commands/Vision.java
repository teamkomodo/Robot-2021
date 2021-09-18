package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.core.OI;
import frc.robot.core.Globals;

public final class Vision {
    double dA;
    double sA;
    public Vision(double distance,  int pipeline, double scaler,float offset) {
        OI.table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
        OI.tx = OI.table.getEntry("tx");
        OI.ty = OI.table.getEntry("ty");
        OI.ta = OI.table.getEntry("ta");
        OI.tv = OI.table.getEntry("tv");
        OI.lx = OI.tx.getDouble(0.0);
        OI.ly = OI.ty.getDouble(0.0);
        OI.la = OI.ta.getDouble(0.0);
        OI.lv = OI.tv.getDouble(0.0);

        if(OI.lv != 0.0){
            dA=(OI.la-distance)*1.05;
            //sA = (OI.lx - offset) / 24;

            if(dA>-.1 && dA<.1 && sA>-.05 && sA<.05){
                // Globals.Shootflag = true;
                Globals.LEDmode = 10;
                Globals.ball_counter++;
            } else{
                // Globals.Shootflag = false;
                Globals.LEDmode = 6;
            }
            //sA*=-1.5;
            if(OI.lx < -4 ){
                Globals.shooter_lineup = false;
                sA = .35;
            }else if(OI.lx > 4){
                Globals.shooter_lineup = false;
                sA = -.35;
            }else if(OI.lx < -.5 && OI.lx > -4){
                Globals.shooter_lineup = false;
                sA = .3;
            }else if(OI.lx > .5 && OI.lx < 4){
                Globals.shooter_lineup = false;
                sA = -.3;
            }else if(OI.lx < .5 && OI.lx > -.5 ){
                Globals.shooter_lineup = true;
                sA = 0;
            }
            OI.drive.tankDrive(0,0);

            OI.motor1.set(ControlMode.Velocity,3);
            OI.motor3.set(ControlMode.Velocity,-3);





            // if(dA < .3 && sA <.3 && sA > -.3 && dA > -.3){
            //     Globals.shooter_lineup = true;

            // }else{
            //     Globals.shooter_lineup = false;
            // }
            // if(OI.lx > 10){
            //     sA=-.4;
            // }else if(OI.lx < -10){
            //     sA=.4;
            // }else if(OI.lx < 4 && OI.lx > -4 ){
            //     sA = .2;

            // }else if(OI.lx < 3 && OI.lx > -3 ){
            //     sA = .2;
            // }else if(OI.lx < 1 && OI.lx > -1 ){
            //     sA = 0;
            // }else if((OI.lx < 7 && OI.lx > 5 )||(OI.lx > -7 && OI.lx < -5)){
            //     sA*= 1.2;
            // }else if((OI.lx > 5 && OI.lx < 4 )||(OI.lx > -5 && OI.lx < -7)){
            //     sA = .3;
            // }

            if(sA > .5){
                sA = .5;
            }else if (sA < -.5){
                sA = -.5;
            }
            dA*= -2
            ;
            dA*=scaler;

            if(OI.limelight_timer.get() < .5){
                dA = 0;
            }
            dA = 0;
            OI.drive.arcadeDrive(dA,sA);
            SmartDashboard.putNumber("sAAAA", sA);
        }else{
            OI.drive.tankDrive(0,0);
            Globals.LEDmode = 2;
        }
    }

    // private void steerAdjust(double sA, double dA)
    // {
    //     if(dA>=0.1||dA<=-0.1)
    //     {
    //         return;
    //     }
    //     else{
    //         double sA2=OI.lx/5.0;
    //         if(sA2>=0.5)
    //         {
    //             sA2=0.5;
    //         }
    //         else{
    //             sA2=-0.5;
    //         }
    //         OI.drive.arcadeDrive(0, sA2);
    //     }
    // }
}