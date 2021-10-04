package com.stoklink.API.testCases;

import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TalepAra extends BaseAPI {

    @Test
    public void talepAra(){

        String jsonBody = new JSONObject()
                .put("durum", "")
                .put("baslangicTarihi", "2020-09-18")
                .put("bitisTarihi", "2022-10-15")
                .put("searchText", "")
                .toString();

        Response response = given()
                                .spec(spec)
                                .basePath("talep/ara")
                                .auth()
                                    .oauth2(auth)
                                .contentType("application/json")
                                .body(jsonBody)
                            .when()
                                .post();

        response.prettyPrint();

        JsonPath responseJson = response.jsonPath();

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(responseJson.getString("status"), "OK");
        Assert.assertTrue(responseJson.getList("data").size() != 0);
    }
}
