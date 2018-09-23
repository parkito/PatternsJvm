package ru.siksmfp.java.patterns.behaviour.chain.implementation;

import java.util.Arrays;
import java.util.List;

import static ru.siksmfp.java.patterns.behaviour.chain.implementation.FileType.MP3;

public class AudioHandler implements Handler {

    private static final List<FileType> DOC_TYPES = Arrays.asList(MP3);

    private Handler nextHandler;

    public AudioHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void doProcess(File file) {
        if (DOC_TYPES.contains(file.getGetFileType())) {
            System.out.println("File " + file.getGetName() + " is audio file. It'll be processed as audio file");
        } else {
            nextHandler.doProcess(file);
        }
    }
}
