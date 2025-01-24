package ru.churikov.rest.apitest.step;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.churikov.rest.api.CheckAuthApi;
import ru.churikov.rest.api.FeedApi;
import ru.churikov.rest.api.HelloApi;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.models.FeedDto;

public class FeedSteps {
    private FeedApi feedApi= new FeedApi();
    private HelloApi helloApi = new HelloApi();
    private CheckAuthApi checkAuthApi = new CheckAuthApi();

    @Step("Get all feeds")
    public ValidatableResponse getAllFeed() {
        return feedApi.getAllFeeds().then();
    }

    @Step("Get one feed")
    public ValidatableResponse getFeed(String id) {
        return feedApi.getFeed(id).then();
    }

    @Step("Delete feed")
    public ValidatableResponse deleteFeed(String id) {return feedApi.deleteFeed(id).then();}

    @Step("Create feed")
    public ValidatableResponse postFeed(Feed entity) {return  feedApi.postFeed(FeedDto.entityToDto(entity)).then();}

    @Step("Check test api")
    public ValidatableResponse getHello() {return helloApi.getHello().then();}

    @Step("Check auth info")
    public ValidatableResponse getAuthInfo() {return checkAuthApi.getAuthInfo().then();}
}
