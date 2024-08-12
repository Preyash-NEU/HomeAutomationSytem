package edu.neu.csye7374.SingletonFactoryPattern;

import edu.neu.csye7374.DecoratorPattern.SmartHomeFeatures;

public class SmartLight implements SmartDevice, SmartHomeFeatures {

    public static final String DESCRIPTION = "SMART LIGHT FEATURES : ";
    private boolean isActive;

    @Override
    public String getObjectInfo() {
        System.out.println("\tInstance of Smart Light created using getObject()");
        return "\tInstance of Smart Light created using getObject()";
    }

    @Override
    public String turnOn() {
        System.out.println("Activating Smart Light");
        this.isActive = true;
        return "Activating Smart Light";
    }

    @Override
    public String turnOff() {
        System.out.println("Deactivating Smart Light");
        this.isActive = false;
        return "Deactivating Smart Light";
    }

    @Override
    public String getDescription() { return DESCRIPTION; }

    @Override
    public String toString() { return "SmartLight{}"; }

	@Override
	public boolean isOn() {
		return isActive;
	}
}
