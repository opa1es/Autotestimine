package reptositories.connection;

import reptositories.coordinatesAndCity.City;


class ConnectTo {

    private static final String URL_REQUEST = "http://api.openweathermap.org/data/2.5/find?q=";
    private static final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String KEY = "1fd8292118ee92959ac8793f9b0d9c1c";

    static String buildLinkForRequest(City city) {
        return URL_REQUEST + city.getName() + "," + city.getCode() + "&APPID=" + KEY;
    }


    static String buildLinkForForecast(City city) {
        return URL_FORECAST + city.getName() + "," + city.getCode() + "&APPID=" + KEY;
    }


    static String buildLinkForRequest(String city) {
        return URL_REQUEST + city + "&APPID=" + KEY;
    }

    static String buildLinkForForecast(String city) {
        return URL_FORECAST + city + "&APPID=" + KEY;
    }


}
