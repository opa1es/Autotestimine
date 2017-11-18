package reptositories.coordinatesAndCity;


public class Coordinates {


    double coordinateX;
    double coordinateY;

    public Coordinates(){}


    String getCoordinatesInFormat(){
        return this.coordinateX + ":" + this.coordinateY;
    }


    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }


}
