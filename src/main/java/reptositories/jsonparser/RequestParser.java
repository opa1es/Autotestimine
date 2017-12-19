package reptositories.jsonparser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reptositories.coordinatesandcity.Coordinates;
import reptositories.exceptions.NoSuchCityException;

public class RequestParser {


    private JSONArray current;


    public RequestParser(JSONObject jsonObject) {
        this.current = jsonObject.getJSONArray("list");
    }

    public double getTemperature() {
        double temp;
        try {
            temp = this.current.getJSONObject(0).getJSONObject("main").getDouble("temp");

        } catch (JSONException e) {
            throw new NoSuchCityException();
        }
        return temp;
    }

    public Coordinates getCityCoordinates() {
        double xxx;
        double yyy;
        try {
            xxx = current.getJSONObject(0).getJSONObject("coord").getDouble("lon");
            yyy = current.getJSONObject(0).getJSONObject("coord").getDouble("lat");
        } catch (JSONException e) {
            throw new NoSuchCityException();
        }
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(xxx, yyy);
        return coordinates;
    }


}
