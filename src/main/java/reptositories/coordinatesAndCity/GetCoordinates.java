package reptositories.coordinatesAndCity;


public class GetCoordinates {



    //TODO: implement in future

    public double coordinateX;
    public double coordinateY;



    public GetCoordinates(double coordinateX, double coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }


    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateX() {

        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    @Override
    public String toString(){
        return coordinateX+":"+coordinateY;
    }



}
