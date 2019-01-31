package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

import java.util.Objects;

public class CheckBox extends Element {

    private String name = "CheckBox";
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void actionOnAdd() {
        System.out.println("Check Box on add");
    }

    @Override
    public void actionOnDelete() {
        System.out.println("Check Box on delete");
    }

    @Override
    public void actionOnUpdate() {
        System.out.println("Check Box on update");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckBox checkBox = (CheckBox) o;
        return Objects.equals(name, checkBox.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
