package ru.siksmfp.java.patterns.behaviour.observer;

public interface Observer {

    <T> void update(T data);

    String getId();
}
