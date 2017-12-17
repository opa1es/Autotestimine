package reptositories.exceptions;


import org.json.JSONException;

public class NoSuchCityException extends JSONException {

    public NoSuchCityException(){
        super("City does not exists!");
    }



}


