package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;

public class DeleteUserTest {

    @Test
    public void deleteUserTest(){
        given()
                .when()
                .log().all()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(HTTP_NO_CONTENT);
    }
}
