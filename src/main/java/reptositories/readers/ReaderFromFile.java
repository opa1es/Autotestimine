package reptositories.readers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderFromFile {


    public ArrayList<String> cityNames = new ArrayList<String>();

    public void readCityNames() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("linnanimid.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                cityNames.add(line);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
