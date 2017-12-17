package reptositories.weatherreports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reptositories.weatherdata.WeatherForecast;
import reptositories.weatherdata.WeatherRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;


class SimpleReportTest {

    private WeatherRequest weatherRequest;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void setup() {
        weatherRequest = mock(WeatherRequest.class);
        weatherForecast = mock(WeatherForecast.class);

    }


    @Test
    void testGetReport() {


        SimpleReport simpleReport = new SimpleReport();

        when(weatherRequest.toString()).thenReturn("aaa1");
        when(weatherForecast.toString()).thenReturn("bb2");

        assertEquals(simpleReport.getWeatherReport(weatherRequest, weatherForecast), "aaa1bb2");
    }


    @Test
    void testGetReport1() {

        SimpleReport simpleReport = new SimpleReport();

        when(weatherRequest.toString()).thenReturn("someRequest");
        when(weatherForecast.toString()).thenReturn("someForecast");

        assertEquals(simpleReport.getWeatherReport(weatherRequest, weatherForecast), "someRequestsomeForecast");

    }

}