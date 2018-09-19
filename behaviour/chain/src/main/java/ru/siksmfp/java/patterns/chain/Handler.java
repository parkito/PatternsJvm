package chain.src.main.java.ru.siksmfp.java.patterns.chain;

interface Handler {
    String getHandlerName();

    boolean isDataCorrect(File file);

    void process(File file);
}
