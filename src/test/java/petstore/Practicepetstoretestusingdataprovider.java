package petstore;

import io.restassured.response.Response;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import api.utilities.Data;
import api.utilities.Listenerclass;



//@Listeners(Listenerclass.class)
public class Practicepetstoretestusingdataprovider {
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
		  Response res = Userendpoints.CreateUser(userpayload);
	//	  System.out.println(this.userpayload.getUsername());
		  res.then().log().body();
		  logger.info("--user created--");
	 }
	 
	  @Test
	  (priority = 2 ,dataProvider= "getdata" , dataProviderClass= Data.class)
	  public void getUser(String username) {
	  	  Response res = Userendpoints.getUser(username);
	  	  res.then().log().body();
	  	Assert.assertEquals(res.getStatusCode(), 200);
	  	logger.info("--user retreived--");
	}
	  @Test(priority = 3 ,dataProvider= "getdata" , dataProviderClass= Data.class)
	  public void deleteUser(String username) {
	  	  Response res = Userendpoints.deleteUser(username);
	  	  res.then().log().body();
	  	  Assert.assertEquals(res.getStatusCode(), 200);
	  	logger.info("--user deleted--------");
	}
	  

}
