package edu.neu.csye7374.SingletonFactoryPattern;

public class SmartLightLazySingletonFactory implements SmartDeviceFactory {

    private static SmartDeviceFactory instance;

    private SmartLightLazySingletonFactory() {}

    public static SmartDeviceFactory getInstance() {
        if(instance == null) {
            synchronized (SmartLightLazySingletonFactory.class) {
                if(instance == null) {
                    instance = new SmartLightLazySingletonFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public SmartDevice getObject() {
        return new SmartLight();
    }
}
