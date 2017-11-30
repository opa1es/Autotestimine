package reptositories.weatherReports;


import reptositories.requests.WeatherRequest;

import java.util.Scanner;

public class ReportFromConsole {




    public String getFullWeatherInfoByInput() {
        Scanner scanner = new Scanner(System.in);
        String cityName = "";

        while (true) {
            System.out.println("Enter the city name: ");
            if (!scanner.hasNext()) {
                System.out.println("empty...");
            } else if (scanner.hasNext()) {
                cityName = scanner.next();
                break;
            }
        }

        return new WeatherRequest(cityName).getFullWeatherInfo();


    }


}
