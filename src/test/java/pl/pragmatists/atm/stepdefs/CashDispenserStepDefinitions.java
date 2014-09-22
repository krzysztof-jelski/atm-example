package pl.pragmatists.atm.stepdefs;

import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pl.pragmatists.atm.support.AtmDsl;
import pl.pragmatists.atm.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class)
public class CashDispenserStepDefinitions {

    @Autowired
    private AtmDsl atmDsl;

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int amount) throws Throwable {
        atmDsl.assertDispensed(amount);
    }

    @Then("^nothing should be dispensed$")
    public void nothing_should_be_dispensed() {
        atmDsl.assertDispensed(0);
    }

}