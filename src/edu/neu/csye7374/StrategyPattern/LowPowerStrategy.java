package edu.neu.csye7374.StrategyPattern;

public class LowPowerStrategy implements SmartDeviceStrategyAPI{
	String strategy = new String("");

    public LowPowerStrategy() {
    	strategy = "\tSetting Low Power Strategy Mode to Smart Device";
        System.out.println("\tSetting Low Power Strategy Mode to Smart Device");
    }

    @Override
    public String mode() {
        System.out.println("\tApplying Low Power Mode to all Smart Devices - REDUCED 10% COST");
        return "\tApplying Low Power Mode to all Smart Devices - REDUCED 10% COST";
    }
}
