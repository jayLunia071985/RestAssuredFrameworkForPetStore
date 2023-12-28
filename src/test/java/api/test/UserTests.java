package api.test;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.endpoints.*;
import api.endpoints.*;
import io.restassured.response.Response;


//https://www.youtube.com/watch?v=tXo2vO5QNAw&list=PLUDwpEzHYYLvLZX_QEGTNolPvNADXid0I&index=10



public class UserTests {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass()
	public void setUpData()
	{	
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().phoneNumber());	
	}
	
	@Test(priority = 1)
	public void testCreateUser()
	{
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
	}
	
	@Test(priority = 2)
	public void testGetUser()
	{
		System.out.print("Username for get User = "+userPayload.getUsername()+'\n');
		
		Response response = UserEndPoints.getUser(userPayload.getUsername());
		response.then().log().body();
	}
	
	@Test(priority = 3)
	public void testUpdateUser()
	{
		System.out.print("Username for update user = "+this.userPayload.getUsername()+'\n');
		
		//To Update Data
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		System.out.print("Username for updated user = "+this.userPayload.getUsername()+'\n');
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		//checking data after update using get request
		Response resFromGet = UserEndPoints.getUser(this.userPayload.getUsername());
		resFromGet.then().log().body();
		
	}
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		Response response = UserEndPoints.deleteUser(userPayload.getUsername());
		response.then().log().body();
	}
}
