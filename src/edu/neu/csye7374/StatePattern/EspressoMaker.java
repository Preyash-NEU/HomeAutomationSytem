package edu.neu.csye7374.StatePattern;

public class EspressoMaker implements Device {
    private State currentStatus;

    public EspressoMaker() {
        currentStatus = new StartState();
    }

    public void setState(State newState) {
        this.currentStatus = newState;
    }

    public State getState() {
        return currentStatus;
    }

    @Override
    public String toString() {
        return "Espresso Maker";
    }
}
