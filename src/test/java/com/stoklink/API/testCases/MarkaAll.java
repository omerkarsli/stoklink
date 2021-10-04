package com.stoklink.API.testCases;

import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class MarkaAll extends BaseAPI {

    @Test
    public void markaAll(){
        Response response =
                given()
                        .spec(spec)
                        .basePath("public/marka/all")
                        .auth().oauth2(auth)
                    .when()
                        .get();


        response.prettyPrint();

        JSONObject responseJson = new JSONObject(response.asString());


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(responseJson.getString("status"), "OK");
        Assert.assertTrue(responseJson.getJSONArray("data").getJSONObject(0).has("ad"));
    }
}
