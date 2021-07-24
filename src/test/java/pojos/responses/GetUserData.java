package pojos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserData {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private String message;

}
