package edu.neu.csye7374.CompositePattern;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartSpeaker implements SmartDevice {

	private String speakerName;
    private int soundLevel = 10;
    private List<SmartSpeakerDevices> connectedDevices;
    private boolean isActive;

    public SmartSpeaker(String name) {
        this.speakerName = name;
        connectedDevices = new ArrayList<>();
    }

    @Override
    public String getObjectInfo() {
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("System Name: ").append(speakerName).append("\nConnected Devices:\n");
        for (SmartSpeakerDevices device : connectedDevices) {
            infoBuilder.append(device.getObjectInfo()).append("\n");
        }
        return infoBuilder.toString();
    }

    @Override
    public String turnOn() {
        String status = speakerName + " is now active";
        System.out.println(status);
        for (SmartSpeakerDevices device : connectedDevices) {
            status += "\n" + device.turnOn();
        }
        isActive = true;
        return status;
    }

    @Override
    public String turnOff() {
        String status = speakerName + " has been deactivated";
        System.out.println(status);
        for (SmartSpeakerDevices device : connectedDevices) {
            status += "\n" + device.turnOff();
        }
        isActive = false;
        return status;
    }

    public String addDevice(SmartSpeakerDevices device) {
        connectedDevices.add(device);
        return "Added: " + device.getObjectInfo();
    }

    public String removeDevice(SmartSpeakerDevices device) {
        if (connectedDevices.remove(device)) {
            System.out.println("\tRemoved Device Info:");
            return "\tRemoved: " + device.getObjectInfo();
        }
        return "\tError: Device not found";
    }

    public String adjustVolumeUp() {
        StringBuilder result = new StringBuilder("Increasing volume:");
        for (SmartSpeakerDevices device : connectedDevices) {
            result.append("\n").append(device.getObjectInfo()).append("\n").append(device.volumeUp(soundLevel));
        }
        return result.toString();
    }

    public String adjustVolumeDown() {
        StringBuilder result = new StringBuilder("Decreasing volume:");
        for (SmartSpeakerDevices device : connectedDevices) {
            result.append("\n").append(device.getObjectInfo()).append("\n").append(device.volumeDown(soundLevel));
        }
        return result.toString();
    }

    @Override
    public boolean isOn() {
        return isActive;
    }
}
