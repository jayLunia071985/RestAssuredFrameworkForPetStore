package api.endpoints;

/*
Swagger URl: https://petstore.swagger.io/v2

//User
createUser: https://petstore.swagger.io/v2/user
getUser:    https://petstore.swagger.io/v2/user/{username}
updateUser: https://petstore.swagger.io/v2/user/{username}
deleteUser: https://petstore.swagger.io/v2/user/{username}

//Store
createOrder: https://petstore.swagger.io/v2/store/order
getOrder:    https://petstore.swagger.io/v2/store/order/{orderId}
deleteOrder: https://petstore.swagger.io/v2/store/order/{orderId}


//Pets
createPet: https://petstore.swagger.io/v2/pet
getPet:    https://petstore.swagger.io/v2/{petId}
updatePet: https://petstore.swagger.io/v2/pet
deletePet: https://petstore.swagger.io/v2/{petId}
*/	

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module Url's
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module Url's
	public static String create_Order = base_url+"/store/order";
	public static String get_order = base_url+"/store/order/{orderId}";
	public static String delete_order = base_url+"/store/order/{orderId}";
	
	//Pet Module Url's
	public static String create_pet = base_url+"/pet";
	public static String get_pet = base_url+"/pet/{petId}";
	public static String update_pet = base_url+"/pet";
	public static String delete_pet = base_url+"/pet/{petId}";
		
}
