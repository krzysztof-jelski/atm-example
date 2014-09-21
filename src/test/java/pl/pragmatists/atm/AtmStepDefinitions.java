package pl.pragmatists.atm;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pl.pragmatists.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class)
public class AtmStepDefinitions {

    @Autowired
    private AtmDsl atmDsl;

    @Given("^my account has been credited with \\$(\\d+)$")
    public void my_account_has_been_credited_with_$(int amount) {
        atmDsl.accountHasBeenCreditedWith(amount);
    }

    @When("^I withdraw \\$(\\d+)$")
    public void I_withdraw_$(int amount) throws Throwable {
        atmDsl.withdraw(amount);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int amount) throws Throwable {
        atmDsl.assertDispensed(amount);
    }

    @Then("^the balance of my account should be \\$(\\d+)$")
    public void the_balance_of_my_account_should_be_$(int balance) {
        atmDsl.assertAccountBalance(balance);
    }

    @Then("^nothing should be dispensed$")
    public void nothing_should_be_dispensed() {
        atmDsl.assertDispensed(0);
    }

    @Then("^I should be told that I have insufficient funds in my account$")
    public void I_should_be_told_that_I_have_insufficient_funds_in_my_account() {
        atmDsl.assertMessageShown("Insufficient funds");
    }

}
