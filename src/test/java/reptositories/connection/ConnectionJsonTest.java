package reptositories.connection;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class ConnectionJsonTest {
    @Test
    public void testGetConnectionRequestByCity() throws Exception {

        ConnectionAddress connectionAddress = mock(ConnectionAddress.class);
        when(connectionAddress.buildLinkForRequest("Tallinn")).thenReturn("Tallinn");
        ConnectionJson connectionJson = new ConnectionJson();
        verify(connectionJson.getConnectionRequest(anyString()),atLeast(1));


//        when(connectionAddress.buildLinkForForecast("Narva")).then();




    }



}