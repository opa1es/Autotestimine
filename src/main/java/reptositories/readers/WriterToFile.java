package reptositories.readers;


import reptositories.requests.WeatherRequest;

import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {


    public void writeFullInfo(WeatherRequest requestWeather) {
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write("Somthing to write...");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
