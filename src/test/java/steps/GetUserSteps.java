package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.responses.GetUserResponse;
import utils.GetUserTestContext;

public class GetUserSteps {

    @Inject
    Hooks hooks;
    @Inject
    GetUserTestContext getUserTestContext;

    GetUserResponse getUserResponse;

    @Given("Go rest api is up and running")
    public void goRestApiIsUpAndRunning() {
        System.out.println("it is up");
    }

    @Then("I should receive response with status code as {int}")
    public void iShouldReceiveResponseWithStatusCodeAs(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode , hooks.response.statusCode());
    }

    @When("I perform GET request with endpoint as {string} for {string}")
    public void iPerformGETRequestWithEndpointAsFor(String endpoint, String userId) {
        hooks.response =  hooks.request.pathParam("user_id", userId).get(endpoint).then().extract().response();
        hooks.response.prettyPrint();
        getUserTestContext.setHttpResponse(hooks.response);
    }

    @When("I perform GET request with endpoint as {string} for {int}")
    public void iPerformGETRequestWithEndpointAsFor(String endpoint, int userId) {
        hooks.response =  hooks.request.pathParam("user_id", userId).get(endpoint).then().extract().response();
        hooks.response.prettyPrint();
        getUserTestContext.setHttpResponse(hooks.response);
    }

    @And("I should receive the Error Response as {string}")
    public void iShouldReceiveTheErrorResponseAs(String expectedErrorMessage) {
        getUserResponse = getUserTestContext.getUserDetails();
        Assert.assertEquals(expectedErrorMessage, getUserResponse.getData().getMessage());
    }

    @And("I should receive details for same {int}")
    public void iShouldReceiveDetailsForSameUserId(int expectedUserId) {
        getUserResponse = getUserTestContext.getUserDetails();
        Assert.assertEquals(expectedUserId, getUserResponse.getData().getId());
    }
}
