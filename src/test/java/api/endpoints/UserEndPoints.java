package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;

//User Endpoint.java file, which is created to perform CRUD operation for user Module

public class UserEndPoints {
	
	public static Response createUser (User Payload)
	{
		Response response = given()
			.contentType("application/json")
			.accept("application/json")
			.body(Payload)
		
		.when()
			.post(Routes.base_url);
		
		System.out.print("Payload from End Point = "+Payload);
		
		return response;
	}
	
	public static Response getUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
		
		return response;	
	}
	
	public static Response updateUser(String userName, User Payload)
	{
		Response response =given()
			.contentType("application/json")
			.accept("application/json")
			.pathParam("username", userName)
			.body(Payload)
		
		.when()
			.put(Routes.put_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
		
		return response;	
	}
}
