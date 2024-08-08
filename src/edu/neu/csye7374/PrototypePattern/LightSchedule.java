package edu.neu.csye7374.PrototypePattern;

import java.util.List;

public class LightSchedule extends Schedule {

    public LightSchedule(String roomName, List<String> schedule) {
        super(roomName, schedule, "Light");
    }

    @Override
    public String toString() {
        return "LightSchedule{}";
    }
}
