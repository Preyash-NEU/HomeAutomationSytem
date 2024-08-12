package edu.neu.csye7374.StatePattern;

public class Context {
    private State currentState;

    public Context() {
        currentState = null;
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getState() {
        return currentState;
    }
}
