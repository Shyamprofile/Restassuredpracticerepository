package petstore;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateUser {
	User userpayload= new User();
	Faker faker = new Faker ();
	
	@BeforeTest
// generates random data	
	public void createstestuser() {		
		userpayload.setId(faker.hashCode());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUsername(faker.name().username());
		userpayload.setUserStatus(faker.hashCode());				
	}
// Create user	
  @Test	(priority=1) 
  public void createUser() {
	  Response res = Userendpoints.CreateUser(userpayload);
	  System.out.println(this.userpayload.getUsername());
	  res.then().log().body();
  }
 //Retreive user
 @Test	(priority=2)
  public void getUser() {
	  Response res = Userendpoints.getUser(this.userpayload.getUsername());
	  res.then().log().body();
 }
 //Update user
 @Test	(priority=3)
 public void updateUser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(faker.hashCode());
	  Response res = Userendpoints.UpdateUser(this.userpayload.getUsername(), userpayload);
	  res.then().log().body();
	  Userendpoints.getUser(this.userpayload.getUsername()).
	  then().log().body();
}
 //Delete user
 @Test	(priority=4)
 public void deleteUser() {
	 Response res = Userendpoints.deleteUser(this.userpayload.getUsername());
	  res.then().log().body();
}
}
