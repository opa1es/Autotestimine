package reptositories.requests;


import org.json.JSONArray;
import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonObjects;
import reptositories.unitsConverter.ConvertTemperature;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherRequest {

    private JsonObjects jsonObjects = new JsonObjects();
    private City city;
    private double temperature;
    private JSONArray forecast;

    public WeatherRequest(City city) {
        this.city = city;

        try {
            this.getRequestTemperature(jsonObjects.getRequest(city));
            this.getForecastTemperature(jsonObjects.getForecast(city));
            this.setCityCoordinates(jsonObjects.getRequest(city));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void getForecastTemperature(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list");
    }


    private void getRequestTemperature(JSONObject jsonObject) {
        this.temperature = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
    }

    private void setCityCoordinates(JSONObject jsonObject) {
        double xxx = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lon");
        double yyy = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lat");
        this.city.getCoordinates().setCoordinates(xxx, yyy);
    }

    public String getCityCoordinates() {
        return this.city.getCityCoordinatesAsString();
    }

    public String getTemperatureInCelsius() {

        return new ConvertTemperature().KelvinToCelsius(getTemperature()) + " C";
    }


    public ArrayList<Double> getMinTemperaturesForThreeDays() {
        ArrayList<Double> minimums = new ArrayList<Double>();
        ArrayList<Double> temperatures = getAllMinimumsForNextThreeDays();
        int counter = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            counter++;
            if (counter % 8 == 0) {
                double min = temperatures.get(i);
                for (int n = i - 8 + 1; n < i; n++) {
                    if (temperatures.get(n) < min) {
                        min = temperatures.get(n);
                    }
                }
                minimums.add(min);
            }
        }
        return minimums;
    }

    public ArrayList<Double> getMaxTemperatureForThreeDays() {
        ArrayList<Double> maximums = new ArrayList<Double>();
        ArrayList<Double> temperatures = getAllMaximumsForNextThreeDays();
        int counter = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            counter++;
            if (counter % 8 == 0) {
                double max = temperatures.get(i);
                for (int n = i - 8 + 1; n < i; n++) {
                    if (temperatures.get(n) > max) {
                        max = temperatures.get(n);
                    }
                }
                maximums.add(max);
            }
        }
        return maximums;
    }


    private ArrayList<Double> getAllMinimumsForNextThreeDays() {
        ArrayList<Double> minTemperatures = new ArrayList<Double>();
        for (int i = 0; i < 24; i++) {
            minTemperatures.add(this.forecast.getJSONObject(i).getJSONObject("main").getDouble("temp_min"));
        }
        return minTemperatures;
    }

    private ArrayList<Double> getAllMaximumsForNextThreeDays() {
        ArrayList<Double> maxTemperatures = new ArrayList<Double>();
        for (int i = 0; i < 24; i++) {
            maxTemperatures.add(this.forecast.getJSONObject(i).getJSONObject("main").getDouble("temp_max"));
        }
        return maxTemperatures;
    }


    public String getFullInfo() {
        return null;
    }


    public JsonObjects getJsonObjects() {
        return jsonObjects;
    }

    public City getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public JSONArray getForecast() {
        return forecast;
    }
}
