package edu.neu.csye7374.SingletonFactoryPattern;

import edu.neu.csye7374.DecoratorPattern.SmartHomeFeatures;

public class SmartLight implements SmartDevice, SmartHomeFeatures {

    public static final String DESCRIPTION = "SMART LIGHT FEATURES : ";
    private boolean on;
    @Override
    public String getObjectInfo() {
        System.out.println("\tCreated Smart Light using getObject()");
        return "\tCreated Smart Light using getObject()";
    }

    @Override
    public String turnOn() {
        System.out.println("Smart light turned on");
        this.on = true;
        return "Smart light turned on";
    }

    @Override
    public String turnOff() {
        System.out.println("Smart light turned off");
        this.on = false;
        return "Smart light turned off";
    }

    @Override
    public String getDescription() { return DESCRIPTION; }

    @Override
    public String toString() { return "SmartLight{}"; }

	@Override
	public boolean isOn() {
		return on;
	}
}