package edu.neu.csye7374.CommandPattern;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;

public class TurnOnCommand implements Command {
    private SmartDevice device;

    public TurnOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public String execute() {
        return device.turnOn();
    }
}

