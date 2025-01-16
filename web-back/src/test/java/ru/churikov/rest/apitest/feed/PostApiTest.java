package ru.churikov.rest.apitest.feed;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.churikov.rest.apitest.step.FeedSteps;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.models.FeedDto;

public class PostApiTest {

    private FeedSteps steps = new FeedSteps();
/*
 //   @Test
    public void postAuthFeedPositiveTest() {
        Feed feed = new Feed("111", "faker.book().title()");
        ValidatableResponse response = steps.postFeed(feed);
        FeedDto jsonResponse = response.assertThat().statusCode(200).extract().body().as(FeedDto.class);// сделать все 1 цепочке
        Assert.assertNotNull(jsonResponse.getId());
    }*/
}
