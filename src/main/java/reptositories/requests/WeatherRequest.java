package reptositories.requests;


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
    private JSONObject forecast;




    public WeatherRequest(City city){
        this.city = city;


        try {
            this.getRequestTemperature(jsonObjects.getRequest(city));
            this.getForecastTemperature(jsonObjects.getForecast(city));
            this.setCityCoordinates(jsonObjects.getRequest(city));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void getForecastTemperature(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list").getJSONObject(0);
    }

    private void getRequestTemperature(JSONObject jsonObject){
        this.temperature = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
    }

    private void setCityCoordinates(JSONObject jsonObject){
        double xxx = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lon");
        double yyy = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lat");
        this.city.setCoordinates(xxx,yyy);
        }

    public String getCityCoordinates(){
        return this.city.getCityCoordinatesAsString();
    }

    public String getTemperatureInCelsius(){

        return new ConvertTemperature().KelvinToCelsius(getTemperature()) + " C";
    }

    public ArrayList<Double> minTemperatureForThreeDays(){
        return null;
    }


    public ArrayList<Double> maxTemperatureForThreeDays(){
        return null;
    }






    public String getFullInfo(){




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

    public JSONObject getForecast() {
        return forecast;
    }
}
