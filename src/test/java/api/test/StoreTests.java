package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Store storePayLoad;
	
	@BeforeClass()
	public void generateData()
	{
		faker = new Faker();
		storePayLoad = new Store();
		
		//storePayLoad.setId(faker.idNumber().hashCode());
		//storePayLoad.setPetId(faker.idNumber().hashCode());
		//storePayLoad.setQuantity(faker.number().hashCode());
		storePayLoad.setShipDate(faker.date().birthday(20, 30).toString());
		storePayLoad.setStatus(faker.name().bloodGroup());
		storePayLoad.setComplete(faker.name().firstName());
		
		
		System.out.print(" Id Generated: "+storePayLoad.getId()+'\n');
		System.out.print(" Pet Id Generated: "+storePayLoad.getPetId()+'\n');
		System.out.print(" Quantity Generated: "+storePayLoad.getQuantity()+'\n');
		System.out.print(" Ship Date Generated: "+storePayLoad.getShipDate()+'\n');
		System.out.print(" Status Generated: "+storePayLoad.getStatus()+'\n');
		System.out.print(" Completed Generated: "+storePayLoad.getComplete()+'\n');
		
	}
	
	
	
	@Test(priority = 1)
	public void testCreateOrder()
	{
		Response response = StoreEndPoints.createOrder(storePayLoad);
		//response.then().statusCode(200);
		response.then().log().body();
	}
	
	@Test(priority = 2)
	public void testGetOrder()
	{
		int id =8 ;
		Response response = StoreEndPoints.getOrder(id);
		response.then().log().body();
		response.then().statusCode(200);
		
		Assert.assertEquals(response.statusCode(), 200);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getOrderSchema.json"));
	}
	
	@Test(priority = 3)
	public void testDeleteOrder()
	{
		Response response = StoreEndPoints.deleteOrder(this.storePayLoad.getId());
		response.then().log().body();
		//response.then().statusCode(0);
		
		//Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	

}
