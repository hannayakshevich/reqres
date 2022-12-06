package tests;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetListUsersTest {

    @Test
    public void getListUsersTest(){
        int userCount = 6;

        given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .body("per_page", equalTo(userCount));
    }
}
