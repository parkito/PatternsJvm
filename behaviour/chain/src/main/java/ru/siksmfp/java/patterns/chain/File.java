package chain.src.main.java.ru.siksmfp.java.patterns.chain;

/**
 * Created by Artyom Karnov on 05.11.16.
 * artyom-karnov@yandex.ru
 **/
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
