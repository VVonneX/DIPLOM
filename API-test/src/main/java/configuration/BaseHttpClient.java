package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.util.Base64;


public class BaseHttpClient {
    private RequestSpecification requestSpecificationNotAuth() {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    private RequestSpecification requestSpecificationAuth() {
        String auth = "admin" + ":" + "1234";
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Authorization", "Basic " + encodedAuth)
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    protected Response doGet(String path) {
        return given()
                .spec(requestSpecificationNotAuth())
                .get(path)
                .thenReturn();
    }

    protected Response doGetAuth(String path) {
        return given()
                .spec(requestSpecificationAuth())
                .get(path)
                .thenReturn();
    }

    protected Response doDelete(String path) {
        return given()
                .spec(requestSpecificationAuth())
                .delete(path)
                .thenReturn();
    }

    protected Response doPost(String path, Object body) {
        return given()
                .spec(requestSpecificationAuth())
                .header("Content-type", "application/json")
                .body(body)
                .post(path)
                .thenReturn();
    }

}
