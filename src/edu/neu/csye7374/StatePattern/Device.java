package edu.neu.csye7374.StatePattern;

public interface Device {
    public void setState(State state);
    public State getState();
}
