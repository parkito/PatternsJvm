package ru.siksmfp.java.patterns.behaviour.chain.implementation;

public class Main {
    public static void main(String[] args) {
        File movie = new File("movie", FileType.AVI);
        File audio = new File("audio", FileType.MP3);
        File text = new File("text", FileType.PDF);
        File unknown = new File("unknown", FileType.UNKNOWN);

        Handler processor = new AudioHandler(new VideoHandler(new DocHandler(new DefaultHandler())));
        processor.doProcess(movie);
        processor.doProcess(audio);
        processor.doProcess(text);
        processor.doProcess(unknown);

//        File movie is video file. It'll be processed as video file
//        File audio is audio file. It'll be processed as audio file
//        File text is doc file. It'll be processed as doc file
//        There is no handler for unknown
    }
}
