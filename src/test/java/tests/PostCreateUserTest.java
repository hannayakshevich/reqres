package tests;

import io.restassured.response.Response;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_CREATED;

public class PostCreateUserTest {

    @Test
    public void postCreateUserTest(){
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();

        Response response = given()
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_CREATED);
    }
}
