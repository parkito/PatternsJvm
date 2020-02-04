package ru.siksmfp.java.patterns.structural.flyweight;

public class QuotedState extends State {

    @Override
    public void doSomething() {
        System.out.println("Hello from Quoted state");
    }
}
