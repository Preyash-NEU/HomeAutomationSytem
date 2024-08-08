package edu.neu.csye7374.CompositePattern;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;

public abstract class SmartSpeakerDevices implements SmartDevice {

    public String volumeUp(int volume){
    	int v = ++volume;
        System.out.println("\t\tLatest Volume is "+(v));
        return "\t\tLatest Volume is "+(v);
    }
    public String volumeDown(int volume){
    	int v = --volume;
        System.out.println("\t\tLatest Volume is "+(v));
        return "\t\tLatest Volume is "+(v);
    }
}
