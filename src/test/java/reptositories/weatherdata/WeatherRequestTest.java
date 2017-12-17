package reptositories.weatherdata;

import org.junit.Test;
import reptositories.coordinatesandcity.City;
import reptositories.exceptions.NoSuchCityException;


public class WeatherRequestTest {

    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionWhenGetsWrongCityAsString() {
        WeatherRequest weatherRequest = new WeatherRequest("NotExistingCity");
        System.out.println(weatherRequest.toString());
    }


    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionWhenGetsWrongCityAsObject() {
        City city = new City("UNKNOWN","EE");
        WeatherRequest weatherRequest = new WeatherRequest(city);
        System.out.println(weatherRequest.toString());
    }

}