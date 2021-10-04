package com.stoklink.utils.baseUtils;


import com.stoklink.utils.APIUtils;
import org.testng.annotations.BeforeClass;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

	public static RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://api.stoklink.com/api").build();
	public static String auth;

// Method to generate authorization token

	@BeforeClass
	public void setup() {

		auth = APIUtils.getAuthToken("musteri@stoklink.com", "12345", true);


	}
}
