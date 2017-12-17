package reptositories.coordinatesandcity;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class CityTest {
    @Test
    void testGetCityCoordinatesAsString() {
        City city = new City("Tallinn","EE");
        city.getCoordinates().setCoordinates(111.12,111.12);
        assertEquals(city.getCoordinates().toString(),"111.12:111.12");

    }
    @Test
    void testGetCityCoordinatesAsString1() {
        City city = new City("Tallinn");
        city.getCoordinates().setCoordinates(321.12,321.12);
        assertEquals(city.getCoordinates().toString(),"321.12:321.12");

    }

}