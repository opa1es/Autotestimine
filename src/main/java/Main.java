import reptositories.coordinatesAndCity.City;
import reptositories.requests.RequestWeather;

public class Main {

    public static void main(String[] args) {
        City cityTallinn = new City("Tallinn","EE");

        RequestWeather requestWeather = new RequestWeather(cityTallinn);


        System.out.println(requestWeather.getTemperatureAndWriteItToFileInCelsius());

    }


}
