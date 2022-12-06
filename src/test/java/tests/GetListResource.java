package tests;


import com.google.gson.Gson;
import objects.ResourceList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListResource {

    @Test
    public void getListResource(){

        String body = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .extract().body().asString();
        ResourceList resourceList = new Gson().fromJson(body, ResourceList.class);
        String actualPantone_value = resourceList.getData().get(0).getPantone_value();
        String expectedPantone_value = "15-4020";
        Assert.assertEquals(actualPantone_value, expectedPantone_value);

    }

}
