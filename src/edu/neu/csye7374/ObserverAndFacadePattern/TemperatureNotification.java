package edu.neu.csye7374.ObserverAndFacadePattern;

// The TemperatureNotification class represents the Facade
public class TemperatureNotification implements TemperatureObserver {
    private TemperatureSensor sensor;

    public TemperatureNotification(TemperatureSensor sensor) {
        this.sensor = sensor;
        this.sensor.attach(this);
    }

    public void detach() {
        this.sensor.detach(this);
    }

    @Override
    public String update(int temperature) {
        if (temperature >= 25) {
            sendNotification("\tTemperature is high!");
            return "\tTemperature is high!";
        } else if (temperature <= 15) {
            sendNotification("\tTemperature is low!");
            return "\tTemperature is low!";
        }
        return "";
    }

    public void sendNotification(String message) {
        // Code to send notification to user goes here
        System.out.println(message);
    }
}