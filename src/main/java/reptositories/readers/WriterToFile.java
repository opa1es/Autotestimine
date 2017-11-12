package reptositories.readers;


import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

public class WriterToFile {

    public void writeTemperature(String fileName, double temperature) {
        List<String> temperatureToWrite = Arrays.asList("Current temperature: ", Double.toString(temperature));
        try {
            FileWriter writer = new FileWriter(fileName + ".txt", true);
            writer.write(temperatureToWrite + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
