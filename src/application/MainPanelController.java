package application;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;
import edu.neu.csye7374.SingletonFactoryPattern.SmartDeviceFactory;
import edu.neu.csye7374.SingletonFactoryPattern.SmartFan;
import edu.neu.csye7374.SingletonFactoryPattern.SmartFanEagerSingletonFactory;
import edu.neu.csye7374.SingletonFactoryPattern.SmartLight;
import edu.neu.csye7374.SingletonFactoryPattern.SmartLightLazySingletonFactory;
import edu.neu.csye7374.StrategyPattern.EnergySavingStrategy;
import edu.neu.csye7374.StrategyPattern.LowPowerStrategy;
import edu.neu.csye7374.StrategyPattern.SmartDeviceStrategyContext;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import edu.neu.csye7374.AdapterPattern.EnvironmentAdapter;
import edu.neu.csye7374.AdapterPattern.Room;
import edu.neu.csye7374.BuilderPattern.Environment;
import edu.neu.csye7374.DecoratorPattern.*;
import edu.neu.csye7374.StatePattern.*;
import edu.neu.csye7374.PrototypePattern.*;
import edu.neu.csye7374.ObserverAndFacadePattern.*;
import edu.neu.csye7374.CommandPattern.*;
import edu.neu.csye7374.CompositePattern.*;
import edu.neu.csye7374.BridgePattern.*;

public class MainPanelController {

	@FXML
	private TextArea outputTextArea;

	@FXML
	private Button energyModeButton;

	@FXML
	private Button lowPowerModeButton;

	private boolean energyModeButtonClicked = false;
	private boolean lowPowerModeButtonClicked = false;

	@FXML
	private TextField lightColorField;
	@FXML
	private TextField brightnessField;
	@FXML
	private TextField airPurifierField;
	@FXML
	private TextField blindsLevelField;
	@FXML
	private TextField musicTypeField;

	@FXML
	private Button acButton;

	@FXML
	private Button espressoButton;

	@FXML
	private TextField temperatureField;

	@FXML
	private Button lightButton;

	@FXML
	private Button fanButton;

	@FXML
	private ChoiceBox<String> deviceTypeChoiceBox;

	private SmartSpeaker smartSpeakers; // Declare SmartSpeaker object

	@FXML
	private ChoiceBox<String> securityChoiceBox;

//	@FXML
//	private TextField fanScheduleTextField;
//
//	@FXML
//	private TextField lightScheduleTextField;

	AirConditioner ac;
	EspressoMaker em;

	SmartDeviceFactory lightFactory = SmartLightLazySingletonFactory.getInstance();
	SmartDevice light = lightFactory.getObject();
	SmartDeviceFactory fanFactory = SmartFanEagerSingletonFactory.getInstance();
	SmartDevice fan = fanFactory.getObject();

	@FXML
	public void initialize() {
		// Initially disable all buttons except the start buttons
		if (ac == null) {
			ac = new AirConditioner();
		}
		if (em == null)
			em = new EspressoMaker();
		acButton.setOnAction(event -> {
			handleDeviceButton(ac);
		});

		espressoButton.setOnAction(event -> {
			handleDeviceButton(em);
		});

		lightButton.setStyle("-fx-background-color: red");

		// Initialize the fan button
		fanButton.setStyle("-fx-background-color: red");

		deviceTypeChoiceBox.setItems(FXCollections.observableArrayList("Bedroom Speaker", "Master Room Speaker", "TV Speaker", "Mobile Speaker"));
		smartSpeakers = new SmartSpeaker("Smart Speaker");

		securityChoiceBox.setItems(FXCollections.observableArrayList("Stranger", "Guest", "Family"));
	}

	@FXML
	public void runFactoryDemo() {
		StringBuilder output = new StringBuilder();
		output.append("***** SINGLETON AND FACTORY DESIGN PATTERN DEMO *****\n");
		output.append("\nStarting...\n".toUpperCase());

		SmartDeviceFactory lightFactory = SmartLightLazySingletonFactory.getInstance();
		SmartDevice light = lightFactory.getObject();
		output.append(light.getObjectInfo()).append("\n");

		SmartDeviceFactory fanFactory = SmartFanEagerSingletonFactory.getInstance();
		SmartDevice fan = fanFactory.getObject();
		output.append(fan.getObjectInfo()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

//		outputTextArea.setText(output.toString());
		
//		StringBuilder output = new StringBuilder();
		output.append("***** DECORATOR AND SINGLETON DESIGN PATTERN DEMO *****\n");
		output.append("\nStarting...\n".toUpperCase());

		SmartHomeFeatures smartLight = new RemoteAccess(new VoiceControl(new SmartLight()));
		output.append(smartLight.getDescription()).append("\n");

		SmartHomeFeatures smartFan = new RemoteAccess(new SmartFan());
		output.append(smartFan.getDescription()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	public void runStrategyDemo(boolean energyModeButtonClicked, boolean lowPowerModeButtonClicked) {
		StringBuilder output = new StringBuilder();
		output.append("********** STRATEGY DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());

		// Instantiate strategy objects and capture constructor messages
		LowPowerStrategy lowPowerStrategy = new LowPowerStrategy();
		EnergySavingStrategy energySavingStrategy = new EnergySavingStrategy();

		SmartDeviceStrategyContext context = new SmartDeviceStrategyContext();

		// Check which button is clicked and set the strategy accordingly
		if (energyModeButtonClicked) {
			context.setStrategyAPI(energySavingStrategy);
			output.append("\t Setting Energy Saving Strategy Mode to Smart Device").append("\n");
		} else if (lowPowerModeButtonClicked) {
			context.setStrategyAPI(lowPowerStrategy);
			output.append("\t Setting Low Power Strategy Mode to Smart Device").append("\n");
		}

		// Execute the selected strategy
		output.append(context.executeStrategy()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	@FXML
	private void handleEnergyModeButtonClick(ActionEvent event) {
		boolean energyModeButtonClicked = true;
		boolean lowPowerModeButtonClicked = false;
		runStrategyDemo(energyModeButtonClicked, lowPowerModeButtonClicked);
	}

	@FXML
	private void handleLowPowerModeButtonClick(ActionEvent event) {
		boolean energyModeButtonClicked = false;
		boolean lowPowerModeButtonClicked = true;
		runStrategyDemo(energyModeButtonClicked, lowPowerModeButtonClicked);
	}


	@FXML
	private void handleBedroomButtonClick(ActionEvent event) {
		StringBuilder output = new StringBuilder();
		output.append("********** BUILDER AND ADAPTER DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());

		// Retrieve environment settings from input fields
		String lightColor = lightColorField.getText();
		int brightness = Integer.parseInt(brightnessField.getText());
		boolean airPurifier = Boolean.parseBoolean(airPurifierField.getText());
		int blindsLevel = Integer.parseInt(blindsLevelField.getText());
		String musicType = musicTypeField.getText();

		// Implement builder and adapter demo for bedroom
		Environment environment = new Environment.Builder().lightColor(lightColor).lightBrightness(brightness)
				.airPurifier(airPurifier).blindsLevel(blindsLevel).musicType(musicType).build();

		Room bedroom = EnvironmentAdapter.adapt(environment, "bedroom");

		// Display environment details
		output.append("Environment in Bedroom : \n Light Colour is " + bedroom.getEnvironment().getLightColor()
				+ "\n Light brightness level is " + bedroom.getEnvironment().getLightBrightness()
				+ "\n Air Purifier level is " + (bedroom.getEnvironment().getAirPurifier() ? "ON" : "OFF")
				+ "\n Blinds level is " + bedroom.getEnvironment().getBlindsLevel() + "\n Music Type is "
				+ bedroom.getEnvironment().getMusicType()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	@FXML
	private void handleLivingRoomButtonClick(ActionEvent event) {
		StringBuilder output = new StringBuilder();
		output.append("********** BUILDER AND ADAPTER DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());

		// Retrieve environment settings from input fields
		String lightColor = lightColorField.getText();
		int brightness = Integer.parseInt(brightnessField.getText());
		boolean airPurifier = Boolean.parseBoolean(airPurifierField.getText());
		int blindsLevel = Integer.parseInt(blindsLevelField.getText());
		String musicType = musicTypeField.getText();

		// Implement builder and adapter demo for living room
		Environment environment = new Environment.Builder().lightColor(lightColor).lightBrightness(brightness)
				.airPurifier(airPurifier).blindsLevel(blindsLevel).musicType(musicType).build();

		Room livingRoom = EnvironmentAdapter.adapt(environment, "living room");

		// Display environment details
		output.append("Environment in Living Room : \n Light Colour is " + livingRoom.getEnvironment().getLightColor()
				+ "\n Light brightness level is " + livingRoom.getEnvironment().getLightBrightness()
				+ "\n Air Purifier level is " + (livingRoom.getEnvironment().getAirPurifier() ? "ON" : "OFF")
				+ "\n Blinds level is " + livingRoom.getEnvironment().getBlindsLevel() + "\n Music Type is "
				+ livingRoom.getEnvironment().getMusicType()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	private void handleDeviceButton(Device device) {
//    	State currentState = new StopState(); // Set default state to StopState
		State currentState = device.getState();
		State nextState;

//        if (currentState == null) nextState = new StartState();

		System.out.print(currentState instanceof StartState);
		if (currentState instanceof StartState) {
			// If the current state is StartState, transition to IdleState
			nextState = new IdleState();
			device.setState(nextState);
		} else if (currentState instanceof IdleState) {
			// If the current state is IdleState, transition to StopState
			nextState = new StopState();
			device.setState(nextState);
		} else if (currentState instanceof StopState) {
			// If the current state is StopState, transition to StartState
			nextState = new StartState();
			device.setState(nextState);
		} else {
			// Handle other states if necessary
			nextState = currentState; // Stay in the same state if not Start, Idle, or Stop
			device.setState(nextState);
		}

		StringBuilder output = new StringBuilder();
		output.append("********** STATE DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());
		output.append("\tTuring ").append(device).append(" in ").append(nextState.getClass().getSimpleName())
				.append(" state\n");
		nextState.doAction(device);
		output.append("\t").append(device).append(" is ").append(device.getState().toString()).append("\n");
		currentState = nextState;
		output.append("Ending...\n".toUpperCase()).append("\n");
		outputTextArea.setText(output.toString());
	}

	@FXML
	public void runPrototypeDemo() {
		StringBuilder output = new StringBuilder();
		output.append("********** PROTOTYPE DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());

		ScheduleCache.loadCache();
		Schedule clonedSchedule = ScheduleCache.getSchedule("Living Room");
		output.append("Schedule before update").append("\n");
		output.append("Type of Device = ").append(clonedSchedule.getType()).append("\n");
		output.append("Room Name = ").append(clonedSchedule.getRoomName()).append("\n");
		output.append("Schedule = ").append(clonedSchedule.getSchedule()).append("\n\n");

		clonedSchedule.addSchedule("12:00AM");
		output.append("Schedule after update").append("\n");
		output.append("Type of Device = ").append(clonedSchedule.getType()).append("\n");
		output.append("Room Name = ").append(clonedSchedule.getRoomName()).append("\n");
		output.append("Schedule = ").append(clonedSchedule.getSchedule()).append("\n\n");

		Schedule clonedSchedule2 = ScheduleCache.getSchedule("Bedroom");
		output.append("Schedule before update").append("\n");
		output.append("Type of Device = ").append(clonedSchedule2.getType()).append("\n");
		output.append("Room Name = ").append(clonedSchedule2.getRoomName()).append("\n");
		output.append("Schedule = ").append(clonedSchedule2.getSchedule()).append("\n\n");

		clonedSchedule2.addSchedule("1:30AM");
		output.append("Schedule after update").append("\n");
		output.append("Type of Device = ").append(clonedSchedule2.getType()).append("\n");
		output.append("Room Name = ").append(clonedSchedule2.getRoomName()).append("\n");
		output.append("Schedule = ").append(clonedSchedule2.getSchedule()).append("\n\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

//	@FXML
//	public void runPrototypeDemo() {
//		StringBuilder output = new StringBuilder();
//		output.append("********** PROTOTYPE DESIGN PATTERN DEMO **********\n");
//		output.append("\nStarting...\n".toUpperCase());
//
//		// Get fan schedule and update living room
//		String fanSchedule = fanScheduleTextField.getText();
//		Schedule fanScheduleLivingRoom = ScheduleCache.getSchedule("Living Room");
//		fanScheduleLivingRoom.addSchedule(fanSchedule);
//
//		output.append("Fan Schedule for Living Room after update:\n");
//		output.append("Type of Device = ").append(fanScheduleLivingRoom.getType()).append("\n");
//		output.append("Room Name = ").append(fanScheduleLivingRoom.getRoomName()).append("\n");
//		output.append("Schedule = ").append(fanScheduleLivingRoom.getSchedule()).append("\n\n");
//
//		// Get light schedule and update bedroom
//		String lightSchedule = lightScheduleTextField.getText();
//		Schedule lightScheduleBedroom = ScheduleCache.getSchedule("Bedroom");
//		lightScheduleBedroom.addSchedule(lightSchedule);
//
//		output.append("Light Schedule for Bedroom after update:\n");
//		output.append("Type of Device = ").append(lightScheduleBedroom.getType()).append("\n");
//		output.append("Room Name = ").append(lightScheduleBedroom.getRoomName()).append("\n");
//		output.append("Schedule = ").append(lightScheduleBedroom.getSchedule()).append("\n\n");
//
//		output.append("Ending...\n".toUpperCase()).append("\n");
//
//		outputTextArea.setText(output.toString());
//	}

	@FXML
	public void runObserverAndFacadeDemo() {
		StringBuilder output = new StringBuilder();
		output.append("********** OBSERVER AND FACADE DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());

		TemperatureSensor sensor = new TemperatureSensor();
		TemperatureNotification notification = new TemperatureNotification(sensor);

		// Get temperature from text field
		int temperature = Integer.parseInt(temperatureField.getText());

		// Set the temperature and get the notification
		output.append(sensor.setTemperature(temperature)).append("\n");

		notification.unsubscribe();

		output.append("Ending...\n".toUpperCase()).append("\n");

		// Display the output in the TextArea
		outputTextArea.setText(output.toString());
	}

	public void deviceButtonClick(Button button, SmartDevice device) {
		StringBuilder output = new StringBuilder();
		output.append("********** COMMAND AND SINGLETON DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());
		Command command;
		if (device.isOn()) {
			// turn off the light
			command = new TurnOffCommand(device);

			button.setStyle("-fx-background-color: red");
		} else {
			// turn on the light
			command = new TurnOnCommand(device);

			button.setStyle("-fx-background-color: yellow");
		}
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(command);
		output.append(remoteControl.pressButton()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	@FXML
	public void handleLightButtonClick() {
		deviceButtonClick(lightButton, light);
	}

	@FXML
	public void handleFanButtonClick() {
		deviceButtonClick(fanButton, fan);
	}

	@FXML
	public void runCompositeDemo() {
		String selectedDevice = deviceTypeChoiceBox.getValue();
		if (selectedDevice == null || selectedDevice.isEmpty()) {
			outputTextArea.setText("Please select a device type.");
			return;
		}

		StringBuilder output = new StringBuilder();
		output.append("***** COMPOSITE DESIGN PATTERN DEMO *****\n");
		output.append("\nStarting...\n".toUpperCase());

		SmartSpeakerDevices selectedSpeakerDevice = createSpeakerDevice(selectedDevice);
		if (selectedSpeakerDevice == null) {
			outputTextArea.setText("Invalid device type selected.");
			return;
		}

//        SmartSpeaker smartSpeakers = new SmartSpeaker("Smart Speaker");
		output.append("\tAdding Leaf Speakers to Group Smart Speakers Devices:\n".toUpperCase());
		output.append(smartSpeakers.addDevice(selectedSpeakerDevice)).append("\n");
		output.append(smartSpeakers.getObjectInfo()).append("\n");

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

	private SmartSpeakerDevices createSpeakerDevice(String deviceType) {
		switch (deviceType) {
		case "Bedroom Speaker":
			return new LeafDevice("Bedroom Speaker");
		case "Master Room Speaker":
			return new LeafDevice("Master Room Speaker");
		case "TV Speaker":
			return new LeafDevice("TV Speaker");
		case "Mobile Speaker":
			return new LeafDevice("Mobile Speaker");
		default:
			return null;
		}
	}

	@FXML
	public void handleVolumeUpButtonClick() {
		// Handle volume up button click
		outputTextArea.appendText("Increasing volume...\n");
		outputTextArea.appendText(smartSpeakers.adjustVolumeUp() + "\n"); // Increase volume
	}

	@FXML
	public void handleVolumeDownButtonClick() {
		// Handle volume down button click
		outputTextArea.appendText("Decreasing volume...\n");
		outputTextArea.appendText(smartSpeakers.adjustVolumeDown() + "\n"); // Decrease volume
	}

	@FXML
	public void runBridgePatternDemo() {
		StringBuilder output = new StringBuilder();
		output.append("********** BRIDGE DESIGN PATTERN DEMO **********\n");
		output.append("\nStarting...\n".toUpperCase());
		output.append("\tSECURITY BASED ON PERSON ROLE:\n");

		// Get the selected SecurityAPI from the choice box
		String selectedSecurity = securityChoiceBox.getValue();

		// Create the corresponding SecurityAPI based on the selected value
		SecurityAPI securityAPI;
		switch (selectedSecurity) {
		case "Stranger":
			securityAPI = new Stranger(new Person());
			break;
		case "Guest":
			securityAPI = new Guest(new Person());
			break;
		case "Family":
			securityAPI = new Family(new Person());
			break;
		default:
			securityAPI = null;
			break;
		}

		// Check if securityAPI is not null
		if (securityAPI != null) {
			output.append("\t").append(selectedSecurity.toUpperCase()).append(":\n");
			output.append(securityAPI.alarmSecurity()).append("\n");

			// Check if the selected security is Guest or Family and append additional
			// security details
			if (selectedSecurity.equals("Guest") || selectedSecurity.equals("Family")) {
				RoomActivateAPI roomActivateAPI = (RoomActivateAPI) securityAPI;
				output.append(roomActivateAPI.doorSecurity()).append("\n");
				output.append(roomActivateAPI.lightSecurity()).append("\n");
				output.append(roomActivateAPI.garageSecurity()).append("\n");
			}
		}

		output.append("Ending...\n".toUpperCase()).append("\n");

		outputTextArea.setText(output.toString());
	}

}
