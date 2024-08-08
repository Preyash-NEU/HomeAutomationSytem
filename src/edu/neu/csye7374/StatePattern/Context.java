package edu.neu.csye7374.StatePattern;

public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}

//    public static void main(String[] args) {
//        Context context = new Context();
//
//        StartState startState = new StartState();
//        startState.doAction(context);
//
//        System.out.println(context.getState().toString());
//
//        StopState stopState = new StopState();
//        stopState.doAction(context);
//
//        System.out.println(context.getState().toString());
//    }
