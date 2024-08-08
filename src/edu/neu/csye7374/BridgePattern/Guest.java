package edu.neu.csye7374.BridgePattern;

public class Guest extends Stranger implements RoomActivateAPI{

    protected PersonAPI implementor = null;

    public Guest(PersonAPI implementor) {
        super(implementor);
    }

    @Override
    public String alarmSecurity() {
        System.out.println("\t\tDeactivate Security");
        return "\t\tDeactivate Security";
    }

    @Override
    public String doorSecurity() {
        System.out.println("\t\tDeactivate Door Security");
        return "\t\tDeactivate Door Security";
    }

    @Override
    public String lightSecurity() {
        System.out.println("\t\tDeactivate Light Security");
        return "\t\tDeactivate Light Security";
    }

    @Override
    public String garageSecurity() {
        System.out.println("\t\tActivate Garage Security");
        return "\t\tActivate Garage Security";
    }
}
