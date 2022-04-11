package com.project.context.steps.rest;

import com.google.inject.Inject;
import com.project.context.services.rest.RestApi;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@ScenarioScoped
public class DummyAPISteps {

    @Inject
    public RestApi restApi;

    //for IO.rest.assured
    ValidatableResponse responseIO;
    //for IO.rest.assured
    Response response;
    //for closeable
    CloseableHttpResponse responseCloseable;

    @Then("[REST] Retrieve all employees")
    public void getEmployees() throws IOException {
        responseCloseable = restApi.getEmployees();
        HttpEntity entity = responseCloseable.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);
    }

    @Then("[REST] Retrieve all employee and verify request is {} and counts the number of employees over 30")
    public void getEmployeeOver30(String message) {
        responseIO = restApi.getEmployeesIORestAssured();
        responseIO.assertThat().body("message", containsString(message));
        JsonPath jsonPath = responseIO.extract().jsonPath();
        List<Integer> countEmployeesOver30 = jsonPath.getList("data.findAll{it.employee_age>30}.employee_age");
        System.out.println(countEmployeesOver30.size());
    }

    @Then("[REST] Add new employee {} and verify that request returns code {int}")
    public void addEmployee(String requestBody, int statusCode) throws URISyntaxException, IOException {
        response = restApi.postEmployee(requestBody);
        response.then().statusCode(statusCode);
    }

    @Then("[REST] Delete employee id {} and verify that request has status is {} and status code {}")
    public void addEmployee(int id, String status, int statusCode) {
        responseIO = restApi.deleteEmployeeID(id);
        responseIO.assertThat().body("status", equalToIgnoringCase(status));
        responseIO.assertThat().statusCode(statusCode);
    }

}
