package edu.neu.csye7374.StatePattern;

public class StartState implements State {

    public void doAction(Device device) {
        System.out.println(" in start state");
        device.setState(this);
    }

    public String toString(){
        return " is on";
    }
}
