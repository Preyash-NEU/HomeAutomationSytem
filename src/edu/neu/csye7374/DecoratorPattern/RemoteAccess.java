package edu.neu.csye7374.DecoratorPattern;

public class RemoteAccess implements SmartHomeFeatures {

    public static final String DESCRIPTION = "Remote Access, ";

    private final SmartHomeFeatures smartHomeFeatures;

    public RemoteAccess(SmartHomeFeatures smartHomeFeatures) {
        this.smartHomeFeatures = smartHomeFeatures;
    }

    @Override
    public String getDescription() {
        return smartHomeFeatures.getDescription() + " " + DESCRIPTION;
    }

    @Override
    public String toString() {
        return "RemoteAccess{" +
                "smartHomeFeatures=" + smartHomeFeatures +
                '}';
    }
}
