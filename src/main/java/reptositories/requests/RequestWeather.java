package reptositories.requests;


import org.json.JSONObject;
import reptositories.coordinatesAndCity.City;
import reptositories.json.JsonObjects;

public class RequestWeather {

    JsonObjects jsonObjects;
    City city;
    private double temperature;
    private JSONObject forecast;

    RequestWeather(City city){
        this.city = city;

    }







    private void getForecastInfo(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list").getJSONObject(0);
    }

    private void getRequestInfo(JSONObject jsonObject){
        this.temperature = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
    }








}
