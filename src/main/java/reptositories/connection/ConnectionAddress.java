package reptositories.connection;

import reptositories.coordinatesAndCity.City;


class ConnectionAddress {

    private  final String URL_REQUEST = "http://api.openweathermap.org/data/2.5/find?q=";
    private  final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private  final String KEY = "1fd8292118ee92959ac8793f9b0d9c1c";

    String buildLinkForRequest(City city) {
        System.out.println(URL_REQUEST + city.getName() + "," + city.getCode() + "&APPID=" + KEY);
        return URL_REQUEST + city.getName() + "," + city.getCode() + "&APPID=" + KEY;
    }


     String buildLinkForForecast(City city) {
        return URL_FORECAST + city.getName() + "," + city.getCode() + "&APPID=" + KEY;
    }


     String buildLinkForRequest(String city) {
        return URL_REQUEST + city + "&APPID=" + KEY;
    }

     String buildLinkForForecast(String city) {
        return URL_FORECAST + city + "&APPID=" + KEY;
    }


}
