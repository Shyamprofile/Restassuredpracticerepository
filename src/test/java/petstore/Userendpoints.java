package petstore;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpoints {
	
	public static Response CreateUser(User payload) {
		
		Response res =given().contentType("application/json").body(payload)
		.when().post(Routes.CreateUser);
		return res;
		
	}
	public static Response getUser(String username) {
		
		Response res= given().pathParam("username", username)
		.when().get(Routes.GetUser);
		return res;	
	}
	public static Response deleteUser(String username) {
		
		Response res= given().pathParam("username", username)
		.when().delete(Routes.DeleteUser);
		return res;	
	}
	public static Response UpdateUser( String username,User payload) {
		Response res =given().pathParam("username", username).contentType("application/json").body(payload)
		.when().put(Routes.UpdateUser);
		return res;

}
}