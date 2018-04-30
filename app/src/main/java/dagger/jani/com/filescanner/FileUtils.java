package dagger.jani.com.filescanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileUtils {
    public static String getStringSizeLengthFile(long size) {
        float sizeInMb = Math.round((float) size / (1024 * 1024));

        return sizeInMb + "Mb";
    }
    public static String calculateAvgFileSize(ArrayList<File> files) {
        long totalSize = 0l;
        for (File file : files) {
            totalSize += file.length();
        }
        return getStringSizeLengthFile(totalSize / files.size());

    }

    public static ArrayList<File> generateFileAnalytics(ArrayList<File> files) {
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                long aSize = a.length();
                long bSize = b.length();
                if (aSize < bSize) {
                    return 1;
                } else if (aSize > bSize) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        if (files.size() > 9)
            return new ArrayList<>(files.subList(0, 9));
        else
            return files;
    }

    public static ArrayList<File> walkDir(File dir, ArrayList<File> files) {
        File[] listFile = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    walkDir(listFile[i], files);
                } else {
                    files.add(listFile[i]);
                }
            }
        }
        return files;
    }
}
