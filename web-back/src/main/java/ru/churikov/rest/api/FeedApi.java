package ru.churikov.rest.api;

import io.restassured.response.Response;
import ru.churikov.rest.configurations.BaseHttpClient;
import ru.churikov.rest.models.FeedDto;

public class FeedApi extends BaseHttpClient{
    private final String apiPath = "/api/feed";

    public Response getAllFeeds() {return doGetAuth(apiPath + "/all");}
    public Response getFeed(String id) {return doGetAuth(apiPath + "/" + id);}
    public Response deleteFeed(String id) {return doDelete(apiPath+ "/" + id);}
    public Response postFeed(FeedDto dto) {
        return doPost(apiPath, dto);
    }
}
