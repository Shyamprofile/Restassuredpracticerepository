package petstore;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpointsusingfile {
	
	static ResourceBundle geturl(){
		ResourceBundle routes= ResourceBundle.getBundle("Urls");
		return routes;
	}
	
	public static Response CreateUser(User payload) {
		Response res =given().contentType("application/json").body(payload)
		.when().post(geturl().getString("CreateUser"));
		return res;
		
	}
	public static Response getUser(String username) {
		
		Response res= given().pathParam("username", username)
		.when().get(geturl().getString("GetUser"));
		return res;	
	}
	public static Response deleteUser(String username) {
		
		Response res= given().pathParam("username", username)
		.when().delete(geturl().getString("DeleteUser"));
		return res;	
	}
	public static Response UpdateUser( String username,User payload) {
		Response res =given().pathParam("username", username).contentType("application/json").body(payload)
		.when().put(geturl().getString("UpdateUser"));
		return res;

}
}