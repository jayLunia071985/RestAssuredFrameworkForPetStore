package api.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import io.restassured.response.Response;

public class PetTests {
	
	Faker faker;
	Pet petPayload;
	public Logger logger;  //For Logs
	
	@BeforeClass()
	public void generateData()
	{
		faker = new Faker();
		petPayload = new Pet();
		
		logger=LogManager.getLogger(this.getClass()); //For Logs
		
		petPayload.setName(faker.name().firstName());
		petPayload.setStatus(faker.funnyName().name());

		Category category = new Category();
		category.setName(faker.name().firstName());
		petPayload.setCategory(category); //Very Important to set it to Parent
		
		//Setting 4 different Names for a Tag
		Tags tags1 = new Tags();
		tags1.setName(faker.name().firstName());
		
		Tags tags2 = new Tags();
		tags2.setName(faker.name().firstName());
		
		Tags tags3 = new Tags();
		tags3.setName(faker.name().firstName());
		
		Tags tags4 = new Tags();
		tags4.setName(faker.name().firstName());
		
		//Adding name in the array list
		List<Tags> tags = new ArrayList<>();
		tags.add(tags1);
		tags.add(tags2);
		tags.add(tags3);
		tags.add(tags4);
		
		petPayload.setTags(tags); //Very Important to set it to Parent
		
		System.out.print(petPayload);
		
	}
	
	//@Test(priority = 1)
	public void testCreatePet()
	{
		logger.info("=========Ceate Test Started===========");
		Response response = PetEndPoints.createPet(petPayload);
		response.then().log().body();
		logger.info("=========Create Test Ended===========");		
	}
	
	//@Test(priority = 2)
	public void testGetPet()
	{
		logger.info("=========Get Test Started===========");
		Response response = PetEndPoints.getUser(9);
		response.then().log().body();
		logger.info("=========Get Test Ended===========");
	}
	
	//@Test(priority = 3)
	public void testUpdatePet()
	{
		logger.info("=========Update Test Started===========");
		petPayload.setName(faker.name().firstName());
		petPayload.setStatus(faker.funnyName().name());

		Response response = PetEndPoints.updatePet(petPayload);
		response.then().log().body();
		
		logger.info("=========Update Test Ended===========");
	}
	
	
	
	//@Test(priority = 4)
	public void testDeletePet()
	{
		logger.info("=========Delete Test Started===========");
		Response response = PetEndPoints.deleteUser(8);
		response.then().log().body();
		logger.info("=========Delete Test Ended===========");
	}
	
	@Test (priority = 5)
	public void testCreatePetUsingPropertiesFile() throws IOException
	{
		Response response = PetEndPoints.createPetUsingPropertiesFile(petPayload);
		response.then().log().body();			
	}

}
