package api;

import configuration.BaseHttpClient;
import io.restassured.response.Response;

public class HelloApi extends BaseHttpClient {
    private final String apiPath = "/hello";

    public Response getHello() {return doGetAuth(apiPath);}
}

