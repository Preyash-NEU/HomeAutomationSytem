package edu.neu.csye7374.DecoratorPattern;

public class VoiceControl implements SmartHomeFeatures {

    public static final String DESCRIPTION = "Voice Control, ";

    private final SmartHomeFeatures smartHomeFeatures;

    public VoiceControl(SmartHomeFeatures smartHomeFeatures) {
        this.smartHomeFeatures = smartHomeFeatures;
    }

    @Override
    public String getDescription() {
        return smartHomeFeatures.getDescription() + " " + DESCRIPTION;
    }

    @Override
    public String toString() {
        return "VoiceControl{" +
                "smartHomeFeatures=" + smartHomeFeatures +
                '}';
    }
}
