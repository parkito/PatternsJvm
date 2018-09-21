package ru.siksmfp.java.patterns.chain.my.model;

public class File {

    public File(String dataType, String fileName) {
        this.dataType = dataType;
        this.fileName = fileName;
    }

    private String dataType;
    private String fileName;

    public String getDataType() {
        return dataType;
    }

    public String getFileName() {
        return fileName;
    }
}
