package com.siksmfp.creational.flyweight;

public class WorkingState extends State {

    @Override
    public void doSomething() {
        System.out.println("Hello from Working state");
    }
}
