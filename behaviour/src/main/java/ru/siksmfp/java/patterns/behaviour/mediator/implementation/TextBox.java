package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

import java.util.Objects;

public class TextBox extends Element {
    private String name = "TextBox";
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
        System.out.println("Text Box on add");
    }

    @Override
    public void actionOnDelete() {
        System.out.println("Text Box on delete");
    }

    @Override
    public void actionOnUpdate() {
        System.out.println("Text Box on update");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBox textBox = (TextBox) o;
        return Objects.equals(name, textBox.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
