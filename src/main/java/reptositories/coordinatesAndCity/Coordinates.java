package reptositories.coordinatesAndCity;


public class Coordinates {


    double coordinateX;
    double coordinateY;

    public Coordinates(){}

    public Coordinates(double coordinateX, double coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }




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
