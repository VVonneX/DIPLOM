/*
package test;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import step.FeedSteps;

public class DeleteApiTest {

    private FeedSteps steps = new FeedSteps();

    @Test
    public void deleteAuthFeedPositiveTest() {
        ValidatableResponse response = steps.deleteFeed("1");
        response.assertThat().statusCode(200);
        String jsonResponse = response.extract().body().asString();
        Assert.assertTrue(jsonResponse.isEmpty());
    }
}
*/
