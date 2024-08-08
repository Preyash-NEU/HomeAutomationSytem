package edu.neu.csye7374.SingletonFactoryPattern;

import edu.neu.csye7374.DecoratorPattern.SmartHomeFeatures;

public class SmartFan implements SmartDevice, SmartHomeFeatures {

    public static final String DESCRIPTION = "SMART FAN FEATURES : ";
    private boolean on;

    @Override
    public String getObjectInfo() {
        System.out.println("\tCreated Smart Fan using getObject()");
        return "\tCreated Smart Fan using getObject()";
    }

    @Override
    public String turnOn() {
        System.out.println("Smart Fan turned on");
        on = true;
        return "Smart Fan turned on";
    }

    @Override
    public String turnOff() {
        System.out.println("Smart Fan turned off");
        on = false;
        return "Smart Fan turned off";
    }

    @Override
    public String getDescription() { return DESCRIPTION; }

    @Override
    public String toString() { return "SmartFan{}"; }

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return on;
	}
}
