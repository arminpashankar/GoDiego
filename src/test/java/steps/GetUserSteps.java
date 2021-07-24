package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import org.picocontainer.annotations.Inject;
import pojos.responses.GetUserResponse;
import utils.BaseClass;

public class GetUserSteps {

  //  private BaseClass base;

  /*  public GetUserSteps(BaseClass base) {
        this.base = base;
    }*/

    @Inject
    GetUserResponse getUserResponse;
    @Inject
    Hooks hooks;

    @Given("Go rest api is up and running")
    public void goRestApiIsUpAndRunning() {
        System.out.println("it is up");
    }


    @Then("I should receive response with status code as {int}")
    public void iShouldReceiveResponseWithStatusCodeAs(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode , hooks.response.statusCode());
    }

    @And("I should receive details for same {string}")
    public void iShouldReceiveDetailsForSame(String arg0) {
    }


    @When("I perform GET request with endpoint as {string} for {string}")
    public void iPerformGETRequestWithEndpointAsFor(String endpoint, String userId) {
        hooks.response =  hooks.request.pathParam("user_id", userId).get(endpoint).then().extract().response();
        hooks.response.prettyPrint();
    }

    @When("I perform GET request with endpoint as {string} for {int}")
    public void iPerformGETRequestWithEndpointAsFor(String endpoint, int userId) {
        hooks.response =  hooks.request.pathParam("user_id", userId).get(endpoint).then().extract().response();
        hooks.response.prettyPrint();
    }

    @And("I should receive the Error Response as {string}")
    public void iShouldReceiveTheErrorResponseAs(String expectedErrorMessage) {
        getUserResponse = hooks.response.as(GetUserResponse.class);
        Assert.assertEquals(expectedErrorMessage, getUserResponse.getData().getMessage());
    }
}
