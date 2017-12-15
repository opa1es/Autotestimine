package reptositories.unitsConverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;


class ConvertTemperatureTest {
    @Test
    void testConvertListKelvinToCelsius() {
        ConvertTemperature convertTemperature = new ConvertTemperature();

        assertEquals(convertTemperature.convertListKelvinToCelsius(new ArrayList<Double>(Arrays.asList(1d, 2d, 3d))),
                new ArrayList<Double>(Arrays.asList(-272.0, -271.0, -270.0)));

    }

    @Test
    void testConvertListKelvinToCelsius1() {
        ConvertTemperature convertTemperature = new ConvertTemperature();

        assertEquals(convertTemperature.convertListKelvinToCelsius(new ArrayList<Double>(Arrays.asList(273d, 274d, 275d))),
                new ArrayList<Double>(Arrays.asList(0d, 1d, 2d)));

    }


    @Test
    void testKelvinToCelsius() {
        ConvertTemperature convertTemperature = new ConvertTemperature();
        assertEquals(convertTemperature.kelvinToCelsius(0), -273.0);

    }

    @Test
    void testKelvinToCelsius1() {
        ConvertTemperature convertTemperature = new ConvertTemperature();
        assertEquals(convertTemperature.kelvinToCelsius(13), -260.0);

    }


    @Test
    void testCelsiusToKelvin() {
        ConvertTemperature convertTemperature = new ConvertTemperature();
        assertEquals(convertTemperature.celsiusToKelvin(23), 296.15);

    }

    @Test
    void testCelsiusToKelvin1() {
        ConvertTemperature convertTemperature = new ConvertTemperature();
        assertEquals(convertTemperature.celsiusToKelvin(13), 286.15);

    }

}