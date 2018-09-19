package chain.src.main.java.ru.siksmfp.java.patterns.chain;

public class Text implements Handler {
    private String dataType = "Text";

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
        System.out.println(file.getFileName() + " is reading");
    }
}
