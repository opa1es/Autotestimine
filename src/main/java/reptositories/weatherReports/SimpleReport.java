package reptositories.weatherReports;


import reptositories.coordinatesAndCity.City;
import reptositories.requests.WeatherForecast;
import reptositories.requests.WeatherRequest;

public class SimpleReport {


    public String getFullWeatherInfoByCityName(String cityName) {
        return new WeatherRequest(cityName).toString() + new WeatherForecast(cityName).toString();
    }

    public String getFullWeatherInfoByCity(City city) {
        return new WeatherRequest(city).toString() + new WeatherForecast(city).toString();
    }


}
