package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApiClient {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public Response get(String endpoint) {

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get(endpoint);
    }

    public Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response put(String endpoint, Object body) {

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    public Response delete(String endpoint) {

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .delete(endpoint);
    }
}