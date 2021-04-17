package frc.robot.commands;
/*
import edu.wpi.first.networktables.*;
import frc.robot.*;
import frc.robot.commands.init;

/*

import sys
import time
from networktables import NetworkTables
import logging
dataTypes = ['Lower Goal', 'Feeder Station', 'Robot', 'Goal', 'Ball', 'Light', 'Team Number', 'Light', 'Team Number', 'Goal Center']
logging.basicConfig(level=logging.DEBUG)
NetworkTables.initialize("whatever the local ip for the jetson is (will need to be static)")
activeTargets = []


def valueChanged(table, key, value, isNew):
    #print("valueChanged: key: '%s'; value: %s; isNew: %s" % (key, value, isNew))
    if key == "targets":
        #print(value[0])
        global activeTargets
        activeTargets = []
        for x in value:
            activeTargets.append([float(x.split()[0][1:-3]), float(x.split()[1][1:-1]), float(x.split()[2][1:-1]), float(x.split()[3][1:-1]), float(x.split()[4][1:-1])])
        print(activeTargets)
        
        
def connectionListener(connected, info):
    print(info, "; Connected=%s" % connected)


NetworkTables.addConnectionListener(connectionListener, immediateNotify=True)
sd = NetworkTables.getTable("ObjectDetection")
sd.addEntryListener(valueChanged)

while True:
    time.sleep(1)

*/
/*
public class vision {
String[] dataTypes = new String[] {"Lower Goal", "Feeder Station", "Robot", "Goal", "Ball", "Light", "Team Number", "Light", "Team Number", "Goal Center"};
int[] activeTargets = new int[] {};
Double[] temparray = new Double[] {};
    public vision(){

    }
    
    public void valueChanged(){
        int size = init.oi.table.getInstance().length;
        String table = init.oi.table.toString();
        if(key=="targets"){
            activeTargets= new int[size];
           // activeTargets[];
            for(int i =0;i < size;i++){

                temparray = new Double[Double.parseDouble(table.split(", ")[0].substring(1)), Double.parseDouble(table.split(", ")[1]),Double.parseDouble(table.split(", ")[2]),Double.parseDouble(table.split(", ")[3]),Double.parseDouble(table.split(", ")[4].substring(-1)))];
                
                activeTargets[i] = [float(x.split()[0][1:-3]), float(x.split()[1][1:-1]), float(x.split()[2][1:-1]), float(x.split()[3][1:-1]), float(x.split()[4][1:-1])
              //  activeTargets.add([float(x.split()[0][1:-3]), float(x.split()[1][1:-1]), float(x.split()[2][1:-1]), float(x.split()[3][1:-1]), float(x.split()[4][1:-1])])
            }
            System.out.print(activeTargets);

        }
    }

    public void connectionListener(String connected, String info){
       // System.out.print(info+ "; Connected=%s", connected);
    }
}
*/