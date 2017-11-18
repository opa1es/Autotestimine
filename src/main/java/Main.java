import reptositories.coordinatesAndCity.City;
import reptositories.requests.WeatherRequest;

public class Main {

    public static void main(String[] args) {
        City cityTallinn = new City("Tallinn","EE");

        WeatherRequest requestWeather = new WeatherRequest(cityTallinn);

        //System.out.println(requestWeather.getAllMaximumsForFourDays());
        System.out.println(requestWeather.getMaxTemperatureForThreeDays());
        System.out.println(requestWeather.getMinTemperaturesForThreeDays());
        //System.out.println(requestWeather.getMaxTempForForFourDays());
        //System.out.println(requestWeather.getMinTemp4());

    }


}
