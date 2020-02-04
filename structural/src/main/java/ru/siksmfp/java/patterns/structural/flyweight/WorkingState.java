package ru.siksmfp.java.patterns.structural.flyweight;

public class WorkingState extends State {

    @Override
    public void doSomething() {
        System.out.println("Hello from Working state");
    }
}
