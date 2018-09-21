package ru.siksmfp.java.patterns.chain.my;

import ru.siksmfp.java.patterns.chain.my.model.File;
import ru.siksmfp.java.patterns.chain.my.register.HandlerRegister;

public class Main {
    public static void main(String[] args) {
        HandlerRegister handlerRegister = new HandlerRegister();

        File audio = new File("Audio", "Leps");
        File video = new File("Video", "Sex");
        File text = new File("Text", "List");
        File unknown = new File("Unknown", "Virus");

        handlerRegister.process(audio);
        handlerRegister.process(video);
        handlerRegister.process(text);
        handlerRegister.process(unknown);

//        Leps is playing
//        Sex is displaying
//        List is reading
//        Handler for Virus.Unknown wasn't found
    }
}
