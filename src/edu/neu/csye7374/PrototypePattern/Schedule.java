package edu.neu.csye7374.PrototypePattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Schedule implements Cloneable {

    private String locationName;
    private String deviceType;
    private List<String> timeSlots;

    public Schedule(String locationName, List<String> timeSlots, String deviceType) {
        this.locationName = locationName;
        this.timeSlots = timeSlots;
        this.deviceType = deviceType;
    }

    public String getRoomName() {
        return locationName;
    }

    public String getType() {
        return deviceType;
    }

    public List<String> getSchedule() {
        return timeSlots;
    }

    public void addSchedule(String time) {
        timeSlots.add(time);
        Collections.sort(timeSlots);
    }

    @Override
    protected Schedule clone() {
        Schedule cloned = null;
        try {
            cloned = (Schedule) super.clone();
            cloned.timeSlots = new ArrayList<>(this.timeSlots);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "locationName='" + locationName + '\'' +
                ", timeSlots=" + timeSlots +
                '}';
    }
}
