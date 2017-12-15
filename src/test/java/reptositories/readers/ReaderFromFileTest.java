package reptositories.readers;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;


public class ReaderFromFileTest {

    @Test(expected = IOException.class)
    public void testReadFromNotExistingFileException() throws IOException {
        ReaderFromFile reader = new ReaderFromFile();
        reader.readCityNamesAndReturnArray("notExistingFile1.txt");
        assertEquals(reader.readCityNamesAndReturnArray("notExistingFile1.txt"),new ArrayList<String>());
    }



    @Test(expected = IOException.class)
    public void testReadFromNotExistingFileException1() throws IOException {
        ReaderFromFile reader = new ReaderFromFile();
        reader.readCityNamesAndReturnArray("notExistingFile1.txt");
        assertEquals(reader.readCityNamesAndReturnArray("notExistingFile1.txt"),new ArrayList<String>());
    }







}