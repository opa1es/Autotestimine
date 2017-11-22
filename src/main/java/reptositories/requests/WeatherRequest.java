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
    private JSONArray current;
    private ConvertTemperature convertTemperature = new ConvertTemperature();

    public WeatherRequest(City city) {
        this.city = city;

        try {
            this.setRequest(jsonObjects.getRequest(city));
            this.setForecast(jsonObjects.getForecast(city));
            this.setCityCoordinates(jsonObjects.getRequest(city));
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherRequest(String cityName) {
        this.city = new City(cityName);

        try {
            this.setRequest(jsonObjects.getRequest(cityName));
            this.setForecast(jsonObjects.getForecast(cityName));
            this.setCityCoordinates(jsonObjects.getRequest(cityName));
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setForecast(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list");
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


    public String getCityCoordinatesAsString() {
        return this.city.getCityCoordinatesAsString();
    }

    public String getCurrentTemperatureInCelsius() {

        return new ConvertTemperature().kelvinToCelsius(getTemperature()) + " C";
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

    public ArrayList<Double> getMaxTemperaturesForThreeDays() {
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


    public ArrayList<Double> getMaxTemperaturesForThreeDaysInCelsius() {
        return convertTemperature.convertListKelvinToCelsius(getMaxTemperaturesForThreeDays());
    }

    public ArrayList<Double> getMinTemperaturesForThreeDaysInCelsius() {
        return convertTemperature.convertListKelvinToCelsius(getMinTemperaturesForThreeDays());
    }


    public String getFullWeatherInfo() {
        String output = "";
        output += getCity().getName() + " | Coordinates: " + getCityCoordinatesAsString() + "\n";
        output += "Current temperature: " + getCurrentTemperatureInCelsius() + "\n";
        output += "Temperature minimums / maximums for next three days: \n";
        output += "1: " + getMinTemperaturesForThreeDaysInCelsius().get(0) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(0) + "( °C)" + "\n";
        output += "2: " + getMinTemperaturesForThreeDaysInCelsius().get(1) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(1) + "( °C)" + "\n";
        output += "3: " + getMinTemperaturesForThreeDaysInCelsius().get(2) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(2) + "( °C)" + "\n";

        return output;
    }

    public String getCurrentWeatherInfo() {
        String output = "";
        output += getCity().getName() + " | Coordinates: " + getCityCoordinatesAsString() + "\n";
        output += "Current temperature: " + getCurrentTemperatureInCelsius() + "\n";
        return output;


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

    public JSONArray getCurrent() {
        return current;
    }

}
