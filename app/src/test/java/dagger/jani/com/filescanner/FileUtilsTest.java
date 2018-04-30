package dagger.i.com.filemanager;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class FileUtilsTest {

    private ArrayList<File> files;

    @Test
    public void getStringSizeLengthFile_input_oneMb_pass() {
        long input = 1024 * 1024;
        assertEquals(FileUtils.getStringSizeLengthFile(input), "1.0Mb");
    }



    @Test
    public void getMimeType_extensionRandom_returnAll() {
        String expectedOp = "*/*";
        File file = new File("testpath/rest.xcd");
        assertEquals(FileUtils.getMimeType(file),expectedOp);
    }


}