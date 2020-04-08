package section8;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test.resources.Methods;
import test.resources.Payload;

import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test
    public void postData(){

        baseURI = "http://216.10.245.166";

        Response res = given().header("Content-Type","application/json").body(Payload.addBook("abc", "000")).when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response();


        JsonPath json = Methods.rawToJSON(res);

        System.out.println(json.get("ID"));



    }

    @Test
    public void getData(){

        Response res = given().header("Content-Type","application/json").when().get("/Library/GetBook.php?AuthorName=Chanprit Singh").then().assertThat().statusCode(200).extract().response();


    }




}
