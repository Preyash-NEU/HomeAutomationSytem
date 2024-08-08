package edu.neu.csye7374.StrategyPattern;

public class EnergySavingStrategy implements SmartDeviceStrategyAPI{

    public EnergySavingStrategy() {
        System.out.println("\tSetting Energy Saving Strategy Mode to Smart Device");
    }

    @Override
    public String mode() {
        System.out.println("\tApplying Energy Saving Mode to all Smart Devices - REDUCED 20% COST");
        return "\tApplying Energy Saving Mode to all Smart Devices - REDUCED 20% COST";
    }
}
