package tests;

import io.restassured.response.Response;
import lombok.Data;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PutUpdateUserTest {

    @Test
    public void putUpdateUserTest(){
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        given()
                .body(user)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .body("updatedAt", notNullValue());
    }
}
