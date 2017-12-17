package reptositories.weatherdata;

import org.junit.Test;
import reptositories.coordinatesandcity.City;
import reptositories.exceptions.NoSuchCityException;


public class WeatherForecastTest {



    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionWhenGetsWrongCityAsString() {
        WeatherForecast weatherForecast = new WeatherForecast("NotExistingCity");
        System.out.println(weatherForecast.toString());
    }


    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionWhenGetsWrongCityAsObject() {
        City city = new City("UNKNOWN","EE");
        WeatherForecast weatherForecast = new WeatherForecast(city);
        System.out.println(weatherForecast.toString());
    }


}