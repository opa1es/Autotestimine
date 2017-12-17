package reptositories.weatherdata;


import reptositories.coordinatesandcity.City;
import reptositories.json.JsonBuilder;
import reptositories.jsonparser.RequestParser;
import reptositories.unitsconverter.ConvertTemperature;

import java.io.IOException;

public class WeatherRequest {


    private City city;
    private double temperature;
    private RequestParser requestParser;
    private JsonBuilder jsonBuilder;

    public WeatherRequest(City city) {
        this.city = city;
        this.jsonBuilder = new JsonBuilder();
        try {
            this.requestParser = new RequestParser(jsonBuilder.getRequest(city));
            this.setCityCoordinates();
            this.setCurrentTemperature();
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherRequest(String cityName) {
        this.city = new City(cityName);
        this.jsonBuilder = new JsonBuilder();
        try {
            this.requestParser = new RequestParser(jsonBuilder.getRequest(cityName));
            this.setCityCoordinates();
            this.setCurrentTemperature();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setCityCoordinates() {
        this.city.setCoordinates(requestParser.getCityCoordinates());
    }

    private void setCurrentTemperature() {
        this.temperature = this.requestParser.getTemperature();

    }


    public String getCityCoordinatesAsString() {
        return this.city.getCoordinates().toString();
    }

    public String getCurrentTemperatureInCelsius() {

        return new ConvertTemperature().kelvinToCelsius(getTemperature()) + " C";
    }

    public City getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }


    @Override
    public String toString() {
        String output = "";
        output += getCity().getName() + " | Coordinates: " + getCityCoordinatesAsString() + "\n";
        output += "Current temperature: " + getCurrentTemperatureInCelsius() + "\n";
        return output;


    }
}
