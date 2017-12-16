package reptositories.coordinatesAndCity;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class CityTest {
    @Test
    void testGetCityCoordinatesAsString() {
        City city = new City("Tallinn","EE");
        city.getCoordinates().setCoordinates(111.12,111.12);
        assertEquals(city.getCoordinates().toString(),"111.12:111.12");

    }

}