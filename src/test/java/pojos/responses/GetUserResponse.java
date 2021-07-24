package pojos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;


@lombok.Data
@ScenarioScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse {
    private String meta;
    private Data data;

   /* public void setMeta(String meta) {
        this.meta = meta;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMeta() {
        return meta;
    }

    public Data getData() {
        return data;
    }*/


}
