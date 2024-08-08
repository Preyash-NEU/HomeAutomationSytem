package edu.neu.csye7374.BridgePattern;

public class Family extends Guest implements RoomActivateAPI{

    protected PersonAPI implementor = null;

    public Family(PersonAPI implementor) {
        super(implementor);
    }

    @Override
    public String alarmSecurity() {
        System.out.println("\t\tDeactivate Alarm Security");
        return "\t\tDeactivate Alarm Security";
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
        System.out.println("\t\tDeactivate Garage Security");
        return "\t\tDeactivate Garage Security";
    }
}
