package test.resources;

public class Payload {


    public static String placePostBody(){

        String body = "{\n" +
                "    \"location\":{\n" +
                "        \"lat\" : -38.383494,\n" +
                "        \"lng\" : 33.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\":\"Frontline house\",\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "    \"language\" : \"French-IN\"\n" +
                "}";

        return body;
    }

    public static String placeDeleteBody(String place_id){

        String body = "{"+"\"place_id\": \""+place_id+"\""+"}";

        return body;
    }

    public static String addBook(String isbn, String aisle){

        String body = "{\n" +
                "\n" +
                "\"name\":\"Jagman is the best\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"Chanprit Singh\"\n" +
                "}\n";

        return body;
    }

}
