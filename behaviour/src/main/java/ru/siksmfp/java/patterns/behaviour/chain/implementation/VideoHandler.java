package ru.siksmfp.java.patterns.behaviour.chain.implementation;

import java.util.Arrays;
import java.util.List;

import static ru.siksmfp.java.patterns.behaviour.chain.implementation.FileType.AVI;
import static ru.siksmfp.java.patterns.behaviour.chain.implementation.FileType.WMA;

public class VideoHandler implements Handler {

    private static final List<FileType> VIDEO_TYPES = Arrays.asList(AVI, WMA);

    private Handler nextHandler;

    public VideoHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void doProcess(File file) {
        if (VIDEO_TYPES.contains(file.getGetFileType())) {
            System.out.println("File " + file.getGetName() + " is video file. It'll be processed as video file");
        } else {
            nextHandler.doProcess(file);
        }
    }
}
