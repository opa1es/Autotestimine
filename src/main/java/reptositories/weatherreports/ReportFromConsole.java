package reptositories.weatherreports;


import reptositories.consolereader.ConsoleReader;
import reptositories.requests.WeatherForecast;
import reptositories.requests.WeatherRequest;

public class ReportFromConsole {


    public String getFullWeatherInfoByInput(ConsoleReader consoleReader) {
        String cityName = consoleReader.readAndReturnCity();
        return new WeatherRequest(cityName).toString() + new WeatherForecast(cityName).toString();


    }


}
