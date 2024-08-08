package edu.neu.csye7374.StatePattern;

public class StopState implements State {

    public void doAction(Device device) {
        System.out.println(" in stop state");
        device.setState(this);
    }

    public String toString(){
        return " is off";
    }
}
