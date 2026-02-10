package petstore;

public class Routes {
	
	public static final String baseurlUser = "https://petstore.swagger.io/v2";
//	User urls
	public static final String CreateUser= baseurlUser+"/user/";
	public static final String GetUser= baseurlUser+"/user/{username}";
	public static final String UpdateUser= baseurlUser+"/user/{username}";
	public static final String DeleteUser= baseurlUser+"/user/{username}";

}
