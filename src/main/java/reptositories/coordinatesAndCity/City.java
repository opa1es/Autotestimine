package reptositories.coordinatesAndCity;

public class City {

    public String city;
    public String code;

    public City(String city, String code) {
        this.city = city;
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



    public static City buildNewCity(String city, String code) throws Exception{
        if(city.length()<1 && code.length() < 1){
            throw new Exception();
        }else{
            return new City(city,code);
        }

    }







}
