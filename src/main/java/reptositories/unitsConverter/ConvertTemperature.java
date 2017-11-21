package reptositories.unitsConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ConvertTemperature {


    public double celsiusToKelvin(double temperatureInCelsius) {
        return temperatureInCelsius + 273.15;
    }


    public double kelvinToCelsius(double temperatureInKelvins) {
        return new BigDecimal(temperatureInKelvins - 273.15).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }


    public ArrayList<Double> convertListKelvinToCelsius(ArrayList<Double> temperaturesToConvert) {
        ArrayList<Double> outputTemperatures = new ArrayList<Double>();
        for (Double temperature : temperaturesToConvert) {
            outputTemperatures.add(kelvinToCelsius(temperature));
        }
        return outputTemperatures;

    }


}
