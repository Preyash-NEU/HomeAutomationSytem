package edu.neu.csye7374.AdapterPattern;

import edu.neu.csye7374.BuilderPattern.Environment;

public class LivingRoom implements Room{
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        // Adapt the Environment class to the Living Room
        this.environment = new Environment.Builder()
                .lightColor(environment.getLightColor())
                .lightBrightness(environment.getLightBrightness())
                .airPurifier(environment.getAirPurifier())
                .blindsLevel(50) // Use 50% blinds level for the living room
                .musicType(environment.getMusicType())
                .build();
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }
}
