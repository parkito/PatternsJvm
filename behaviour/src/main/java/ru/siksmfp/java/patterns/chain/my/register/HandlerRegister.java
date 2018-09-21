package ru.siksmfp.java.patterns.chain.my.register;

import ru.siksmfp.java.patterns.chain.my.handler.api.Handler;
import ru.siksmfp.java.patterns.chain.my.handler.impl.AudioHandler;
import ru.siksmfp.java.patterns.chain.my.handler.impl.Text;
import ru.siksmfp.java.patterns.chain.my.handler.impl.VideoHandler;
import ru.siksmfp.java.patterns.chain.my.model.File;

import java.util.ArrayList;
import java.util.List;

public class HandlerRegister {
    private List<Handler> handlers = new ArrayList<>();

    public HandlerRegister() {
        handlers.add(new AudioHandler());
        handlers.add(new VideoHandler());
        handlers.add(new Text());
    }

    public void process(File file) {
        for (Handler handler : handlers) {
            if (handler.isDataCorrect(file)) {
                handler.process(file);
                return;
            }
        }
        System.out.println("Handler for " + file.getFileName() + "." + file.getDataType() + " wasn't found");
    }
}
