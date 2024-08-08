package edu.neu.csye7374.CommandPattern;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;

public class TurnOffCommand implements Command {
    private SmartDevice device;

    public TurnOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public String execute() {
        return device.turnOff();
    }
}