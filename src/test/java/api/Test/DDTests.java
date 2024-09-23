package api.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoint.UserEndpoints;
import api.Payload.User;
import api.Utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority =1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String fName ,String lName ,String pwd ,String email,String ph)
	{
		
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);

		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);

		userPayload.setPassword(pwd);

		userPayload.setPhone(ph);

		
		Response response=UserEndpoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(),(200));
		
		

	}
	
	@Test(priority =2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		

		
		Response response=UserEndpoints.deleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(),(200));
		
		

	}
	
}
