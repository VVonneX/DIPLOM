package ru.churikov.rest.api;


import io.restassured.response.Response;
import ru.churikov.rest.configurations.BaseHttpClient;

public class CheckAuthApi extends BaseHttpClient {
    private final String apiPath = "/auth/this";

    public Response getAuthInfo() {return doGetAuth(apiPath);}
}
