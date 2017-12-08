import reptositories.coordinatesAndCity.City;
import reptositories.requests.WeatherRequest;
import reptositories.weatherReports.ReportByNames;
import reptositories.weatherReports.ReportFromConsole;

public class Main {

    public static void main(String[] args) {
        City cityTallinn = new City("Tallinn","EE");

        WeatherRequest requestWeather = new WeatherRequest("Tallinn");
        ReportByNames reportByNames = new ReportByNames();
        ReportFromConsole reportFromConsole = new ReportFromConsole();


        System.out.println(reportByNames.getFullWeatherReportAndWriteToFile());




//        System.out.println(requestWeather.getMaxTemperaturesForThreeDays());
        //System.out.println(requestWeather.getMaxTemperaturesForThreeDaysInCelsius());
        //System.out.println(requestWeather.getFullInfo());
//        System.out.println(requestWeather.getFullInfo());
//        System.out.println(reportByNames.getFullWeatherReportAndWriteToFile());
    }


}
