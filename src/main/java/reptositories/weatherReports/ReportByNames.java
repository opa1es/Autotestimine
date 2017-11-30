package reptositories.weatherReports;


import reptositories.readers.ReaderFromFile;
import reptositories.readers.WriterToFile;
import reptositories.requests.WeatherRequest;

public class ReportByNames {

    private ReaderFromFile readerFromFile = new ReaderFromFile();
    private WriterToFile writerToFile = new WriterToFile();

    public String getFullWeatherReportAndWriteToFile() {
        String output = "";
        for (String city : readerFromFile.readCityNamesAndReturnArray()) {
            WeatherRequest weatherRequest = new WeatherRequest(city);
            output += weatherRequest.getFullWeatherInfo();
            output += "\n";

        }

        writerToFile.writeFullInfo(output);
        return output;
    }


}
