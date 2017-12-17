package reptositories.weatherdata;


import reptositories.coordinatesandcity.City;
import reptositories.json.JsonBuilder;
import reptositories.jsonparser.ForecastParser;
import reptositories.unitsconverter.ConvertTemperature;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherForecast extends WeatherRequest {


    private ConvertTemperature convertTemperature = new ConvertTemperature();
    private ForecastParser forecastParser;
    private JsonBuilder jsonBuilder;


    public WeatherForecast(City city) {
        super(city);

        try {
            this.jsonBuilder = new JsonBuilder();
            this.forecastParser = new ForecastParser(jsonBuilder.getForecast(city));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherForecast(String cityName) {
        super(cityName);
        this.jsonBuilder = new JsonBuilder();
        try {
            this.forecastParser = new ForecastParser(jsonBuilder.getForecast(cityName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Double> getMinTemperaturesForThreeDays() {
        return this.forecastParser.getMinTemperaturesForThreeDays();
    }

    public ArrayList<Double> getMaxTemperaturesForThreeDays() {
        return this.forecastParser.getMaxTemperaturesForThreeDays();
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
