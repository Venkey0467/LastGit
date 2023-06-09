package Library6;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUser {
	 
	public static int id;
	
	// Post Request
	
	@Test (priority = 1)
	public static void CreateUser()
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
	
	@Test (priority = 2)
	public static void GetUser()
	{
		given()
			.pathParam("key" , id)
		.when()
			.get("http://localhost:3000/posts/{key}")
		.then()	
			.log().all();
	}
	
	// Put Request
	
	@Test (priority = 3)
	public void UpdateUser()
	{
		given()
			.contentType("application/json")
			.body("{\r\n"
				+ "    \"name\" : \"Boss1\",\r\n"
				+ "    \"role\" : \"Sm1\"\r\n"
				+ "}")
			.pathParam("key" , id)
			.log().all()
		.when()
			.put("http://localhost:3000/posts/{key}")
		.then()	
			.log().all();
	}
	
	// Delete Request
	
	@Test (priority = 4)
	public static void DeleteUser()
	{
		given()
			.pathParam("key" , id)
		.when()
			.delete("http://localhost:3000/posts/{key}")
		.then()	
			.log().all();
	}
}
