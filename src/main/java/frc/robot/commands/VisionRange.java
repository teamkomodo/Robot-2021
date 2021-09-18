package frc.robot.commands;
import frc.robot.core.OI;
import frc.robot.core.Globals;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class VisionRange {
    double dA;
    double sA;
    public VisionRange(double distance, double deviation, int pipeline, double scaler) {
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
            // if(OI.la<distance-deviation || OI.la>distance+deviation){
            //     sA = OI.lx / 20;
            //     if(sA>1){
            //         sA = 1;
            //     } else if (sA<-1){
            //         sA = -1;
            //     }
            //         sA*=-1;
            //     OI.drive.arcadeDrive(0,sA);
            //     Globals.LEDmode=1;
            // } else {
            Globals.LEDmode=5;
            dA=(OI.la-distance)*1.05;
            dA *= -1;
            sA = OI.lx / 20;
            if(dA>1){
                dA = 1;
            } else if (dA<-1){
                dA = -1;
            } else if (dA<.5 && dA>.1){
                dA=.5;
            } else if (dA>-.5 && dA<-.06){
                dA=-.5;
            } else if (dA>-.1 && dA<.1){
                dA=0;
                //sA*=1.25;
            }
            // if (sA<.5 && sA>.016){
            //     sA=.5;
            // } else if (sA<-.5 && sA>-.016){
            //     sA=-.5;
            // } else if (sA>-.035 && sA<.035){
            //     sA=0;

            // }
            if(dA>-.1 && dA<.1 && sA>-.035 && sA<.035){
                // Globals.Shootflag = true;
                // Globals.LEDmode = 1;
            } else{
                // Globals.Shootflag = false;
                // Globals.LEDmode = 6;
            }
            sA*=-1;
            if(OI.la-(deviation*2)<distance && OI.la+(deviation*2)>distance){
                dA=0;
                if(sA<0.2 && sA>-.2){
                    sA*=4;
                    Globals.LEDmode = 10;
                    Globals.ball_counter--;
                } else if((sA<.5 && sA >.3) || (sA>-.5&&sA<-.3)){
                    sA*=2;
                } else if((sA<.3 && sA >.2) || (sA>-.3&&sA<-.2)){
                    sA*=3;
                }
            }
            if(sA>.5){
                sA = .5/sA;
            } else if (sA<-.5){
                sA = -.5/sA;
            }
            OI.temp1 = sA;
            OI.temp2 = dA;
            OI.drive.arcadeDrive(dA,sA);
            // }
        } else{
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