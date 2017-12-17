package reptositories.weatherreports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reptositories.consolereader.ConsoleReader;

import static org.mockito.Mockito.*;


class ReportFromConsoleTest {
    private ConsoleReader consoleReader;
    private ReportFromConsole reportFromConsole;

    @BeforeEach
    void setup() {
        consoleReader = mock(ConsoleReader.class);
        reportFromConsole = new ReportFromConsole();


    }


    @Test
    void testIfConsoleReaderWasCalled() {

        when(consoleReader.readAndReturnCity()).thenReturn("Tallinn");
        reportFromConsole.getFullWeatherInfoByInput(consoleReader);
        verify(consoleReader, atLeast(1)).readAndReturnCity();
    }



    @Test
    void testIfConsoleReaderWasCalled1() {

        when(consoleReader.readAndReturnCity()).thenReturn("CityName");
        try{
            reportFromConsole.getFullWeatherInfoByInput(consoleReader);
        }catch (org.json.JSONException ignore){
        }
        verify(consoleReader, atLeast(1)).readAndReturnCity();
    }




}