package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

public interface Mediator {

    void add(Element element);

    void delete(Element element);

    void update(Element element);

    void show();
}
