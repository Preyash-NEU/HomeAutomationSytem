package edu.neu.csye7374.SingletonFactoryPattern;

import edu.neu.csye7374.DecoratorPattern.SmartHomeFeatures;

public class SmartFan implements SmartDevice, SmartHomeFeatures {

    public static final String DESCRIPTION = "SMART FAN FEATURES : ";
    private boolean isActive;

    @Override
    public String getObjectInfo() {
        System.out.println("\tInstance of Smart Fan created using getObject()");
        return "\tInstance of Smart Fan created using getObject()";
    }

    @Override
    public String turnOn() {
        System.out.println("Activating Smart Fan");
        isActive = true;
        return "Activating Smart Fan";
    }

    @Override
    public String turnOff() {
        System.out.println("Deactivating Smart Fan");
        isActive = false;
        return "Deactivating Smart Fan";
    }

    @Override
    public String getDescription() { return DESCRIPTION; }

    @Override
    public String toString() { return "SmartFan{}"; }

	@Override
	public boolean isOn() {
		return isActive;
	}
}
