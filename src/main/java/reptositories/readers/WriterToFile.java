package reptositories.readers;


import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {


    public void writeToFile(String stringToWrite, String fileToWrite) {
        try {
            FileWriter writer = new FileWriter(fileToWrite, true);
            writer.write(stringToWrite);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
