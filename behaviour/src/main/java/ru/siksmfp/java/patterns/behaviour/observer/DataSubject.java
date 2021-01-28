package ru.siksmfp.java.patterns.behaviour.observer;

import java.util.ArrayList;
import java.util.List;

public class DataSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        System.out.println("Registering " + observer.getId());
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public <T> void notify(T data) {
        observers.forEach(observer -> observer.update(data));
    }
}
