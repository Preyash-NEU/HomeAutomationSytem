package edu.neu.csye7374.StatePattern;

public class AirConditioner implements Device{
    private State state;

    public AirConditioner(){
        state = new StartState();
    }

    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }
    public String toString() {
    	return "AC";
    }
}
