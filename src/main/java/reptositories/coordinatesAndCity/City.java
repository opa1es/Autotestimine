package reptositories.coordinatesAndCity;

public class City {

    public String name;
    public String code;

    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public static City buildNewCity(String city, String code){

            return new City(city,code);

    }







}
