package test;

import io.restassured.response.ValidatableResponse;
import model.FeedDto;


import org.junit.Assert;
import org.junit.Test;

public class PostApiTest extends BaseConf{

    @Test
    public void postAuthFeedPositiveTest() {
        ValidatableResponse response = steps.postFeed(feed);
        FeedDto jsonResponse = response.assertThat().statusCode(200).extract().body().as(FeedDto.class);// сделать все 1 цепочке
        Assert.assertNotNull(jsonResponse.getId());
    }
}
