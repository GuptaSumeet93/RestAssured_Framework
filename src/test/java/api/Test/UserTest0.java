package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoint.UserEndpoints;
import api.Payload.User;
import io.restassured.response.Response;

public class UserTest0 {
	
	Faker faker;
	User userPayload;
	

	@BeforeTest
	public void setup()
	{
		
		
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		userPayload.setPassword(faker.internet().password(5,10));

		userPayload.setPhone(faker.phoneNumber().cellPhone());
}
	@Test(priority=1)
	
	public void testPostUser()
	{
		Response response=UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),(200));
		
		
	}
	
@Test(priority=2)
	
	public void testGetUserByName()
	{
		Response response=UserEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),(200));
		
		
	}


@Test(priority=3)

public void testUpdatetUserByName()
{
	Response response=UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),(200));
	
	//Checking  data After Update
	
	Response responseAfterUpdate=UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
	Assert.assertEquals(responseAfterUpdate.getStatusCode(),(200));

}
@Test(priority=4)

public void testDeleteUserByName()
{
	Response response=UserEndpoints.deleteUser(this.userPayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),(200));
	
	
}
	

}
