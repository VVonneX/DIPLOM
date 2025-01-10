package ru.churikov.rest.api;

import io.restassured.response.Response;
import ru.churikov.rest.configurations.BaseHttpClient;

public class HelloApi extends BaseHttpClient {
    private final String apiPath = "/hello";

    public Response getHello() {return doGetAuth(apiPath);}
}
