package edu.neu.csye7374.StatePattern;

public class IdleState implements State {

    public void doAction(Device device) {
        System.out.println("Device is in idle state");
        device.setState(this);
    }

    @Override
    public String toString() {
        return "Device is idle";
    }
}
