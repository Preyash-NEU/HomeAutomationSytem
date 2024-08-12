package edu.neu.csye7374.StatePattern;

public class StartState implements State {

    public void doAction(Device device) {
        System.out.println("Device is in start state");
        device.setState(this);
    }

    @Override
    public String toString() {
        return "Device is on";
    }
}
