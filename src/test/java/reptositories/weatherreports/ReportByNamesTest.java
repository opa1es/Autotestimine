package reptositories.weatherreports;

import org.junit.Test;
import reptositories.exceptions.NoSuchCityException;
import reptositories.readers.ReaderFromFile;
import reptositories.readers.WriterToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ReportByNamesTest {


    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionIfCityDoesNotExists1() throws IOException {
        ReaderFromFile fileReader = mock(ReaderFromFile.class);
        WriterToFile writerToFile = mock(WriterToFile.class);
        when(fileReader.readCityNamesAndReturnArray(anyString())).thenReturn(new ArrayList<String>(Arrays.asList("someName", "AnotherCity", "somethingElse")));

        ReportByNames reportByNames = new ReportByNames();
        reportByNames.getFullWeatherReportAndWriteToFile(fileReader, writerToFile, "outputTest.txt");
        verify(fileReader).readCityNamesAndReturnArray("aaa");

    }

    @Test(expected = NoSuchCityException.class)
    public void testThrowExceptionIfCityDoesNotExists2() throws IOException {
        ReaderFromFile fileReader = mock(ReaderFromFile.class);
        WriterToFile writerToFile = mock(WriterToFile.class);
        when(fileReader.readCityNamesAndReturnArray(anyString())).thenReturn(new ArrayList<String>(Arrays.asList("NotExistingCity")));

        ReportByNames reportByNames = new ReportByNames();
        reportByNames.getFullWeatherReportAndWriteToFile(fileReader, writerToFile, "outputTest.txt");
        verify(fileReader).readCityNamesAndReturnArray("aaa");

    }

    @Test
    public void testReaderAndWriterAreCalledIfCityIsCorrect1() throws IOException {
        ReaderFromFile fileReader = mock(ReaderFromFile.class);
        WriterToFile writerToFile = mock(WriterToFile.class);
        when(fileReader.readCityNamesAndReturnArray(anyString())).thenReturn(new ArrayList<String>(Arrays.asList("Tallinn")));

        ReportByNames reportByNames = new ReportByNames();
        reportByNames.getFullWeatherReportAndWriteToFile(fileReader, writerToFile, "outputTest.txt");
        verify(fileReader).readCityNamesAndReturnArray(anyString());
        verify(writerToFile).writeToFile(anyString(),anyString());

    }

    @Test
    public void testReaderAndWriterAreCalledIfCityIsCorrect2() throws IOException {
        ReaderFromFile fileReader = mock(ReaderFromFile.class);
        WriterToFile writerToFile = mock(WriterToFile.class);
        when(fileReader.readCityNamesAndReturnArray(anyString())).thenReturn(new ArrayList<String>(Arrays.asList("Narva","Tartu","Moscow")));

        ReportByNames reportByNames = new ReportByNames();
        reportByNames.getFullWeatherReportAndWriteToFile(fileReader, writerToFile, "outputTest.txt");
        verify(fileReader).readCityNamesAndReturnArray(anyString());
        verify(writerToFile).writeToFile(anyString(),anyString());

    }


}