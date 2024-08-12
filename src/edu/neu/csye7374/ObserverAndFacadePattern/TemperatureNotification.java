package edu.neu.csye7374.ObserverAndFacadePattern;

public class TemperatureNotification implements TemperatureObserver {
	private TemperatureSensor tempSensor;

    public TemperatureNotification(TemperatureSensor tempSensor) {
        this.tempSensor = tempSensor;
        this.tempSensor.attach(this);
    }

    public void unsubscribe() {
        this.tempSensor.detach(this);
    }

    @Override
    public String update(int currentTemp) {
        if (currentTemp >= 25) {
            triggerAlert("Warning: High temperature!");
            return "Warning: High temperature!";
        } else if (currentTemp <= 15) {
            triggerAlert("Alert: Low temperature!");
            return "Alert: Low temperature!";
        }
        return "";
    }

    public void triggerAlert(String alertMessage) {
        System.out.println(alertMessage);
    }
}