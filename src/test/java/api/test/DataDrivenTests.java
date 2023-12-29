package api.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


//Refer: https://www.youtube.com/watch?v=a4VDgcoltBw&list=PLUDwpEzHYYLvLZX_QEGTNolPvNADXid0I&index=10


public class DataDrivenTests {
	
	//@Test (priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testDataProvider (String userId, String userName, String fName, String lName, String email, String password, String ph)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	//@Test (priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUser (String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
