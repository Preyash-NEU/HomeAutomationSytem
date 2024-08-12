package edu.neu.csye7374.StatePattern;

public class StopState implements State {

    public void doAction(Device device) {
        System.out.println("Device is in stop state");
        device.setState(this);
    }

    @Override
    public String toString() {
        return "Device is off";
    }
}
