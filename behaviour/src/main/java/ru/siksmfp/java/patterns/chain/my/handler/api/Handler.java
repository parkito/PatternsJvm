package ru.siksmfp.java.patterns.chain.my.handler.api;

import ru.siksmfp.java.patterns.chain.my.model.File;

public interface Handler {
    String getHandlerName();

    boolean isDataCorrect(File file);

    void process(File file);
}
