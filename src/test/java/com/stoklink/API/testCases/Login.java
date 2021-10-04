package com.stoklink.API.testCases;
import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Login extends BaseAPI{

    @Test
    public void loginAPI(){

        String body = new JSONObject()
                .put("username", "zkarsli61@gmail.com")
                .put("password", "12345")
                .put("rememberMe", true).toString();


        Response response = given()
                .spec(spec)
                .basePath("auth/login")
                .contentType("application/json")
                .body(body)
            .when()
                .post();


        JsonPath responseJson = response.jsonPath();
        String token = responseJson.getMap("data").get("token").toString();

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(responseJson.getString("status"), "OK");
        Assert.assertTrue((token != null) && !(token.isEmpty()));
    }
}
