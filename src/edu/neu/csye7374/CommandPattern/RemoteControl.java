package edu.neu.csye7374.CommandPattern;

// Invoker class
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public String pressButton() {
        return command.execute();
    }
}
