package ru.siksmfp.java.patterns.structural.flyweight;

public abstract class State {
    public static State create(Class<? extends State> clazz) {
        return StateFactory.getInstance().get(clazz);
    }

    public abstract void doSomething();
}