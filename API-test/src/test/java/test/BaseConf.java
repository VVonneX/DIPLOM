package test;

import io.restassured.response.ValidatableResponse;
import model.Feed;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import step.FeedSteps;

public class BaseConf {

    public FeedSteps steps = new FeedSteps();
    public Feed feed;

    @Before
    public void startFeed() {
        feed = new Feed(1L, "asdaa", "fffff");
    }

    @After
    public void deleteAuthFeedPositiveTest() {
        ValidatableResponse response = steps.deleteFeed(1L);
        response.assertThat().statusCode(200);
        String jsonResponse = response.extract().body().asString();
        Assert.assertTrue(jsonResponse.isEmpty());
    }
}
