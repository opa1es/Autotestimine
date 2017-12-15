package reptositories.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderFromFile {


    public ArrayList<String> readCityNamesAndReturnArray(String file) throws IOException {
        ArrayList<String> cityNames = new ArrayList<String>();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                cityNames.add(line);
            }

        return cityNames;

    }


}
