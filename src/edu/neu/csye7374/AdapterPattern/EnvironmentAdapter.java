package edu.neu.csye7374.AdapterPattern;

import edu.neu.csye7374.BuilderPattern.Environment;

public class EnvironmentAdapter {
    public static Room adapt(Environment environment, String roomType) {
        Room room = null;
        if (roomType.equalsIgnoreCase("bedroom")) {
            room = new Bedroom();
        } else if (roomType.equalsIgnoreCase("living room")) {
            room = new LivingRoom();
        }
        if (room != null) {
            room.setEnvironment(environment);
        }
        return room;
    }
}