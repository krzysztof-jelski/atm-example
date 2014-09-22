package pl.pragmatists.atm.stepdefs;

import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pl.pragmatists.atm.support.AtmDsl;
import pl.pragmatists.atm.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class)
public class TellerStepDefinitions {

    @Autowired
    private AtmDsl atmDsl;

    @When("^I withdraw \\$(\\d+)$")
    public void I_withdraw_$(int amount) throws Throwable {
        atmDsl.withdraw(amount);
    }

}
