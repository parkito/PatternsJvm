package ru.siksmfp.java.patterns.chain;

public class Audio implements Handler {
    private String dataType = "Audio";

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
        System.out.println(file.getFileName() + " is playing");
    }
}
