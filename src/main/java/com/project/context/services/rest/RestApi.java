package com.project.context.services.rest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class RestApi extends BaseRest {

    //Constants
    private static final String POST_ENDPOINT = "/create";
    private static final String GET_ENDPOINT = "/employees";
    private static final String GET_CUSTOM_ENDPOINT = "/employee/";
    private static final String PUT_ENDPOINT = "/update/{id}";
    private static final String DELETE_ENDPOINT = "/delete/{id}";

    //try-with-resources statement ensures that each resource is closed at the end of the statement
    
    // rest api using CloseableHttpClient
    public void postEmployeeCloseableHttpClient(String requestBody) throws URISyntaxException, IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost(BASE_URL + POST_ENDPOINT);
            postRequest.setHeader("Content-Type", "application/json");
            postRequest.setHeader("accept", "application/json");
            StringEntity entity = new StringEntity(requestBody);
            postRequest.setEntity(entity);
            CloseableHttpResponse response = client.execute(postRequest);
            CloseableHttpResponse respEntity = (CloseableHttpResponse) response.getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Entire response from API will be stored in CloseableHttpResponse reference
    public CloseableHttpResponse getEmployees() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault(); // create connection
        HttpGet get = new HttpGet(BASE_URL + GET_ENDPOINT);
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Accept", "application/json");
        CloseableHttpResponse closeablehttpResponse = client.execute(get);
        return closeablehttpResponse;
    }

    public Response postEmployee(String requestBody) {
        return given()
                .contentType("application/json")
                .body(requestBody)
                .post(BASE_URL + POST_ENDPOINT);
    }


    //     rest api using io.restassured
    public ValidatableResponse getEmployeesIORestAssured() {
        return given()
                .headers("Content-Type", "application/json")
                .contentType(io.restassured.http.ContentType.JSON)
                .accept(io.restassured.http.ContentType.JSON)
                .when()
                .get(BASE_URL + GET_ENDPOINT)
                .then();
//                .assertThat().statusCode(200);  sometimes the DummyRest returns 429

    }

    public ValidatableResponse deleteEmployeeID(long id) {
        return given()
                .headers("Content-Type", "application/json")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .delete(BASE_URL + DELETE_ENDPOINT, id)
                .then().assertThat().statusCode(200);
    }

}

