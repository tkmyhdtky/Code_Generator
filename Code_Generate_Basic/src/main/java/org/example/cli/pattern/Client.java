package org.example.cli.pattern;

public class Client {
    public static void main(String[] args) {
        Device tv = new Device("TV");
        Device pc = new Device("PC");

        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(pc);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOn);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOff);
        remoteControl.pressButton();
    }
}
