package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

import java.util.ArrayList;
import java.util.List;

public class SceneMediator implements Mediator {

    private TextBox textBox;
    private TextField textField;
    private CheckBox checkBox;

    private List<Element> elements = new ArrayList<>();

    public SceneMediator() {
    }

    public void init(TextBox textBox, TextField textField, CheckBox checkBox) {
        this.textBox = textBox;
        this.textField = textField;
        this.checkBox = checkBox;
    }

    @Override
    public void add(Element element) {
        elements.add(element);
        textBox.actionOnAdd();
    }

    @Override
    public void delete(Element element) {
        elements.remove(element);
        textField.actionOnDelete();
    }

    @Override
    public void update(Element element) {
        elements.stream()
                .filter(e -> e.equals(element)).findFirst().get().actionOnUpdate();
    }

    @Override
    public void show() {
        elements.forEach(System.out::println);
    }
}
