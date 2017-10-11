

public class GetWeather {

    public String city;
    public String code;
    public int cityID;
    public double xCoordinate;
    public double yCoordinate;


    public GetWeather(String city, int cityID, double xCoordinate, double yCoordinate, String code) {
        this.city = city;
        this.cityID = cityID;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.code = code;

    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }







}
