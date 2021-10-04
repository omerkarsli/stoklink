package com.stoklink.API.testCases;

import com.stoklink.API.pojo.Resp;
import com.stoklink.utils.APIUtils;
import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UrunGetir extends BaseAPI {

    /*

    Response
    {
        "status": "OK";
        "data" : [ { Urun1 }, { Urun2 } ]
    }

    */


    @Test
    public void urunGetir(){

        String referans = "0252711555";
        Response response = given().spec(spec).auth().oauth2(auth).basePath("public/urun/getir")
                .queryParam("referans", referans).when().get();


        response.prettyPrint();

        JSONObject responseJson = new JSONObject(response.asString());
        JsonPath responseJsonPath = response.jsonPath();

        responseJson.getJSONArray("data").getJSONObject(0).getString("referans");

        System.out.println(responseJsonPath.get("data[0].referans").toString());


        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(responseJson.getString("status"), "OK");
        Assert.assertEquals(responseJson.getJSONArray("data").toList().size(), 1);

        Assert.assertEquals(responseJson.getJSONArray("data")
                                            .getJSONObject(0)
                                            .getString("referans"), referans);
    }
}
