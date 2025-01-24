package test;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import step.FeedSteps;

public class GetApiTest {
    private FeedSteps steps = new FeedSteps();

       @Test
    public void getAuthAllPositiveFeed() {
        ValidatableResponse response = steps.getAllFeed();
        String jsonResponse = response.assertThat().statusCode(200).extract().body().asString();
        Assert.assertFalse(jsonResponse.isEmpty());
    }

       @Test
    public void getAuthFeedPositiveTest() {
        ValidatableResponse response = steps.getFeed("3");
        String jsonResponse = response.assertThat().statusCode(200).extract().body().asString();
        Assert.assertFalse(jsonResponse.isEmpty());
    }

       @Test
    public void getHelloPositiveTest() {
        ValidatableResponse response = steps.getHello();
        String jsonResponse = response.assertThat().statusCode(200).extract().body().asString();
        Assert.assertEquals(jsonResponse,"Hello");
    }

      @Test
    public void getAuthInfoPositiveTest() {
        ValidatableResponse response = steps.getAuthInfo();
        String jsonResponse = response.assertThat().statusCode(200).extract().body().asString();
        Assert.assertTrue(jsonResponse.contains("SUPER_USER"));
    }
}
