package reptositories.connection;


import reptositories.coordinatesAndCity.City;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionJson {


    ConnectionAddress connectTo;


    public ConnectionJson(){
        connectTo = new ConnectionAddress();
    }


    public InputStream getConnectionRequest(City city) throws IOException {
        URLConnection connection = new URL(connectTo.buildLinkForRequest(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }


    public InputStream getConnectionForecast(City city) throws IOException {
        URLConnection connection = new URL(connectTo.buildLinkForForecast(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }

    public InputStream getConnectionRequest(String city) throws IOException {
        URLConnection connection = new URL(connectTo.buildLinkForRequest(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }


    public InputStream getConnectionForecast(String city) throws IOException {
        URLConnection connection = new URL(connectTo.buildLinkForForecast(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }

}
