package reptositories.connection;


import org.junit.Test;
import reptositories.coordinatesAndCity.City;

public class ConnectToTest {


    @Test
    public void testBuildLinkForRequestByCityObject1() throws Exception {
        City city = new City("Tallinn", "EE");
        assert new ConnectTo().buildLinkForRequest(city).equals("http://api.openweathermap.org/data/2.5/find?q=Tallinn,EE&APPID=1fd8292118ee92959ac8793f9b0d9c1c");
    }

    @Test
    public void testBuildLinkForForecastByCityObject1() throws Exception {
        City city = new City("Berlin", "DE");
        assert new ConnectTo().buildLinkForForecast(city).equals("http://api.openweathermap.org/data/2.5/forecast?q=Berlin,DE&APPID=1fd8292118ee92959ac8793f9b0d9c1c");


    }

    @Test
    public void testBuildLinkForRequestByCityName1() throws Exception {

        assert new ConnectTo().buildLinkForRequest("Narva").equals("http://api.openweathermap.org/data/2.5/find?q=Narva&APPID=1fd8292118ee92959ac8793f9b0d9c1c");

    }

    @Test
    public void testBuildLinkForForecastByCityName1() throws Exception {
        assert new ConnectTo().buildLinkForForecast("Pussi").equals("http://api.openweathermap.org/data/2.5/forecast?q=Pussi&APPID=1fd8292118ee92959ac8793f9b0d9c1c");

    }


}