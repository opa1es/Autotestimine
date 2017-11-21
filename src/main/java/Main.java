import reptositories.coordinatesAndCity.City;
import reptositories.requests.WeatherRequest;
import reptositories.weatherReports.ReportByNames;

public class Main {

    public static void main(String[] args) {
        City cityTallinn = new City("Tallinn","EE");

        WeatherRequest requestWeather = new WeatherRequest("Tallinn");
        ReportByNames reportByNames = new ReportByNames();
//        WeatherRequestByName weatherRequestByName = new WeatherRequestByName("Tallinn");
        //System.out.println(requestWeather.getAllMaximumsForFourDays());
        //System.out.println(requestWeather.getMaxTemperatureForThreeDays());
        //System.out.println(requestWeather.getMinTemperaturesForThreeDays());
        //System.out.println(requestWeather.getMaxTempForForFourDays());
        //System.out.println(requestWeather.getMinTemp4());
//        System.out.println(requestWeather.getTemperatureInCelsius());
//        System.out.println(requestWeather.getCurrentMinimum());
//        System.out.println(requestWeather.getForecastMinimums());

//        System.out.println(requestWeather.getMaxTemperaturesForThreeDays());
        //System.out.println(requestWeather.getMaxTemperaturesForThreeDaysInCelsius());
        //System.out.println(requestWeather.getFullInfo());
//        System.out.println(requestWeather.getFullInfo());
        System.out.println(reportByNames.getFullWeatherReportAndWriteToFile());
    }


}
