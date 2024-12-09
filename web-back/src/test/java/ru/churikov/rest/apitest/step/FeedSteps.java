package ru.churikov.rest.apitest.step;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.churikov.rest.models.FeedApi;

public class FeedSteps {
    private FeedApi feedApi= new FeedApi();

    @Step("Get all users")
    public ValidatableResponse getAllFeed() {
        return feedApi.getAllUsers().then();
    }

    @Step("Get one user")
    public ValidatableResponse getFeed(String id) {
        return feedApi.getUser(id).then();
    }
}
