package edu.neu.csye7374.StatePattern;

public class AirConditioner implements Device {
    private State currentState;

    public AirConditioner() {
        currentState = new StartState();
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getState() {
        return currentState;
    }

    @Override
    public String toString() {
        return "AC";
    }
}
