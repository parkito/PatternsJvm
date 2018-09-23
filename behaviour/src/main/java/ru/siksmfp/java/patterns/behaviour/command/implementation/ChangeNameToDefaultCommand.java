package ru.siksmfp.java.patterns.behaviour.command.implementation;

public class ChangeNameToDefaultCommand implements Command {

    private Person person;

    public ChangeNameToDefaultCommand(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        person.setName("DefaultName");
    }
}
