package tests;

import objects.User;
import org.testng.annotations.Test;

import java.io.UTFDataFormatException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PatchUpdateUserTest {

    @Test
    public void patchUpdateUser(){
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        given()
                .body(user)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .body("updatedAt", equalTo(get().getTime()));
    }
}
