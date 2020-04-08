package test.resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Methods {

    public static JsonPath rawToJSON(Response r){

        // grab the entire body as String
        String response = r.asString();

        //convert the string/raw body into Json
        JsonPath json = new JsonPath(response);

        return json;
    }


}
