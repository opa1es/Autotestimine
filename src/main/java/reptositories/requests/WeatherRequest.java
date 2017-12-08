package reptositories.requests;


import org.json.JSONArray;
import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonBuilder;
import reptositories.unitsConverter.ConvertTemperature;

import java.io.IOException;

public class WeatherRequest {

    private JsonBuilder jsonBuilder = new JsonBuilder();
    private City city;
    private double temperature;

    private JSONArray current;

    public WeatherRequest(City city) {
        this.city = city;

        try {
            this.setRequest(jsonBuilder.getRequest(city));
            this.setCityCoordinates(jsonBuilder.getRequest(city));
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherRequest(String cityName) {
        this.city = new City(cityName);

        try {
            this.setRequest(jsonBuilder.getRequest(cityName));
            this.setCityCoordinates(jsonBuilder.getRequest(cityName));
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setRequest(JSONObject jsonObject) {
        this.current = jsonObject.getJSONArray("list");
    }

    private void setCityCoordinates(JSONObject jsonObject) {
        double xxx = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lon");
        double yyy = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lat");
        this.city.getCoordinates().setCoordinates(xxx, yyy);
    }

    private void setCurrentTemperature() {
        this.temperature = this.current.getJSONObject(0).getJSONObject("main").getDouble("temp");


    }


    public String getCityCoordinatesAsString() {
        return this.city.getCityCoordinatesAsString();
    }

    public String getCurrentTemperatureInCelsius() {

        return new ConvertTemperature().kelvinToCelsius(getTemperature()) + " C";
    }


    public JsonBuilder getJsonBuilder() {
        return jsonBuilder;
    }

    public City getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }


    public JSONArray getCurrent() {
        return current;
    }


    @Override
    public String toString() {
        String output = "";
        output += getCity().getName() + " | Coordinates: " + getCityCoordinatesAsString() + "\n";
        output += "Current temperature: " + getCurrentTemperatureInCelsius() + "\n";
        return output;


    }
}
