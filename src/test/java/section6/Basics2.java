package section6;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.resources.Methods;
import test.resources.Payload;
import test.resources.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.Matchers.*;

public class Basics2 {

    // we must declare the prop object in globe scope so we can use it in other methods
    Properties prop = new Properties();

    // whatever code is written in @BeforeTest method gets executed before the @Test notations
    @BeforeTest
    public void getData() throws IOException {


        FileInputStream fileInputStream = new FileInputStream("/Users/japmandeep.dhaliwalwework.com/git/RestAssured/src/files/env.properties");

        prop.load(fileInputStream);


    }

    @Test
    public void postRequest(){

        System.out.println("Host " + prop.getProperty("HOST"));

        RestAssured.baseURI = prop.getProperty("HOST");

        Response res = given().
                queryParam("key", prop.getProperty("key")).
                body(Payload.placePostBody()).
                when().
                post(Resource.placePost()).
                then().
                assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).and().body("status", equalTo("OK")).extract().response();








        JsonPath json = Methods.rawToJSON(res);

        String place_id = json.get("place_id");

        System.out.println("Place id: " + place_id);

        // place this place_id into the body of the delete request so we are able to delete this record.
        //  /maps/api/place/delete/json - delete resource --- takes key as parm

       Response res1 = given().
                            queryParam("key",prop.getProperty("key")).
                            body(Payload.placeDeleteBody(place_id)).
                    when().
                            delete(Resource.placeDelete()).
                    then().
                            assertThat().statusCode(200).and().
                            extract().
                            response();

        System.out.println("response from delete " + res1.asString());



    }



}

