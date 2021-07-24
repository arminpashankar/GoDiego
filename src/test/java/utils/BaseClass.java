package utils;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

    public RequestSpecification request;
    public Response response;
    public Scenario scn;
}
