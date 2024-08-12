package edu.neu.csye7374.DecoratorPattern;

public class RemoteAccess implements SmartHomeFeatures {

	public static final String FEATURE_DESCRIPTION = "Remote Control Enabled, ";

    private final SmartHomeFeatures baseFeature;

    public RemoteAccess(SmartHomeFeatures baseFeature) {
        this.baseFeature = baseFeature;
    }

    @Override
    public String getDescription() {
        return baseFeature.getDescription() + " " + FEATURE_DESCRIPTION;
    }

    @Override
    public String toString() {
        return "RemoteControlFeature{" +
                "baseFeature=" + baseFeature +
                '}';
    }
}
