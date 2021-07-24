package steps;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.requests.CreateUserRequestPojo;
import pojos.responses.CreateUserResponse;
import pojos.responses.GetUserResponse;
import utils.CreateUserTestContext;
import utils.GetUserTestContext;


import java.util.Map;

import static steps.Hooks.getAlphaNumericString;

public class CreateUserSteps {

    @Inject
    Hooks hooks;

    @Inject
    CreateUserTestContext createUserTestContext;

    @Inject
    GetUserTestContext getUserTestContext;

    CreateUserResponse createUserResponse;
    GetUserResponse getUserResponse;

    @Given("user is authorized")
    public void userIsAuthorized(DataTable dataTable) {
        Map<String, String> headers = dataTable.asMap(String.class, String.class);
        hooks.request.headers(headers);
    }

    @When("user make post request with endpoint as {string}")
    public void userMakePostRequestWithEndpointAs(String endpoint) {

        String name = getAlphaNumericString(8);
        CreateUserRequestPojo createUserRequestPojo = new CreateUserRequestPojo(name, "male",
                name + ".ramakrishna@15ce.com", "active");
        hooks.response = hooks.request.body(createUserRequestPojo).post(endpoint).then().extract().response();
        System.out.println("this is POST response");
        hooks.response.prettyPrint();
        createUserTestContext.setHttpResponse(hooks.response);

    }

    @Then("user should get response with status code as {int}")
    public void userShouldGetResponseWithStatusCodeAs(int expectedStatusCode) {
       Assert.assertEquals(expectedStatusCode, hooks.response.statusCode());
      //  Assert.assertEquals(userId, getUserResponse.getData().getId());
    }


    @When("user make GET request to verify user details with endpoint as {string}")
    public void userMakeGETRequestToVerifyUserDetailsWithEndpointAs(String endPoint) {
        createUserResponse = createUserTestContext.createUserDetails();
        hooks.response = hooks.request.pathParam("userId", createUserResponse.getData().getId()).get(endPoint).then().extract().response();
        System.out.println("this is GET response");
        hooks.response.prettyPrint();
        getUserTestContext.setHttpResponse(hooks.response);

    }

    @And("user should receive response for same user")
    public void userShouldReceiveResponseForSameUser() {

       Assert.assertEquals(createUserTestContext.getHttpResponse().body().asString(),
               getUserTestContext.getHttpResponse().body().asString());
        System.out.println("It is the same user dear");
    }
}
