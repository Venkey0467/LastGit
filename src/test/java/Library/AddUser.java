package Library;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddUser {
	 
	int id;
	
	// Post Request
	
	@Test (priority = 1)
	public void CreateUser()
	{
		Response res = given()
		.contentType("application/json")
		.body("{\r\n"
				+ "    \"name\" : \"Boss\",\r\n"
				+ "    \"role\" : \"Sm\"\r\n"
				+ "}")
		.log().all()
		.when()
			.post("http://localhost:3000/posts/")
		.then()	
			.log().all()
			.extract().response();
		JsonPath jp = new JsonPath(res.asString());
		id = jp.get("id");
	}
	
	// Get Request
	
	@Test (priority = 1)
	public void GetUser()
	{
		given()
			.pathParam("key" , id)
		.when()
			.get("http://localhost:3000/posts/{key}")
		.then()	
			.log().all();
	}
}
