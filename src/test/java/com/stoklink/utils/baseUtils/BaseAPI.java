package com.stoklink.utils.baseUtils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import com.stoklink.API.pojo.Resp;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

	public RequestSpecification spec;
	public String auth;
	public Response response;
	public Resp resp;

// Method to generate authorization token

	@BeforeClass
	public void setup() {

		spec = new RequestSpecBuilder().setBaseUri("https://api.stoklink.com/api/").build();

		/*
		 * Request body : {"username": "username", "password": "password", "rememberMe":
		 * true}
		 */

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("username", "musteri@stoklink.com");
		body.put("password", "12345");
		body.put("rememberMe", true);

		// Sending post request to the server

		/*
		 * Response body:
		 *
		 * { "status":"OK", "data": { "token" : "generate token" }}
		 */

		response = given().spec(spec).basePath("auth/login").contentType("application/json").body(body).when().post();

		JSONObject json = new JSONObject(response.asString());

		auth = "Bearer " + json.getJSONObject("data").getString("token");

	}
}
