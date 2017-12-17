package reptositories.jsonparser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reptositories.exceptions.NoSuchCityException;

import java.util.ArrayList;

public class ForecastParser {


    private static final int DATA_ELEMENTS_IN_THREE_DAYS = 24;
    private static final int DATA_ELEMENTS_IN_ONE_DAY = 8;
    private JSONArray forecast;

    public ForecastParser(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list");
    }

    private ArrayList<Double> getAllMinimumsForNextThreeDays() {
        ArrayList<Double> minTemperatures = new ArrayList<Double>();
        for (int i = 0; i < DATA_ELEMENTS_IN_THREE_DAYS; i++) {
            try {

                minTemperatures.add(this.forecast.getJSONObject(i).getJSONObject("main").getDouble("temp_min"));

            } catch (JSONException e) {
                throw new NoSuchCityException();
            }
        }
        return minTemperatures;
    }

    private ArrayList<Double> getAllMaximumsForNextThreeDays() {
        ArrayList<Double> maxTemperatures = new ArrayList<Double>();
        for (int i = 0; i < DATA_ELEMENTS_IN_THREE_DAYS; i++) {

            try {
                maxTemperatures.add(this.forecast.getJSONObject(i).getJSONObject("main").getDouble("temp_max"));
            } catch (JSONException e) {
                throw new NoSuchCityException();
            }


        }
        return maxTemperatures;
    }

    public ArrayList<Double> getMinTemperaturesForThreeDays() {
        ArrayList<Double> minimums = new ArrayList<Double>();
        ArrayList<Double> temperatures = getAllMinimumsForNextThreeDays();
        int counter = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            counter++;
            if (counter % DATA_ELEMENTS_IN_ONE_DAY == 0) {
                double min = temperatures.get(i);
                for (int n = i - DATA_ELEMENTS_IN_ONE_DAY + 1; n < i; n++) {
                    if (temperatures.get(n) < min) {
                        min = temperatures.get(n);
                    }
                }
                minimums.add(min);
            }
        }
        return minimums;
    }

    public ArrayList<Double> getMaxTemperaturesForThreeDays() {
        ArrayList<Double> maximums = new ArrayList<Double>();
        ArrayList<Double> temperatures = getAllMaximumsForNextThreeDays();
        int counter = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            counter++;
            if (counter % DATA_ELEMENTS_IN_ONE_DAY == 0) {
                double max = temperatures.get(i);
                for (int n = i - DATA_ELEMENTS_IN_ONE_DAY + 1; n < i; n++) {
                    if (temperatures.get(n) > max) {
                        max = temperatures.get(n);
                    }
                }
                maximums.add(max);
            }
        }
        return maximums;
    }


}
