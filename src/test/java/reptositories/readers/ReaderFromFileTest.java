package reptositories.readers;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;


public class ReaderFromFileTest {
    private ReaderFromFile reader;

    @BeforeEach
    void setUP() {
        reader = new ReaderFromFile();
    }


    @Test(expected = IOException.class)
    public void testReadFromNotExistingFileException() throws IOException {
        reader.readCityNamesAndReturnArray("notExistingFile1.txt");
        assertEquals(reader.readCityNamesAndReturnArray("notExistingFile1.txt"), new ArrayList<String>());
    }


    @Test(expected = IOException.class)
    public void testReadFromNotExistingFileException1() throws IOException {

        reader.readCityNamesAndReturnArray("notExistingFile1.txt");
        assertEquals(reader.readCityNamesAndReturnArray("notExistingFile1.txt"), new ArrayList<String>());
    }


}