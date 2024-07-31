//package com.example.commandpattern;

/**
 * Exercise 9: Implementing the Command Pattern
 *
 * Scenario:
 * You are developing a home automation system where commands can be issued to turn devices on or off. Use the Command Pattern to achieve this.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named CommandPatternExample.
 * 2. Define Command Interface:
 *    - Create an interface Command with a method execute().
 * 3. Implement Concrete Commands:
 *    - Create classes LightOnCommand, LightOffCommand that implement Command.
 * 4. Implement Invoker Class:
 *    - Create a class RemoteControl that holds a reference to a Command and a method to execute the command.
 * 5. Implement Receiver Class:
 *    - Create a class Light with methods to turn on and off.
 * 6. Test the Command Implementation:
 *    - Create a test class to demonstrate issuing commands using the RemoteControl.
 */

// Step 2: Define Command Interface
interface Command {
    void execute();
}

// Step 3: Implement Concrete Commands

// Concrete Command for turning the light on
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command for turning the light off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Step 4: Implement Invoker Class

// Invoker class for remote control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Step 5: Implement Receiver Class

// Receiver class for the light
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Step 6: Test the Command Implementation
public class CommandPatternExample {
    public static void main(String[] args) {
        // Creating the receiver
        Light livingRoomLight = new Light();

        // Creating the commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Creating the invoker
        RemoteControl remote = new RemoteControl();

        // Turning the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turning the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
/*Expected Output:
The light is on.
The light is off.
 */