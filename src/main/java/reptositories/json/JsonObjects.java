package reptositories.json;

import org.json.JSONObject;
import reptositories.connection.ConnectionJson;
import reptositories.coordinatesAndCity.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonObjects {


    public JSONObject getRequest(City city) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new ConnectionJson().getConnectionRequest(city));
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());
    }


    public JSONObject getForecast(City city) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new ConnectionJson().getConnectionForecast(city));
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());
    }


    public JSONObject getRequest(String city) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new ConnectionJson().getConnectionRequest(city));
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());
    }


    public JSONObject getForecast(String city) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new ConnectionJson().getConnectionForecast(city));
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());
    }


}
