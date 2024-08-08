package edu.neu.csye7374.StatePattern;

public class EspressoMaker implements Device{
    private State state;

    public EspressoMaker(){
        state = new StartState();
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
    
    public String toString() {
    	return "Espresso Maker";
    }
}
