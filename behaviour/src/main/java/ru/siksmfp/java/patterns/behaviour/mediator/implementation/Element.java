package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

public abstract class Element {

    public abstract void setMediator(Mediator mediator);

    public abstract String getName();

    public abstract void actionOnAdd();

    public abstract void actionOnDelete();

    public abstract void actionOnUpdate();
}
