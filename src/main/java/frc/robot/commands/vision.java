package frc.robot.commands;
import edu.wpi.first.networktables.*;
import frc.robot.*;

public class vision {
String[] dataTypes = new String[] {"Lower Goal", "Feeder Station", "Robot", "Goal", "Ball", "Light", "Team Number", "Light", "Team Number", "Goal Center"};
String[] activeTargets = new String[] {};
    public vision(){

    }
    
    public void valueChanged(String table, String key, String[] value, String isNew){
        if(key=="targets"){
            activeTargets= new String[] {};
            for(String x: value){
                //idk how to convert the stuff in here
            }
            System.out.print(activeTargets);

        }
    }

    public void connectionListener(String connected, String info){
       // System.out.print(info+ "; Connected=%s", connected);
    }
}
