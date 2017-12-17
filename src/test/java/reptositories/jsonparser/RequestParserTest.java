package reptositories.jsonparser;

import org.json.JSONObject;
import org.junit.Test;
import reptositories.json.JsonBuilder;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class RequestParserTest {


    private RequestParser requestParserTallinn;
    private RequestParser requestParserMoscow;
    private JsonBuilder jsonBuilderMock;


    @Test
    public void getCoordinatesTallinn() throws Exception {
        JSONObject jsonObjectTallinn = new JSONObject("{\"message\":\"accurate\",\"cod\":\"200\",\"count\":2,\"list\":[{\"id\":590447,\"name\":\"Tallinn\",\"coord\":{\"lat\":59.4372,\"lon\":24.7454},\"main\":{\"temp\":273.15,\"pressure\":1015,\"humidity\":100,\"temp_min\":273.15,\"temp_max\":273.15},\"dt\":1513538400,\"wind\":{\"speed\":1.5,\"deg\":200},\"sys\":{\"country\":\"EE\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}]},{\"id\":715126,\"name\":\"Tallinn\",\"coord\":{\"lat\":47.1836,\"lon\":20.2088},\"main\":{\"temp\":272.04,\"pressure\":1019,\"humidity\":91,\"temp_min\":271.15,\"temp_max\":273.15},\"dt\":1513536300,\"wind\":{\"speed\":2.1,\"deg\":330},\"sys\":{\"country\":\"HU\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":20},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50n\"}]}]}");

        jsonBuilderMock = mock(JsonBuilder.class);
        when(jsonBuilderMock.getRequest(anyString())).thenReturn(jsonObjectTallinn);
        requestParserTallinn = new RequestParser(jsonBuilderMock.getRequest(anyString()));

        assertEquals("24.7454:59.4372", requestParserTallinn.getCityCoordinates().toString());
    }

    @Test
    public void getCoordinatesMoscow() throws Exception {
        JSONObject jsonObjectMoscow = new JSONObject("{\"message\":\"accurate\",\"cod\":\"200\",\"count\":5,\"list\":[{\"id\":5807540,\"name\":\"Moscow\",\"coord\":{\"lat\":46.7324,\"lon\":-117.0002},\"main\":{\"temp\":272.15,\"pressure\":1020,\"humidity\":86,\"temp_min\":272.15,\"temp_max\":272.15},\"dt\":1513540380,\"wind\":{\"speed\":5.1,\"deg\":100},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}]},{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lat\":55.7507,\"lon\":37.6177},\"main\":{\"temp\":273.9,\"pressure\":1019,\"humidity\":90,\"temp_min\":273.15,\"temp_max\":274.15},\"dt\":1513539000,\"wind\":{\"speed\":3,\"deg\":300},\"sys\":{\"country\":\"RU\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13n\"}]},{\"id\":5211303,\"name\":\"Moscow\",\"coord\":{\"lat\":41.3367,\"lon\":-75.5186},\"main\":{\"temp\":272.64,\"pressure\":1022,\"humidity\":85,\"temp_min\":272.15,\"temp_max\":273.15},\"dt\":1513540440,\"wind\":{\"speed\":1.06,\"deg\":167.501},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}]},{\"id\":4286705,\"name\":\"Moscow\",\"coord\":{\"lat\":38.857,\"lon\":-84.2292},\"main\":{\"temp\":281.15,\"pressure\":1020,\"humidity\":61,\"temp_min\":281.15,\"temp_max\":281.15},\"dt\":1513540380,\"wind\":{\"speed\":2.1,\"deg\":160},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]},{\"id\":5222961,\"name\":\"Moscow\",\"coord\":{\"lat\":41.5229,\"lon\":-71.7415},\"main\":{\"temp\":271.94,\"pressure\":1024,\"humidity\":30,\"temp_min\":271.15,\"temp_max\":273.15},\"dt\":1513540560,\"wind\":{\"speed\":2.1,\"deg\":300},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}]}]}");
        jsonBuilderMock = mock(JsonBuilder.class);
        when(jsonBuilderMock.getRequest(anyString())).thenReturn(jsonObjectMoscow);
        requestParserMoscow = new RequestParser(jsonBuilderMock.getRequest(anyString()));
        assertEquals("-117.0002:46.7324", requestParserMoscow.getCityCoordinates().toString());
    }


    @Test
    public void getTemperatureTallinn() throws Exception {
        JSONObject jsonObjectTallinn = new JSONObject("{\"message\":\"accurate\",\"cod\":\"200\",\"count\":2,\"list\":[{\"id\":590447,\"name\":\"Tallinn\",\"coord\":{\"lat\":59.4372,\"lon\":24.7454},\"main\":{\"temp\":273.15,\"pressure\":1016,\"humidity\":100,\"temp_min\":273.15,\"temp_max\":273.15},\"dt\":1513545600,\"wind\":{\"speed\":2.6,\"deg\":200},\"sys\":{\"country\":\"EE\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}]},{\"id\":715126,\"name\":\"Tallinn\",\"coord\":{\"lat\":47.1836,\"lon\":20.2088},\"main\":{\"temp\":271.05,\"pressure\":1020,\"humidity\":100,\"temp_min\":270.15,\"temp_max\":272.15},\"dt\":1513545300,\"wind\":{\"speed\":3.1,\"deg\":340},\"sys\":{\"country\":\"HU\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":20},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50n\"}]}]}");

        jsonBuilderMock = mock(JsonBuilder.class);
        when(jsonBuilderMock.getRequest(anyString())).thenReturn(jsonObjectTallinn);
        requestParserTallinn = new RequestParser(jsonBuilderMock.getRequest(anyString()));
        assertEquals(0.0, requestParserTallinn.getTemperature());
    }

    @Test
    public void getTemperatureMoscow() throws Exception {
        JSONObject jsonObjectMoscow = new JSONObject("{\"message\":\"accurate\",\"cod\":\"200\",\"count\":5,\"list\":[{\"id\":5807540,\"name\":\"Moscow\",\"coord\":{\"lat\":46.7324,\"lon\":-117.0002},\"main\":{\"temp\":272.71,\"pressure\":1019,\"humidity\":86,\"temp_min\":272.15,\"temp_max\":273.15},\"dt\":1513547580,\"wind\":{\"speed\":5.7,\"deg\":110},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}]},{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lat\":55.7507,\"lon\":37.6177},\"main\":{\"temp\":273.49,\"pressure\":1020,\"humidity\":90,\"temp_min\":273.15,\"temp_max\":274.15},\"dt\":1513546200,\"wind\":{\"speed\":3,\"deg\":290},\"sys\":{\"country\":\"RU\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}]},{\"id\":5211303,\"name\":\"Moscow\",\"coord\":{\"lat\":41.3367,\"lon\":-75.5186},\"main\":{\"temp\":271.64,\"pressure\":1022,\"humidity\":80,\"temp_min\":271.15,\"temp_max\":272.15},\"dt\":1513547640,\"wind\":{\"speed\":1.06,\"deg\":167.501},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}]},{\"id\":4286705,\"name\":\"Moscow\",\"coord\":{\"lat\":38.857,\"lon\":-84.2292},\"main\":{\"temp\":280.47,\"pressure\":1020,\"humidity\":65,\"temp_min\":280.15,\"temp_max\":281.15},\"dt\":1513547580,\"wind\":{\"speed\":2.6,\"deg\":180},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]},{\"id\":5222961,\"name\":\"Moscow\",\"coord\":{\"lat\":41.5229,\"lon\":-71.7415},\"main\":{\"temp\":271.59,\"pressure\":1025,\"humidity\":39,\"temp_min\":271.15,\"temp_max\":272.15},\"dt\":1513547760,\"wind\":{\"speed\":1.5,\"deg\":310},\"sys\":{\"country\":\"US\"},\"rain\":null,\"snow\":null,\"clouds\":{\"all\":1},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}]}]}");
        jsonBuilderMock = mock(JsonBuilder.class);
        when(jsonBuilderMock.getRequest(anyString())).thenReturn(jsonObjectMoscow);
        requestParserMoscow = new RequestParser(jsonBuilderMock.getRequest(anyString()));
        assertEquals(0.0, requestParserMoscow.getTemperature());
    }


}