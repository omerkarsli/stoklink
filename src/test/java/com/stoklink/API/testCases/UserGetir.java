package com.stoklink.API.testCases;

import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class UserGetir extends BaseAPI {

    @Test
    public void userGetir(){



        Response response = given()
                                .spec(spec)
                                .basePath("user/getir")
                                .auth().oauth2(auth)
                             .when()
                                 .get();

        response.prettyPrint();
         JsonPath responseJson = response.jsonPath();
         Assert.assertEquals(response.statusCode(), 200);
         Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
         Assert.assertEquals(responseJson.getString("status"), "OK");
 }
}
