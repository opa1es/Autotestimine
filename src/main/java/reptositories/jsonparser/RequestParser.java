package reptositories.jsonparser;


import org.json.JSONArray;
import org.json.JSONObject;
import reptositories.coordinatesandcity.Coordinates;

public class RequestParser {


    private JSONArray current;


    public RequestParser(JSONObject jsonObject) {
        this.current = jsonObject.getJSONArray("list");
    }

    public double getTemperature() {
        return this.current.getJSONObject(0).getJSONObject("main").getDouble("temp");
    }

    public Coordinates getCityCoordinates() {
        double xxx = current.getJSONObject(0).getJSONObject("coord").getDouble("lon");
        double yyy = current.getJSONObject(0).getJSONObject("coord").getDouble("lat");
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(xxx, yyy);
        return coordinates;
    }


}
