package api;

import configuration.BaseHttpClient;
import io.restassured.response.Response;
import model.FeedDto;

public class FeedApi extends BaseHttpClient {
    private final String apiPath = "/api/feed";

    public Response getAllFeeds() {return doGetAuth(apiPath + "/all");}
    public Response getFeed(String id) {return doGetAuth(apiPath + "/" + id);}
    public Response deleteFeed(Long id) {return doDelete(apiPath+ "/" + id);}
    public Response postFeed(FeedDto dto) {
        return doPost(apiPath, dto);
    }
}
