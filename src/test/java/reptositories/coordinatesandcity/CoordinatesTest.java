package reptositories.coordinatesandcity;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class CoordinatesTest {
    @Test
    void testGetCoordinatesInFormat() {
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(55.555, 55.555);
        assertEquals(coordinates.toString(), "55.555:55.555");
    }


}