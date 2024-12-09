package ru.churikov.rest.models;

import io.restassured.response.Response;
import ru.churikov.rest.configurations.BaseHttpClient;

public class FeedApi extends BaseHttpClient {
    private final String apiPath = "/api/feed";

    public Response getAllUsers() {return doGetAuth(apiPath + "/all");}
    public Response getUser(String id) {return doGet(apiPath + "/" + id);}
}
