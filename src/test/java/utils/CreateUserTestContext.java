package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import lombok.Data;
import pojos.responses.CreateUserResponse;
import pojos.responses.GetUserResponse;

@Data
@ScenarioScoped
public class CreateUserTestContext {
    Response httpResponse;
    CreateUserResponse createUserResponse;

    public CreateUserResponse createUserDetails() {
        ObjectMapper mapper = new ObjectMapper();
        try {
           createUserResponse = mapper.readValue(httpResponse.body().asString(), CreateUserResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return createUserResponse;
    }
}
