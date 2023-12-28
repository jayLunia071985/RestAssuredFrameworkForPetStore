package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import api.endpoints.*;
import api.payload.Store;

public class StoreEndPoints {
	
	public static Response createOrder(Store payload)
	{
		Response response = given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
		
		.when()
			.post(Routes.create_Order);
		
		return response;	
	}
	
	public static Response getOrder(int orderId)
	{
		System.out.print("order Id Passed = "+ orderId + '\n');
		Response response = given()
				.pathParam("orderId", orderId)
				
				.when()
					.get(Routes.get_order);
		
		System.out.print("URL = " + Routes.get_order + '\n');
		
		return response;
	}
	
	public static Response deleteOrder(int orderId)
	{
		orderId = 9;
		Response response = given()
				.pathParam("orderId", orderId)
				
				.when()
					.delete(Routes.delete_order);
		
		return response;
	}
	
	

}
