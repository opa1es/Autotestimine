package reptositories.coordinatesAndCity;

public class City {

    private String name;
    private String code;
    private Coordinates coordinates = new Coordinates();

    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public City(String name) {
        this.name = name;
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


    public String getCityCoordinatesAsString() {
        return coordinates.getCoordinatesInFormat();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
