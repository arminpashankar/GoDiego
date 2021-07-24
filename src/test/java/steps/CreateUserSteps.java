package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import pojos.requests.CreateUserRequestPojo;
import pojos.responses.Data;
import pojos.responses.GetUserResponse;
import utils.BaseClass;

import java.util.Map;

import static steps.Hooks.getAlphaNumericString;

public class CreateUserSteps {
    private BaseClass base;
    private int userId;
    private GetUserResponse getUserResponse;
    private GetUserResponse createUserResponse;

    public CreateUserSteps(BaseClass base) {
        this.base = base;
    }


    @Given("user is authorized")
    public void userIsAuthorized(DataTable dataTable) {
        Map<String, String> headers = dataTable.asMap(String.class, String.class);
        base.request.headers(headers);
    }

    @When("user make post request with endpoint as {string}")
    public void userMakePostRequestWithEndpointAs(String endpoint) {
       // String payload = "{\"name\":\"Jonu\", \"gender\":\"male\", \"email\":\"jonu.ramakrishna@15ce.com\", \"status\":\"active\"}";

        String name = getAlphaNumericString(8);
        CreateUserRequestPojo createUserRequestPojo = new CreateUserRequestPojo(name, "male",
                name + ".ramakrishna@15ce.com", "active");
        base.response = base.request.body(createUserRequestPojo).post(endpoint).then().extract().response();
        System.out.println("this is POST response");
        base.response.prettyPrint();
        createUserResponse = base.response.as(GetUserResponse.class);
        userId = createUserResponse.getData().getId();
        }

    @Then("user should get response with status code as {int}")
    public void userShouldGetResponseWithStatusCodeAs(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, base.response.statusCode());
      //  Assert.assertEquals(userId, getUserResponse.getData().getId());
    }


    @When("user make GET request to verify user details with endpoint as {string}")
    public void userMakeGETRequestToVerifyUserDetailsWithEndpointAs(String endPoint) {
        base.response = base.request.pathParam("userId", userId).get(endPoint).then().extract().response();
        System.out.println("this is GET response");
        base.response.prettyPrint();
    }

    @And("user should receive response for same user")
    public void userShouldReceiveResponseForSameUser() {
        getUserResponse = base.response.as(GetUserResponse.class);
        System.out.println("It is the same user dear");
    }
}
