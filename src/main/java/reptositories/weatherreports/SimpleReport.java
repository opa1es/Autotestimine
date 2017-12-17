package reptositories.weatherreports;


import reptositories.requests.WeatherForecast;
import reptositories.requests.WeatherRequest;

public class SimpleReport {


    public String getWeatherReport(WeatherRequest weatherRequest, WeatherForecast weatherForecast) {
        return weatherRequest.toString() + weatherForecast.toString();
    }



}
