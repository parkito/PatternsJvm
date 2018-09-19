package chain.src.main.java.ru.siksmfp.java.patterns.chain;

public class Main {
    public static void main(String[] args) {
        AutoHandler autoHandler = new AutoHandler();
        File audio = new File("Audio", "Leps");
        File video = new File("Video", "Sex");
        File text = new File("Text", "List");
        File unknown = new File("Unknown", "Virus");

        autoHandler.process(audio);
        autoHandler.process(video);
        autoHandler.process(text);
        autoHandler.process(unknown);
    }
}
