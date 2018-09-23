package ru.siksmfp.java.patterns.behaviour.chain.implementation;

public class DefaultHandler implements Handler {
    @Override
    public void doProcess(File file) {
        System.out.println("There is no handler for " + file.getGetName());
    }
}
