package ru.siksmfp.java.patterns.behaviour.chain.implementation;

public class File {

    private String getName;
    private FileType getFileType;

    public File(String getName, FileType getFileType) {
        this.getName = getName;
        this.getFileType = getFileType;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public FileType getGetFileType() {
        return getFileType;
    }

    public void setGetFileType(FileType getFileType) {
        this.getFileType = getFileType;
    }
}
