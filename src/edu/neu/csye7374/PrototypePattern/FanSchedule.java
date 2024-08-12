package edu.neu.csye7374.PrototypePattern;

import java.util.List;

public class FanSchedule extends Schedule {

    public FanSchedule(String locationName, List<String> timeSlots) {
        super(locationName, timeSlots, "Fan");
    }

    @Override
    public String toString() {
        return "FanSchedule{}";
    }
}
