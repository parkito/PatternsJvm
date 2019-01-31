package ru.siksmfp.java.patterns.behaviour.mediator.implementation;

public class Main {
    public static void main(String[] args) {
        SceneMediator sceneMediator = new SceneMediator();

        TextField textField = new TextField();
        textField.setMediator(sceneMediator);

        TextBox textBox = new TextBox();
        textBox.setMediator(sceneMediator);

        CheckBox checkBox = new CheckBox();
        checkBox.setMediator(sceneMediator);

        sceneMediator.init(textBox, textField, checkBox);

        textBox.add("one");
        sceneMediator.show();

        textField.add("two");
        sceneMediator.show();

        checkBox.add("three");
        sceneMediator.show();
    }
}
