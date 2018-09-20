package ru.siksmfp.java.patterns.chain;

interface Handler {
    String getHandlerName();

    boolean isDataCorrect(File file);

    void process(File file);
}
