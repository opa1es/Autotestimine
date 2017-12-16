package reptositories.readers;


import org.junit.Test;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WriterMockingTest {
    @Test
    public void testFileWriterWrites() {
        WriterToFile writerMock = mock(WriterToFile.class);

        File reportFile = new File("name1");

        writerMock.writeToFile("report", reportFile.getName());

        verify(writerMock, times(1)).writeToFile(anyString(), anyString());
    }

    @Test

    public void testFileWriterWrites1() {
        WriterToFile writerMock = mock(WriterToFile.class);

        File reportFile = new File("name1");

        writerMock.writeToFile("reportolololo", reportFile.getName());

        verify(writerMock, times(1)).writeToFile(anyString(), anyString());
    }


}
