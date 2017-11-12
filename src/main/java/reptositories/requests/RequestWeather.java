package reptositories.requests;


import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonObjects;
import reptositories.unitsConverter.ConvertTemperature;

import java.io.IOException;

public class RequestWeather {

    JsonObjects jsonObjects;
    private City city;
    private double temperature;
    private JSONObject forecast;

    public RequestWeather(City city){
        this.city = city;
        try {
            this.getRequestInfo(jsonObjects.getRequest(city));
            this.getForecastInfo(jsonObjects.getForecast(city));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void getForecastInfo(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list").getJSONObject(0);
    }

    private void getRequestInfo(JSONObject jsonObject){
        this.temperature = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
    }


    public static RequestWeather buildNewRequestWeather(City city){
        return new RequestWeather(city);

    }



    public String getTemperatureAndWriteItToFileInCelsius(){

        ConvertTemperature convertTemperature = new ConvertTemperature();
        return "Temperature in " + city.getName() + "is " + convertTemperature.KelvinToCelsius(getTemperature()) + " C";
    }


    public String getTemperatureAndWriteItToFileInKelvin(){

        ConvertTemperature convertTemperature = new ConvertTemperature();
        return "Temperature in " + city.getName() + "is " + getTemperature() + " C";
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

    public JSONObject getForecast() {
        return forecast;
    }
}
