package reptositories.weatherReports;


import reptositories.coordinatesAndCity.City;
import reptositories.requests.WeatherRequest;

public class SimpleReport {


    public String getFullWeatherInfoByCityName(String cityName) {
        return new WeatherRequest(cityName).getFullWeatherInfo();
    }

    public String getFullWeatherInfoByCity(City city) {
        return new WeatherRequest(city).getFullWeatherInfo();
    }


}
