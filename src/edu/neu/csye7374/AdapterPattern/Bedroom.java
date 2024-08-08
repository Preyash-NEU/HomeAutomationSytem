package edu.neu.csye7374.AdapterPattern;

import edu.neu.csye7374.BuilderPattern.Environment;

public class Bedroom implements Room {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        // Adapt the Environment class to the Bedroom room
        this.environment = new Environment.Builder()
                .lightColor(environment.getLightColor())
                .lightBrightness(environment.getLightBrightness())
                .airPurifier(environment.getAirPurifier())
                .blindsLevel(100) // Use 100% blinds level for the bedroom
                .musicType(environment.getMusicType())
                .build();
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }
}