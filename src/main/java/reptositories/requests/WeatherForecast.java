package reptositories.requests;


import org.json.JSONArray;
import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonBuilder;
import reptositories.unitsConverter.ConvertTemperature;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherForecast extends WeatherRequest {


    private JSONArray forecast;
    private ConvertTemperature convertTemperature = new ConvertTemperature();
    private JsonBuilder jsonBuilder = new JsonBuilder();


    public WeatherForecast(City city) {
        super(city);

        try {

            this.setForecast(jsonBuilder.getForecast(city));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherForecast(String cityName) {
        super(cityName);
        try {
            this.setForecast(jsonBuilder.getForecast(cityName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setForecast(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list");
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

    @Override
    public String toString() {
        String output = "";
        output += "Temperature minimums / maximums for next three days: \n";
        output += "1: " + getMinTemperaturesForThreeDaysInCelsius().get(0) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(0) + "( °C)" + "\n";
        output += "2: " + getMinTemperaturesForThreeDaysInCelsius().get(1) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(1) + "( °C)" + "\n";
        output += "3: " + getMinTemperaturesForThreeDaysInCelsius().get(2) + " / "
                + getMaxTemperaturesForThreeDaysInCelsius().get(2) + "( °C)" + "\n";

        return output;

    }


}
