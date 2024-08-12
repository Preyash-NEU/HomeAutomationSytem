package edu.neu.csye7374.StrategyPattern;

public class EnergySavingStrategy implements SmartDeviceStrategyAPI {

    public EnergySavingStrategy() {
        System.out.println("\tInitializing Energy Saving Strategy for Smart Devices");
    }

    @Override
    public String mode() {
        System.out.println("\tEnergy Saving Mode activated - Reducing energy usage by 20%");
        return "\tEnergy Saving Mode activated - Reducing energy usage by 20%";
    }
}
