package pl.pragmatists.atm.cukes.stepdefs;

import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.cukes.support.CukesSpringConfiguration;
import pl.pragmatists.atm.cukes.support.atmdsl.AtmInterfaceFactory;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class TellerStepDefinitions {

    @Autowired
    private AtmInterfaceFactory atmInterfaceFactory;

    @When("^I withdraw \\$(\\d+)$")
    public void I_withdraw_$(int amount) throws Throwable {
        atmInterfaceFactory.getTellerInterface().withdraw(amount);
    }

}
