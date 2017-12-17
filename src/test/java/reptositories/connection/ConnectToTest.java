package reptositories.connection;

import org.junit.Test;
import reptositories.coordinatesandcity.City;

import static org.junit.Assert.assertEquals;
public class ConnectToTest {


    @Test
    public void testBuildLinkForRequestByCityObject1(){
        City city = new City("Tallinn", "EE");
        assertEquals(new ConnectionAddress().buildLinkForRequest(city),("http://api.openweathermap.org/data/2.5/find?q=Tallinn,EE&APPID=1fd8292118ee92959ac8793f9b0d9c1c"));
    }

    @Test
    public void testBuildLinkForForecastByCityObject1(){
        City city = new City("Berlin", "DE");
        assertEquals(new ConnectionAddress().buildLinkForForecast(city),("http://api.openweathermap.org/data/2.5/forecast?q=Berlin,DE&APPID=1fd8292118ee92959ac8793f9b0d9c1c"));


    }

    @Test
    public void testBuildLinkForRequestByCityName1(){

        assertEquals(new ConnectionAddress().buildLinkForRequest("Narva"),("http://api.openweathermap.org/data/2.5/find?q=Narva&APPID=1fd8292118ee92959ac8793f9b0d9c1c"));

    }

    @Test
    public void testBuildLinkForForecastByCityName1(){
        assertEquals(new ConnectionAddress().buildLinkForForecast("Pussi"),("http://api.openweathermap.org/data/2.5/forecast?q=Pussi&APPID=1fd8292118ee92959ac8793f9b0d9c1c"));

    }


}