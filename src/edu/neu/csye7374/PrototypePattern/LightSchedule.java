package edu.neu.csye7374.PrototypePattern;

import java.util.List;

public class LightSchedule extends Schedule {

    public LightSchedule(String areaName, List<String> timeSlots) {
        super(areaName, timeSlots, "Light");
    }

    @Override
    public String toString() {
        return "LightSchedule{}";
    }
}
