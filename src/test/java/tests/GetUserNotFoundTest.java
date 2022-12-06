package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

public class GetUserNotFoundTest {

    @Test
    public void getUserNotFound(){

        Response response = given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().all()
                .extract().response();

        Assert.assertEquals(response.statusCode(), HTTP_NOT_FOUND);
    }
}
