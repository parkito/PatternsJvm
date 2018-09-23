package ru.siksmfp.java.patterns.behaviour.command.implementation;

public class IncrementAgeCommand implements Command {

    private Person person;

    public IncrementAgeCommand(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        person.setAge(person.getAge() + 1);

    }
}
