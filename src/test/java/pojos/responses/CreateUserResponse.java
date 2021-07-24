package pojos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;


@lombok.Data
@ScenarioScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {

    private String meta;
    private CreateUserData data;


}
