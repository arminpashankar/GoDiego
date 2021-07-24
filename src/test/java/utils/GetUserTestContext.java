package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import lombok.Data;
import pojos.responses.GetUserResponse;

@Data
@ScenarioScoped
public class GetUserTestContext {
    Response httpResponse;
    GetUserResponse getUserResponse;

    public GetUserResponse getUserDetails() {
        ObjectMapper mapper = new ObjectMapper();
        try {
           getUserResponse = mapper.readValue(httpResponse.body().asString(), GetUserResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return getUserResponse;
    }
}
