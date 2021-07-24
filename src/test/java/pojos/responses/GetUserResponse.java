package pojos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;


@lombok.Data
@ScenarioScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse {
    private String meta;
    private GetUserData data;

}
