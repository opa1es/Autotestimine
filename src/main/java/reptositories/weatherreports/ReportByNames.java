package reptositories.weatherreports;


import reptositories.readers.ReaderFromFile;
import reptositories.readers.WriterToFile;
import reptositories.weatherdata.WeatherForecast;
import reptositories.weatherdata.WeatherRequest;

import java.io.IOException;

public class ReportByNames {

    public String getFullWeatherReportAndWriteToFile(ReaderFromFile readerFromFile, WriterToFile writerToFile, String file) throws IOException {
        String output = "";
        for (String city : readerFromFile.readCityNamesAndReturnArray("cities.txt")) {
            WeatherRequest weatherRequest = new WeatherRequest(city);
            WeatherForecast weatherForecast = new WeatherForecast(city);
            output += weatherRequest.toString() + weatherForecast.toString() + "\n";

        }

        writerToFile.writeToFile(output,file);
        return output;
    }


}
