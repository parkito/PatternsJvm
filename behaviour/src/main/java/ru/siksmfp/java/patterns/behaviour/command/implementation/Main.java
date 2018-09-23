package ru.siksmfp.java.patterns.behaviour.command.implementation;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Name", 23);

        ChangeNameToDefaultCommand changeNameToDefaultCommand = new ChangeNameToDefaultCommand(person);
        IncrementAgeCommand incrementAgeCommand = new IncrementAgeCommand(person);

        System.out.println(person.getName());
        changeNameToDefaultCommand.execute();
        System.out.println(person.getName());

        System.out.println(person.getAge());
        incrementAgeCommand.execute();
        System.out.println(person.getAge());
    }
}
