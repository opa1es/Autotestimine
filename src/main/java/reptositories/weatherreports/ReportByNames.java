package reptositories.weatherreports;


import reptositories.readers.ReaderFromFile;
import reptositories.readers.WriterToFile;
import reptositories.requests.WeatherForecast;
import reptositories.requests.WeatherRequest;

import java.io.IOException;

public class ReportByNames {

    private ReaderFromFile readerFromFile = new ReaderFromFile();
    private WriterToFile writerToFile = new WriterToFile();

    public String getFullWeatherReportAndWriteToFile(String file) throws IOException {
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
