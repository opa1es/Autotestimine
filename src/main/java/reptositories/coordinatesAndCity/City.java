package reptositories.coordinatesAndCity;

public class City {

    public String name;
    public String code;

    private City(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getCity() {
        return name;
    }

    public void setCity(String city) {
        this.name = city;
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
