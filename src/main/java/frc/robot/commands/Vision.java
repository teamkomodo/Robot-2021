package frc.robot.commands;

/*
import edu.wpi.first.networktables.*;
import frc.robot.*;
import frc.robot.commands.Init;

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
public class Vision {
    String[] dataTypes = new String[]{"Lower Goal", "Feeder Station", "Robot", "Goal", "Ball", "Light", "Team Number", "Light", "Team Number", "Goal Center"};
    double[][] activeTargets = new double[][]{};

    //Double[] temparray = new Double[] {};
    public Vision() {
    }


    public void valueChanged() {                             //make sure to call this function recursively
        String[] defaultValue = new String[0];
        int size = Init.OI.vision.getStringArray(defaultValue).length;
        String[] visionArray = Init.OI.vision.getStringArray(defaultValue);
        final String table = Init.OI.vision.toString();
        activeTargets = new double[size][];
        // activeTargets[];
        for (int i = 0; i < size; i++) {
            activeTargets[i] = new double[]{Double.parseDouble(visionArray[i].split(", ")[0].substring(1).toString()), Double.parseDouble(visionArray[i].split(", ")[1]), Double.parseDouble(visionArray[i].split(", ")[2]), Double.parseDouble(visionArray[i].split(", ")[3]), Double.parseDouble(visionArray[i].split(", ")[4].substring(-1))};
        }
        System.out.print(activeTargets);
    }
}
