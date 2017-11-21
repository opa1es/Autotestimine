package reptositories.connection;


import reptositories.coordinatesAndCity.City;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static reptositories.connection.ConnectTo.buildLinkForForecast;
import static reptositories.connection.ConnectTo.buildLinkForRequest;

public class ConnectionJson {

    public static InputStream getConnectionRequest(City city) throws IOException {
        URLConnection connection = new URL(buildLinkForRequest(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }


    public static InputStream getConnectionForecast(City city) throws IOException {
        URLConnection connection = new URL(buildLinkForForecast(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }

    public static InputStream getConnectionRequest(String  city) throws IOException {
        URLConnection connection = new URL(buildLinkForRequest(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }


    public static InputStream getConnectionForecast(String  city) throws IOException {
        URLConnection connection = new URL(buildLinkForForecast(city)).openConnection();
        connection.connect();
        return connection.getInputStream();
    }

}
