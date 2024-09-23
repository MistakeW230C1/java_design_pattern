package com.mistake.day10.demo1;

public class Invoke {
    ICommand command;

    public Invoke(ICommand command) {
        this.command = command;
    }

    public void execute() {
        command.sweep();
    }
}
