package ru.churikov.rest.apitest.feed;

import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import ru.churikov.rest.apitest.step.FeedSteps;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.models.FeedDto;

public class GetApiTest {

    private FeedSteps steps = new FeedSteps();

    @Test
    public void getAuthAllFeed() {
        ValidatableResponse response = steps.getAllFeed();
        response.assertThat().statusCode(200);
        String jsonResponse = response.extract().body().asString();
        Assert.assertFalse(jsonResponse.isEmpty());
    }
    @Test
    public void getAuthFeedTest() {
        ValidatableResponse response = steps.getFeed("1");
        response.assertThat().statusCode(200);
        String jsonResponse = response.extract().body().asString();
        Assert.assertFalse(jsonResponse.isEmpty());
    }
}
