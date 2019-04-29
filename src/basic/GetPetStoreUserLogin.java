package basic;

import static org.testng.Assert.assertEquals;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;

public class GetPetStoreUserLogin {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		RestAssured.basePath = "/user/login";
	}

	@Test()
	public void responseVerification() {
		given()
			.param("username", "fabioalves")
			.param("password", "abc123")			
		.when()
			.get()
		.then()
			.statusCode(200)
			.and()
			.body(containsString("logged in user"));
	}

}
