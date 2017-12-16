package reptositories.json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reptositories.coordinatesAndCity.City;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class JsonBuilderTest {


    City cityMock;
    JsonBuilder jsonBuilder;
    @BeforeEach
    void setUP(){
        cityMock = mock(City.class);
        jsonBuilder = new JsonBuilder();
    }




    @Test
    void test_getForecastJSON() {
        try {
            assertNotNull(jsonBuilder.getRequest(cityMock));
        } catch (IOException e) {
            fail("It is Null...");
        }
    }

}