package petstore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.utilities.Data;
import io.restassured.response.Response;

public class Practicepetstoretestusingurlsfromfile {
	User userpayload= new User();
	Logger logger = LogManager.getLogger(this.getClass());
	
	
	 @Test(priority =1 ,dataProvider= "fetchdata" , dataProviderClass= Data.class)
	 public void createUser(String username, String id, String firstName, String lastName, String email , String password, String phone
			 ,String statuscode) {
		  System.out.println(username);
			userpayload.setId(Integer.parseInt(id));
			userpayload.setFirstName(firstName);
			userpayload.setLastName(lastName);
			userpayload.setEmail(email);
			userpayload.setPassword(password);
			userpayload.setPhone(phone);
			userpayload.setUsername(username);
			userpayload.setUserStatus(Integer.parseInt(statuscode));
			logger.info("--user created--");
		  Response res = Userendpointsusingfile.CreateUser(userpayload);
		  System.out.println(this.userpayload.getUsername());
		  res.then().log().body();
		  logger.trace("--user created--");
	 }
	 
	  @Test
	  (priority = 2 ,dataProvider= "getdata" , dataProviderClass= Data.class)
	  public void getUser(String username) {
	  	  Response res = Userendpointsusingfile.getUser(username);
	  	  res.then().log().body();
	  	AssertJUnit.assertEquals(res.getStatusCode(), 200);
	  	logger.info("--user retreived--");
	}
	  @Test(priority = 3 ,dataProvider= "getdata" , dataProviderClass= Data.class)
	  public void deleteUser(String username) {
	  	  Response res = Userendpointsusingfile.deleteUser(username);
	  	  res.then().log().body();
	  	  AssertJUnit.assertEquals(res.getStatusCode(), 200);
	  	logger.info("--user deleted--------");
	}
	  

}

