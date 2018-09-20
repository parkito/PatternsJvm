package ru.siksmfp.java.patterns.chain;

import java.util.ArrayList;
import java.util.List;

public class AutoHandler {
    private List<Handler> handlers = new ArrayList<>();

    public AutoHandler() {
        handlers.add(new Audio());
        handlers.add(new Video());
        handlers.add(new Text());
    }

    public void process(File file) {
        boolean isAllRight = false;
        for (Handler handler : handlers) {
            if (handler.isDataCorrect(file)) {
                handler.process(file);
                isAllRight = true;
                break;
            }
        }
        if (isAllRight == false)
            System.out.println("Handler for " + file.getFileName() + "." + file.getDataType() + " wasn't found");
    }
}
