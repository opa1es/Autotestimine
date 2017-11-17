package reptositories.requests;


import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonObjects;
import reptositories.readers.WriterToFile;
import reptositories.unitsConverter.ConvertTemperature;

import java.io.IOException;

public class RequestWeather {

    private JsonObjects jsonObjects = new JsonObjects();
    private City city;
    private double temperature;
    private JSONObject forecast;
    private String coordinates;

    public RequestWeather(City city){
        this.city = city;
        try {
            this.getRequestInfo(jsonObjects.getRequest(city));
            this.getForecastInfo(jsonObjects.getForecast(city));
            this.getCityCoordinates(jsonObjects.getRequest(city));
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
    private void getCityCoordinates(JSONObject jsonObject){
        double xxx = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lon");
        double yyy = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("coord").getDouble("lat");
        this.coordinates = xxx + ":" + yyy;
    }



    public String getTemperatureAndWriteItToFileInCelsius(){

        ConvertTemperature convertTemperature = new ConvertTemperature();
        WriterToFile writerToFile = new WriterToFile();
        writerToFile.writeTemperature("temperatures.txt", city.name, temperature);
        return "Temperature in " + city.getName() + " is " + convertTemperature.KelvinToCelsius(getTemperature()) + " C";
    }

    public String getCoords(){
        return this.coordinates;
    }

    public String getTemperatureAndWriteItToFileInKelvin(){


        WriterToFile writerToFile = new WriterToFile();
        writerToFile.writeTemperature("temperatures.txt", city.name, temperature);
        return "Temperature in " + city.getName() + " is " + getTemperature() + " C";
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
