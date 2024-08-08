package edu.neu.csye7374.CompositePattern;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartSpeaker implements SmartDevice {

    private String name;
    int volume = 10;
    private List<SmartSpeakerDevices> devices;
    boolean on;

    public SmartSpeaker(String name) {
        this.name = name;
        devices = new ArrayList<>();
    }

    @Override
    public String getObjectInfo() {
        StringBuilder output = new StringBuilder();
        output.append("SmartSpeaker name: ").append(name).append("\nList of Devices:\n");

        for (SmartDevice device : devices) {
            output.append(device.getObjectInfo()).append("\n");
        }

        return output.toString();
    }


    @Override
    public String turnOn() {
    	String output = "name + \" turned on\"";
        System.out.println(name + " turned on");
        for (SmartDevice device : devices) {
            output = device.turnOn() + "\n";
        }
        on = true;
        return output;
    }

    @Override
    public String turnOff() {
    	String output = "name + \" turned off\"";
        System.out.println(name + " turned off");
        for (SmartSpeakerDevices device : devices) {
            output = device.turnOff() + "\n";
        }
        on = false;
        return output;
    }

    public String addDevice(SmartSpeakerDevices device) {
        devices.add(device);
        return device.getObjectInfo();
    }

    public String removeDevice(SmartSpeakerDevices device) {
        System.out.println("\tRemoving:");
//        device.getObjectInfo();
        devices.remove(device);
        return "\tRemoving:" + device.getObjectInfo();
    }

    public String volumeUp() {
        StringBuilder output = new StringBuilder();
        for (SmartSpeakerDevices device : devices) {
            output.append(device.getObjectInfo()).append("\n").append(device.volumeUp(volume)).append("\n");
        }
        return output.toString();
    }

    public String volumeDown() {
        StringBuilder output = new StringBuilder();
        for (SmartSpeakerDevices device : devices) {
            output.append(device.getObjectInfo()).append("\n").append(device.volumeDown(volume)).append("\n");
        }
        return output.toString();
    }

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return on;
	}


}
