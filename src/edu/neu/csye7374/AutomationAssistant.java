package edu.neu.csye7374;

import edu.neu.csye7374.AdapterPattern.EnvironmentAdapter;
import edu.neu.csye7374.AdapterPattern.Room;
import edu.neu.csye7374.BuilderPattern.Environment;
import edu.neu.csye7374.CommandPattern.*;
import edu.neu.csye7374.CompositePattern.LeafDevice;
import edu.neu.csye7374.CompositePattern.SmartSpeaker;
import edu.neu.csye7374.CompositePattern.SmartSpeakerDevices;
import edu.neu.csye7374.DecoratorPattern.RemoteAccess;
import edu.neu.csye7374.DecoratorPattern.SmartHomeFeatures;
import edu.neu.csye7374.DecoratorPattern.VoiceControl;
import edu.neu.csye7374.ObserverAndFacadePattern.TemperatureNotification;
import edu.neu.csye7374.ObserverAndFacadePattern.TemperatureSensor;
import edu.neu.csye7374.PrototypePattern.Schedule;
import edu.neu.csye7374.PrototypePattern.ScheduleCache;
import edu.neu.csye7374.SingletonFactoryPattern.*;
import edu.neu.csye7374.StatePattern.*;
import edu.neu.csye7374.StrategyPattern.EnergySavingStrategy;
import edu.neu.csye7374.StrategyPattern.LowPowerStrategy;
import edu.neu.csye7374.StrategyPattern.SmartDeviceStrategyContext;
import edu.neu.csye7374.BridgePattern.*;

public class AutomationAssistant {
    public static void demo()
    {
        factoryDemo();
        strategyDemo();
        decoratorAndSingletonDemo();
        builderAndAdapterDemo();
        stateDemo();
        prototypeDemo();
        observerAndFacadeDemo();
        commandAndSingletonDemo();
        compositeDemo();
        bridgePatternDemo();
    }


    public static void factoryDemo(){
        System.out.println("***** SINGLETON AND FACTORY DESIGN PATTERN DEMO *****");
        System.out.println("\nStarting...".toUpperCase());
        SmartDeviceFactory lightFactory = SmartLightLazySingletonFactory.getInstance();
        lightFactory.getObject();
        lightFactory.getObject().getObjectInfo();
        SmartDeviceFactory fanFactory = SmartFanEagerSingletonFactory.getInstance();
        fanFactory.getObject();
        fanFactory.getObject().getObjectInfo();
        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void strategyDemo(){
        System.out.println("********** STRATEGY DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        SmartDeviceStrategyContext context = new SmartDeviceStrategyContext();
        context.setStrategyAPI(new EnergySavingStrategy());
        context.executeStrategy();
        context.setStrategyAPI(new LowPowerStrategy());
        context.executeStrategy();
        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void stateDemo()
    {
        System.out.println("********** STATE DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        Device ac = new AirConditioner();
        Device cm = new EspressoMaker();
        StartState startState = new StartState();
        StopState stopState = new StopState();
        IdleState idleState = new IdleState();
        System.out.print("\tTuring Air Conditioner");
        startState.doAction(ac);
        System.out.print("\tAir Conditioner" + ac.getState().toString()+"\n\tTuring Air Conditioner");
        idleState.doAction(ac);
        System.out.print("\tAir Conditioner" + ac.getState().toString()+"\n\tTuring Air Conditioner");
        stopState.doAction(ac);
        System.out.println("\tAir Conditioner" + ac.getState().toString());
        System.out.print("\tTuring Espresso Maker");
        startState.doAction(cm);
        System.out.print("\tEspresso Maker" + cm.getState().toString()+"\n\tTuring Espresso Maker");
        idleState.doAction(cm);
        System.out.print("\tEspresso Maker" + cm.getState().toString()+"\n\tTuring Espresso Maker");
        stopState.doAction(cm);
        System.out.println("\tEspresso Maker" + cm.getState().toString());
        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void prototypeDemo() {

        System.out.println("********** PROTOTYE DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());

        ScheduleCache.loadCache();
        Schedule clonedSchedule = ScheduleCache.getSchedule("Living Room");
        System.out.println("Schedule before update");
        System.out.println("Type of Device = " + clonedSchedule.getType() + "\n Room Name = " + clonedSchedule.getRoomName() +
                "\n Schedule = " + clonedSchedule.getSchedule() + "\n");

        clonedSchedule.addSchedule("12:00AM");
        System.out.println("Schedule after update");
        System.out.println("Type of Device = " + clonedSchedule.getType() + "\n Room Name = " + clonedSchedule.getRoomName() +
                "\n Schedule = " + clonedSchedule.getSchedule() + "\n");

        Schedule clonedSchedule2 = ScheduleCache.getSchedule("Bedroom");
        System.out.println("Schedule before update");
        System.out.println("Type of Device = " + clonedSchedule2.getType() + "\n Room Name = " + clonedSchedule2.getRoomName() +
                "\n Schedule = " + clonedSchedule2.getSchedule() + "\n");

        clonedSchedule2.addSchedule("1:30AM");
        System.out.println("Schedule after update");
        System.out.println("Type of Device = " + clonedSchedule2.getType() + "\n Room Name = " + clonedSchedule2.getRoomName() +
                "\n Schedule = " + clonedSchedule2.getSchedule() + "\n");

        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void observerAndFacadeDemo()
    {
        System.out.println("********** OBSERVER AND FACADE DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        TemperatureSensor sensor = new TemperatureSensor();
        TemperatureNotification notification = new TemperatureNotification(sensor);
        // Set the temperature to test notifications
        sensor.setTemperature(10);
        sensor.setTemperature(20);
        sensor.setTemperature(30);
        notification.unsubscribe();
        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void commandAndSingletonDemo()
    {
        System.out.println("********** COMMAND AND SINGLETON DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        SmartDeviceFactory lightFactory = SmartLightLazySingletonFactory.getInstance();
        SmartDevice light = lightFactory.getObject();
        light.getObjectInfo();

        TurnOnCommand turnOnLight = new TurnOnCommand(light);
        TurnOffCommand turnOffLight = new TurnOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnLight);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffLight);
        remoteControl.pressButton();

        SmartDeviceFactory fanFactory = SmartFanEagerSingletonFactory.getInstance();
        SmartDevice fan = fanFactory.getObject();
        fan.getObjectInfo();

        TurnOnCommand turnOnFan = new TurnOnCommand(fan);
        TurnOffCommand turnOffFan= new TurnOffCommand(fan);

        remoteControl.setCommand(turnOnFan);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffFan);
        remoteControl.pressButton();
        System.out.println("Ending...".toUpperCase()+"\n");
    }

    public static void decoratorAndSingletonDemo() {

        System.out.println("***** DECORATOR AND SINGLETON DESIGN PATTERN DEMO *****");
        System.out.println("\nStarting...".toUpperCase());

        SmartHomeFeatures smartLight = new RemoteAccess(new VoiceControl(new SmartLight()));
        System.out.println(smartLight.getDescription());

        SmartHomeFeatures smartFan = new RemoteAccess(new SmartFan());
        System.out.println(smartFan.getDescription());

        System.out.println("Ending...".toUpperCase() + "\n");
    }

    public static void builderAndAdapterDemo(){
        System.out.println("********** BUILDER AND ADAPTER DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        Environment environment = new Environment.Builder()
                .lightColor("White")
                .lightBrightness(50)
                .airPurifier(false)
                .blindsLevel(0)
                .musicType("Silent")
                .build();

        Room bedroom = EnvironmentAdapter.adapt(environment, "bedroom");
        bedroom.setEnvironment(new Environment.Builder()
                .lightColor("Blue")
                .lightBrightness(20)
                .airPurifier(true)
                .blindsLevel(100)
                .musicType("Jazz")
                .build());
        String airpurifier = bedroom.getEnvironment().getAirPurifier()?"ON":"OFF";
        System.out.println("Environment in Bedroom : \n Light Colour is " + bedroom.getEnvironment().getLightColor() +
                "\n Light brightness level is " + bedroom.getEnvironment().getLightBrightness() +
                "\n Air Purifier level is " + airpurifier +
                "\n Blinds level is " + bedroom.getEnvironment().getBlindsLevel() +
                "\n Music Type is " + bedroom.getEnvironment().getMusicType());

        Room livingRoom = EnvironmentAdapter.adapt(environment, "living room");
        livingRoom.setEnvironment(new Environment.Builder()
                .lightColor("Yellow")
                .lightBrightness(100)
                .airPurifier(true)
                .blindsLevel(40)
                .musicType("Classical")
                .build());
        airpurifier = livingRoom.getEnvironment().getAirPurifier()?"ON":"OFF";
        System.out.println("\nEnvironment in Living Room : \n Light Colour is " + livingRoom.getEnvironment().getLightColor() +
                "\n Light brightness level is " + livingRoom.getEnvironment().getLightBrightness() +
                "\n Air Purifier level is " + airpurifier +
                "\n Blinds level is " + livingRoom.getEnvironment().getBlindsLevel() +
                "\n Music Type is " + livingRoom.getEnvironment().getMusicType());

        System.out.println("Ending...".toUpperCase() + "\n");
    }

    public static void compositeDemo ()
    {
        System.out.println("***** COMPOSITE DESIGN PATTERN DEMO *****");
        System.out.println("\nStarting...".toUpperCase());
        SmartSpeakerDevices bedroomSpeaker = new LeafDevice("Bedroom Speaker");
        SmartSpeakerDevices masterRoomSpeaker = new LeafDevice("Master Room Speaker");
        SmartSpeakerDevices tvSpeaker = new LeafDevice("TV Speaker");
        SmartSpeakerDevices mobileSpeaker = new LeafDevice("Mobile Speaker");
        SmartSpeaker smartSpeakers = new SmartSpeaker("Smart Speaker");
        System.out.println("\tAdding Leaf Speakers to Group Smart Speakers Devices:".toUpperCase());
        smartSpeakers.addDevice(bedroomSpeaker);
        smartSpeakers.addDevice(masterRoomSpeaker);
        smartSpeakers.addDevice(tvSpeaker);
        smartSpeakers.addDevice(mobileSpeaker);
        System.out.println("\tIncreasing Volume in Group Smart Speakers Devices:".toUpperCase());
        smartSpeakers.adjustVolumeUp();
        System.out.println("\tRemoving Bedroom Speaker Smart Speaker Device:".toUpperCase());
        smartSpeakers.removeDevice(bedroomSpeaker);
        System.out.println("\tDecreasing Volume in Latest Group Smart Speaker Devices:".toUpperCase());
        smartSpeakers.adjustVolumeDown();
        System.out.println("Ending...".toUpperCase() + "\n");
    }

    private static void bridgePatternDemo() {
        System.out.println("********** BRIDGE DESIGN PATTERN DEMO **********");
        System.out.println("\nStarting...".toUpperCase());
        System.out.println("\tSECURITY BASED ON PERSON ROLE:");
        System.out.println("\tSTRANGER:");
        SecurityAPI stranger = new Stranger(new Person());
        stranger.alarmSecurity();
        System.out.println("\tGUEST:");
        RoomActivateAPI guest = new Guest(new Person());
        guest.alarmSecurity();
        guest.doorSecurity();
        guest.lightSecurity();
        guest.garageSecurity();
        System.out.println("\tFAMILY:");
        RoomActivateAPI family = new Family(new Person());
        family.alarmSecurity();
        family.doorSecurity();
        family.lightSecurity();
        family.garageSecurity();
        System.out.println("Ending...".toUpperCase() + "\n");

    }
}
