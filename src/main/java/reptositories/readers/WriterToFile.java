package reptositories.readers;


import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {


    public void writeTemperature(String fileName, String cityName, double temperature) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Temperature in " + cityName + " is : " + temperature + " Kelvins"+ "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
