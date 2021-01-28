package ru.siksmfp.java.patterns.behaviour.observer;

interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    <T> void notify(T data);
}
