package edu.neu.csye7374.PrototypePattern;

import java.util.List;

public class FanSchedule extends Schedule {

    public FanSchedule(String roomName, List<String> schedule) {
        super(roomName, schedule, "Fan");
    }

    @Override
    public String toString() {
        return "FanSchedule{}";
    }
}
