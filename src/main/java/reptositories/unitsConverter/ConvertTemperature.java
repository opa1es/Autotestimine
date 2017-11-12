package reptositories.unitsConverter;

public class ConvertTemperature {


    public double CelsiusToKelvin(double temperatureInCelsius){
        return temperatureInCelsius + 273.15;
    }


    public double KelvinToCelsius(double temperatureInKelvins){
        return temperatureInKelvins - 273.15;
    }

}
