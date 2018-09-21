package ru.siksmfp.java.patterns.chain.my.handler.impl;

import ru.siksmfp.java.patterns.chain.my.model.File;
import ru.siksmfp.java.patterns.chain.my.handler.api.Handler;

public class VideoHandler implements Handler {

    private String dataType = "Video";

    @Override
    public String getHandlerName() {
        return dataType;
    }

    @Override
    public boolean isDataCorrect(File file) {
        return file.getDataType().equals(dataType) ? true : false;
    }

    @Override
    public void process(File file) {
        System.out.println(file.getFileName() + " is displaying");
    }
}
