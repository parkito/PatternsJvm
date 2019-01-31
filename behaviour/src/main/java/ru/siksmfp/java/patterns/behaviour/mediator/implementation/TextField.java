package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

import java.util.Objects;

public class TextField extends Element{
    private String name = "TextField";
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(String name) {
        this.name = name;
        mediator.add(this);
    }

    public void remove() {
        name = "Removed " + name;
        mediator.delete(this);
    }

    public void update(String name) {
        this.name = "Updated " + name;
        mediator.update(this);
    }

    @Override
    public void actionOnAdd() {
        System.out.println("Text Field on add");
    }

    @Override
    public void actionOnDelete() {
        System.out.println("Text Field on delete");
    }

    @Override
    public void actionOnUpdate() {
        System.out.println("Text Field on update");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextField textField = (TextField) o;
        return Objects.equals(name, textField.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
