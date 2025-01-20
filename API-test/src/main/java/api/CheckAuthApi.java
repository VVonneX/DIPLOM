package api;

import configuration.BaseHttpClient;
import io.restassured.response.Response;


public class CheckAuthApi extends BaseHttpClient {
    private final String apiPath = "/auth/this";

    public Response getAuthInfo() {return doGetAuth(apiPath);}
}
