package edu.neu.csye7374.StatePattern;

public class IdleState implements State {

    public void doAction(Device device) {
        System.out.println(" in idle state");
        device.setState(this);
    }

    public String toString(){
        return " is idle";
    }
}