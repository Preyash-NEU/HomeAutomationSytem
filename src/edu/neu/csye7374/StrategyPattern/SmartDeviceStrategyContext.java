package edu.neu.csye7374.StrategyPattern;

public class SmartDeviceStrategyContext {
    public SmartDeviceStrategyAPI strategyAPI;

    public void setStrategyAPI(SmartDeviceStrategyAPI strategyAPI){
        this.strategyAPI = strategyAPI;
    }

    public String executeStrategy(){
        return strategyAPI.mode();
    }
}
