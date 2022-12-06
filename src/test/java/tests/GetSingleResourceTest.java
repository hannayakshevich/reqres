package tests;

import com.google.gson.Gson;
import objects.ResourceList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleResourceTest {

    @Test
    public void getSingleResourceTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().all()
                .extract().body().asString();
        ResourceList resourceList = new Gson().fromJson(body, ResourceList.class);
        int actualArraySize = resourceList.getData().size();
        int expectedArraySize = 1;
        Assert.assertEquals(actualArraySize, expectedArraySize);
    }
}
