package steps;


import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

@ScenarioScoped
public class Hooks {

  // private BaseClass base;
   private final String baseUrl = "https://gorest.co.in";
   public RequestSpecification request;
   public Response response;
   public Scenario scn;

 /*   public Hooks(BaseClass base) {
        this.base = base;
    }*/

    @Before
    public void setUp(Scenario scn){
     request = RestAssured.given().baseUri(baseUrl).header("Content-Type", "application/json");
     this.scn = scn;
    }

    static String getAlphaNumericString(int n)
    {

        // lower limit for LowerCase Letters
        int lowerLimit = 97;

        // lower limit for LowerCase Letters
        int upperLimit = 122;

        Random random = new Random();

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {

            // take a random value between 97 and 122
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));

            // append a character at the end of bs
            r.append((char)nextRandomChar);
        }

        // return the resultant string
        return r.toString();
    }



}
