package dagger.jani.com.filescanner;

public class FileUtils {
    public static String getStringSizeLengthFile(long size) {
        float sizeInMb = Math.round((float) size / (1024 * 1024));

        return sizeInMb + "Mb";
    }
}
