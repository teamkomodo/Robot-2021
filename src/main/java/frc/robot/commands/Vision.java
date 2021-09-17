package frc.robot.commands;
import frc.robot.core.*;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Vision {
    double dA;
    double sA;
    public Vision(double distance, int pipeline, double scaler) {
        OI.table = NetworkTableInstance.getDefault().getTable("limelight");
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
                sA*=1.25;
            }
            if(sA>1){
                sA = 1;
            } else if (sA<-1){
                sA = -1;
            } else if (sA<.5 && sA>.016){
                sA=.5;
            } else if (sA<-.5 && sA>-.016){
                sA=-.5;
            } else if (sA>-.035 && sA<.035){
                sA=0;

            }
            if(dA>-.1 && dA<.1 && sA>-.035 && sA<.035){
                // Globalvariables.Shootflag = true;
                Globals.LEDmode = 1;
            } else{
                // Globalvariables.Shootflag = false;
                Globals.LEDmode = 6;
            }
            sA*=-1;



            OI.temp1 = sA;
            OI.temp2 = dA;
            OI.drive.arcadeDrive(dA,sA);
        } else{
            OI.drive.tankDrive(0,0);
            Globals.LEDmode = 2;
        }
    }
}
