package edu.neu.csye7374.BridgePattern;

public class Stranger implements SecurityAPI {

    protected PersonAPI implementor = null;

    public Stranger(PersonAPI implementor) {
        //super(implementor);
        this.implementor = implementor;
    }

    @Override
    public String alarmSecurity() {
    	
        System.out.println("\t\tActivate All Alarms");
        return "\t\tActivate All Alarms";
    }
}
