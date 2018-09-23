package ru.siksmfp.java.patterns.behaviour.chain.implementation;

import java.util.Arrays;
import java.util.List;

import static ru.siksmfp.java.patterns.behaviour.chain.implementation.FileType.*;

public class DocHandler implements Handler {

    private static final List<FileType> DOC_TYPES = Arrays.asList(PDF, DOC, DOCX);

    private Handler nextHandler;

    public DocHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void doProcess(File file) {
        if (DOC_TYPES.contains(file.getGetFileType())) {
            System.out.println("File " + file.getGetName() + " is doc file. It'll be processed as doc file");
        } else {
            nextHandler.doProcess(file);
        }
    }
}
