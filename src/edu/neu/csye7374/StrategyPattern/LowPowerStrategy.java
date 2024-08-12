package edu.neu.csye7374.StrategyPattern;

public class LowPowerStrategy implements SmartDeviceStrategyAPI {
    private final String strategyDescription;

    public LowPowerStrategy() {
        strategyDescription = "\tSetting Low Power Strategy Mode to Smart Device";
        System.out.println(strategyDescription);
    }

    @Override
    public String mode() {
        String actionDescription = "\tLow Power Mode activated - Reducing energy costs by 10%";
        System.out.println(actionDescription);
        return actionDescription;
    }
}
