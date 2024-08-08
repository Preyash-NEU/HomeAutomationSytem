package edu.neu.csye7374.SingletonFactoryPattern;

public class SmartFanEagerSingletonFactory implements SmartDeviceFactory {

    private static final SmartDeviceFactory instance = new SmartFanEagerSingletonFactory();

    private SmartFanEagerSingletonFactory() {}

    public static SmartDeviceFactory getInstance() {
        return instance;
    }

    @Override
    public SmartDevice getObject() {
        return new SmartFan();
    }
}
