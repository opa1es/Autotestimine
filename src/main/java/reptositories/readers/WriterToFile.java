package reptositories.readers;


import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {


    public void writeFullInfo(String string) {
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(string);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
