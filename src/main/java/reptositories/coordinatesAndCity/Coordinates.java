package reptositories.coordinatesAndCity;


public class Coordinates {


    private double coordinateX;
    private double coordinateY;


    String getCoordinatesInFormat() {
        return this.coordinateX + ":" + this.coordinateY;
    }


    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }


    public void setCoordinates(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;

    }

}
