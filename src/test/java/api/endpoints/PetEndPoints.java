package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import api.payload.Pet;
import io.restassured.response.Response;

public class PetEndPoints {
	
	//reading Data from Properties file
	static ResourceBundle getUrl()
	{
		ResourceBundle rb = ResourceBundle.getBundle("routes");
		return rb;	
	}
	
	public static Response createPet(Pet payload)
	{
		Response response = given()
				.contentType("application/json")
				.body(payload)
				
			.when()
				.post(Routes.create_pet);
		
		return response;
	}
	
	//Using data from Properties file
	public static Response createPetUsingPropertiesFile(Pet payload) throws IOException
	{
		
		//Fetching URL from Properties file
		String createPetUrlResourceBundle = getUrl().getString("createPet");
		System.out.print("PATH via Resource Bundle is:"+createPetUrlResourceBundle+"\n");

		Response response = given()
				.contentType("application/json")
				.body(payload)
				
			.when()
				.post(createPetUrlResourceBundle);
		
		return response;
	}
	
	public static Response getUser(int petId)
	{
		Response response = given()
				.pathParam("petId", petId)
				
			.when()
				.get(Routes.get_pet);
		
		return response;
	}
	
	public static Response updatePet(Pet payload)
	{
		
		Response response = given()
				.contentType("application/json")
				.body(payload)
			
			.when()
				.put(Routes.update_pet);
				
			return response;
	}
	
	public static Response deleteUser(int petId)
	{
		Response response = given()
				.pathParam("petId", petId)
				
			.when()
				.delete(Routes.get_pet);
		
		return response;
	}
	


}
