import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;



public class IntegrationApiTest {

    @Test
    public void GetServers() {

        String endpointURL = "https://generator.swagger.io/api/gen/servers";
        Response response = RestAssured.get(endpointURL);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, (int) statusCode);

        String responseContent = response.getBody().asString();
        System.out.println("Response Body: " + responseContent);

    }




    @Test
    public void PostServers() {

        String endpointURL = "http://generator.swagger.io/api/gen/servers/{framework}";
        String framework = "ada-server";
        String requestBody = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"usingFlattenSpec\": true,\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}";


        Response response = RestAssured
                .given()
                .pathParam("framework", framework)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpointURL);


        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, (int) statusCode);


        String responseContent = response.getBody().asString();
        System.out.println("Response Body: " + responseContent);

    }



}
