package com.stoklink.utils;

import com.stoklink.API.pojo.Kaydet;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static com.stoklink.utils.baseUtils.BaseAPI.*;

public class APIUtils {

    public static String getAuthToken(String username, String password, Boolean rememberMe){
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://api.stoklink.com/api/").build();

        // request body for login API

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("username", username);
        body.put("password", password);
        body.put("rememberMe", rememberMe);

        // Sending post request to the server

        /*
         * Response body:
         *
         * { "status":"OK", "data": { "token" : "generate token" }}
         */

        Response response =
                    given()
                        .spec(spec)
                        .basePath("auth/login")
                        .contentType("application/json")
                        .body(body)
                    .when().post();

        JSONObject json = new JSONObject(response.asString());

        String auth = json.getJSONObject("data").getString("token");

        return auth;
    }

    public static Response talepAra(String baslangicTarihi, String bitisTarihi, String durum, String searchText){
    JSONObject json =
            new JSONObject()
                .put("durum", durum)
                .put("searchText", searchText)
                .put("baslangicTarihi", baslangicTarihi)
                .put("bitisTarihi", bitisTarihi);

    Response response =
            given()
                .spec(spec)
                .contentType("application/json")
                .body(json)
                .auth().oauth2(auth)
                .basePath("talep/ara")
            .when()
                .post();

    return response;

    }









    public static Response talepOlustur(Kaydet kaydet){

        /*
            Request Body :

                {"durum" : -1,
                "gecerlilikTarihi" : "2021-10-04T13:00:00.000Z",
                "talepItemList":[ { "urunIsim":"urunIsim",
                                    "marka":{"ad":"Harting"},
                                    "muadil":false,
                                    "stok":false,
                                    "miktar":"5",
                                    "birim":"adet",
                                    "aciklama":"",
                                    "durum":"",
                                    "urun": {
                                            "referans":"02 05 000 1511",
                                            "birim" : "adet"
                                            }}
                                ]}

         */

        Response response =
                given()
                        .spec(spec)
                        .auth().oauth2(auth)
                        .basePath("talep/kaydet")
                        .contentType("application/json")
                        .body(kaydet)
                        .when().post();

        return response;
    }




}
