package Library;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;

public class AddUser {
	
	// Post Request
	
	@Test (priority = 1)
	public void AddPlace()
	{
		given()
		.contentType("application/json")
		.body("{\r\n"
				+ "    \"name\" : \"Boss\",\r\n"
				+ "    \"role\" : \"Sm\"\r\n"
				+ "}")
		.log().all()
		.when()
			.post("http://localhost:3000/posts/")
		.then()	
			.log().all();  
	}
}
