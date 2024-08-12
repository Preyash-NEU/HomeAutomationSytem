package edu.neu.csye7374.CompositePattern;

public class LeafDevice extends SmartSpeakerDevices {

	private int soundLevel = 10; 
    private String deviceName;    
    private boolean isActive; 

    public LeafDevice(String name) {
        this.deviceName = name;
    }

    @Override
    public String getObjectInfo() {
        String info = "\t\tDevice: " + deviceName + ", Sound Level: " + soundLevel;
        System.out.println(info);
        return info;
    }

    @Override
    public String turnOn() {
        isActive = true;
        String status = deviceName + " is now active";
        System.out.println(status);
        return status;
    }

    @Override
    public String turnOff() {
        isActive = false;
        String status = deviceName + " has been deactivated";
        System.out.println(status);
        return status;
    }

    @Override
    public boolean isOn() {
        return isActive;
    }
}
