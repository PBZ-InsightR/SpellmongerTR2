import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by adrianpothuaud on 07/12/2016.
 */
public class CardVSCard_StepDef {

    @Given("^\"([^\"]*)\" and \"([^\"]*)\" enter the game, receive (\\d+) cards and (\\d+) life points$")
    public void andEnterTheGameReceiveCardsAndLifePoints(String arg0, String arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^\"([^\"]*)\" plays a \"([^\"]*)\"$")
    public void playsA(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^\"([^\"]*)\" wins the roud$")
    public void winsTheRoud(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
