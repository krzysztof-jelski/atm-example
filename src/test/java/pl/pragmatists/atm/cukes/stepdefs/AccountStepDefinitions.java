package pl.pragmatists.atm.cukes.stepdefs;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.cukes.support.CukesSpringConfiguration;
import pl.pragmatists.atm.cukes.support.atmdsl.AccountDomainInterface;
import pl.pragmatists.atm.cukes.support.atmdsl.AtmDsl;
import pl.pragmatists.atm.cukes.transforms.MoneyConverter;
import pl.pragmatists.atm.domain.Money;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class AccountStepDefinitions {

    @Autowired
    private AtmDsl atmDsl;

    @Autowired
    private AccountDomainInterface account;

    @Given("^my account has been credited with \\$([\\d.]+)$")
    public void my_account_has_been_credited_with_$(@Transform(MoneyConverter.class) Money amount) {
        account.accountHasBeenCreditedWith(amount.dollars);
    }

    @Then("^the balance of my account should be \\$(\\d+)$")
    public void the_balance_of_my_account_should_be_$(int balance) {
        account.assertAccountBalance(balance);
    }

    @Then("^I should be told that I have insufficient funds in my account$")
    public void I_should_be_told_that_I_have_insufficient_funds_in_my_account() {
        atmDsl.assertMessageShown("Insufficient funds");
    }

}
