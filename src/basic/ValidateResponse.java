package basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://restcountries-v1.p.rapidapi.com";
		RestAssured.basePath = "/name";
	}
	
	@Test()
	public void printResponse() {
		Response res =
		given()
			.header("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com")
			.header("X-RapidAPI-Key", "47d3e1ebe6msh876aeb3cb1fb5bcp1bc94cjsn392bd45ffb8d")
		.when()
			.get("/brazil");
		
		System.out.println(res.body().prettyPrint());
	}
	

	@Test()
	public void responseVerification() {
		given()
			.header("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com")
			.header("X-RapidAPI-Key", "47d3e1ebe6msh876aeb3cb1fb5bcp1bc94cjsn392bd45ffb8d")
		.when()
			.get("/brazil")
		.then()
			.statusCode(200)
			.body("[0].capital", equalTo("Brasília"))
			.body("[0].region", equalTo("Americas"))
			.body("[0].subregion", equalTo("South America"))
			.body("[0].population", equalTo(204772000))
			.body("[0].area", equalTo(8515767.0f))
			.contentType(ContentType.JSON);
	}

}
