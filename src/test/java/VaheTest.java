import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class VaheTest {


    @Test
    public void testSetTemperatureByCoordinatesIsInAvailableRange() {
        assertTrue(Vahe.setTemperatureByCoordinates("xxx yyy") > -99 &&
                Vahe.setTemperatureByCoordinates("xxx yyy") < 99);
    }


    @Test
    public void testGetInputCoordinatesNotNull() {
        assertNotEquals(null, Vahe.getInputCoordinates("xxx yyy"));
    }

    @Test
    public void testGetWeatherCodeByCoordinates() {
        assertNotEquals(null, Vahe.getWeatherCodeByCoordinates("xxx yyy"));
    }

    @Test
    public void testGetSourceByURL() {
        assertNotEquals(null, Vahe.getSourceByURL("www page com"));
    }

    @Test
    public void testSearchInputDay() {
        ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"));

        assertTrue(days.contains(Vahe.getSourceByURL("www page com")));
    }


    @Test
    public void testSearchInputDayToday() {

        assertNotEquals(null, Vahe.searchInputDay(0));

    }

    @Test
    public void testSearchInputDay1() {

        assertNotEquals(null, Vahe.searchInputDay(1));

    }

    @Test
    public void testSearchInputDay2() {

        assertNotEquals(null, Vahe.searchInputDay(2));

    }

    @Test
    public void testSearchInputDay3() {

        assertNotEquals(null, Vahe.searchInputDay(3));

    }


    @Test
    public void testGetDayOnCalenderByInputInDate() {

        assertNotEquals(null, Vahe.getDayOnCalenderByInputInDate(new Date(1, 2, 3)));

    }

    @Test
    public void testSetTemperatureForGivenDay0() {

        assertEquals(null, Vahe.setTemperatureForGivenDay("xxx yyy", 0));

    }

    @Test
    public void testSetTemperatureForGivenDay1() {

        assertEquals(null, Vahe.setTemperatureForGivenDay("xxx yyy", 1));

    }

    @Test
    public void TestSetTemperatureForGivenDay2() {

        assertEquals(null, Vahe.setTemperatureForGivenDay("xxx yyy", 2));

    }

    @Test
    public void TestSetTemperatureForGivenDay3() {

        assertEquals(null, Vahe.setTemperatureForGivenDay("xxx yyy", 3));

    }

}