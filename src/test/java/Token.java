import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Token {

    @Test
    public void tokenGen(){

        RestAssured.baseURI = "https://wework-sandbox.honestbuildings.com";

        Response res = given().header("Content-Type","application/json").body("{\r\n   " +
                "\"client_id\": \"3sA5BenHrsYyTperiu37\",\r\n   " +
                "\"client_secret\": \"Pkqp22d0IuDiGu3tBjxIdE5sUs0tcUDYDBeU0sPQ\n\",\r\n   " +
                "\"grant_type\": \"client_credentials\"\r\n}").when().post("/pub/v1/oauth2/token").then().extract().response();


        System.out.println(res.asString());

    }

}


