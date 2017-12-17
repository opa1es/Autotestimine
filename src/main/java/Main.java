import reptositories.consolereader.ConsoleReader;
import reptositories.coordinatesandcity.City;
import reptositories.requests.WeatherRequest;
import reptositories.weatherreports.ReportByNames;
import reptositories.weatherreports.ReportFromConsole;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        City cityTallinn = new City("Tallinn","EE");

        WeatherRequest requestWeather = new WeatherRequest("Tallinn");
        ReportByNames reportByNames = new ReportByNames();
        ReportFromConsole reportFromConsole = new ReportFromConsole();


        System.out.println(reportFromConsole.getFullWeatherInfoByInput(new ConsoleReader()));




//        System.out.println(requestWeather.getMaxTemperaturesForThreeDays());
        //System.out.println(requestWeather.getMaxTemperaturesForThreeDaysInCelsius());
        //System.out.println(requestWeather.getFullInfo());
//        System.out.println(requestWeather.getFullInfo());
//        System.out.println(reportByNames.getFullWeatherReportAndWriteToFile());
    }


}
