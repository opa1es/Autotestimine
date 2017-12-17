package reptositories.readers;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WriterToFileTest {


    @Test
    public void testWriterCreatesFile() {
        String fileName = "testFile.txt";

        File testFile = new File(fileName);
        testFile.delete();

        WriterToFile writer = new WriterToFile();

        writer.writeToFile("aaa1", fileName);

        if (!testFile.exists()) {
            fail("File did not appear!");
        }
    }


    @Test
    public void testWriterCreatesFile1() {
        String fileName = "testFile1.txt";

        File testFile = new File(fileName);
        testFile.delete();

        WriterToFile writer = new WriterToFile();

        writer.writeToFile("testString1OlolOloloLLOlo", fileName);

        if (!testFile.exists()) {
            fail("File did not appear!");
        }
    }


    @Test
    public void testWriterWritesLineIntoFile() {
        String fileName = "testFile2.txt";

        File testFile = new File(fileName);
        testFile.delete();
        WriterToFile writer = new WriterToFile();
        writer.writeToFile("testString", fileName);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String aaa = br.readLine();
            assertEquals(aaa, "testString");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testWriterWritesLineIntoFile1() {
        String fileName = "testFile3.txt";

        File testFile = new File(fileName);
        testFile.delete();
        WriterToFile writer = new WriterToFile();
        writer.writeToFile("testtest", fileName);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String aaa = br.readLine();
            assertEquals(aaa, "testtest");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}