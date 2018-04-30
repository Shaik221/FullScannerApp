package dagger.i.com.filemanager;

public class FileModel {


    public String getName() {
        return name;
    }

    public String getFreq() {
        return freq;
    }

    private final String name;
    private final String freq;

    public FileModel(String name, String freq) {
        this.name = name;
        this.freq = freq;
    }
}
