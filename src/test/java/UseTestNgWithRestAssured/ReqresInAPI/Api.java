package UseTestNgWithRestAssured.ReqresInAPI;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Api {
    @Test(priority = 1)
    public void getUserInPageTwo(){
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        int actualStatus=response.statusCode();
        Assert.assertEquals(actualStatus,200);
    }
    @Test(priority = 2)
    public void getSingleUser(){
        Response response = given().when().get("https://reqres.in/api/users/2");
        ResponseBody responsee = response.body();
        String actualBody = responsee.toString();
        Assert.assertTrue(actualBody.contains("Michael"));

        int actualStatus=response.statusCode();
        Assert.assertEquals(actualStatus,200);
    }
}
