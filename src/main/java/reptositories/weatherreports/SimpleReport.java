package reptositories.weatherreports;


import reptositories.weatherdata.WeatherForecast;
import reptositories.weatherdata.WeatherRequest;

public class SimpleReport {


    public String getWeatherReport(WeatherRequest weatherRequest, WeatherForecast weatherForecast) {
        return weatherRequest.toString() + weatherForecast.toString();
    }



}
