package dagger.jani.com.filescanner;
import android.support.annotation.NonNull;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    public static List<FileModel> getFrequency(ArrayList<File> files) {
        List<FileModel> fileModelList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            fileModelList.add(new FileModel("N/A", "N/A"));
        }
        Map<String, Integer> freqMap = new HashMap<>();
        for (File file : files) {
            String mime = getMimeType(file);
            if (freqMap.containsKey(mime)) {
                freqMap.put(mime, freqMap.get(mime) + 1);
            } else {
                freqMap.put(mime, 1);
            }
        }

        Set<Map.Entry<String, Integer>> set = freqMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        int index = 0;
        for (Map.Entry<String, Integer> entry : list) {

            fileModelList.set(index++, new FileModel(entry.getKey(), entry.getValue() + ""));
            if (index == 5) {
                break;
            }
        }
        return fileModelList;
    }


    @NonNull
    static String getMimeType(@NonNull File file) {
        String type = null;
        final String url = file.toString();
        final String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
        }
        if (type == null) {
            type = "*/*"; // fallback type. You might set it to */*
        }
        return type;
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
