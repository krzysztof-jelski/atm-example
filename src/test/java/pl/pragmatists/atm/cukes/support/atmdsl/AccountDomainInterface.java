package pl.pragmatists.atm.cukes.support.atmdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.domain.Account;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@Scope("cucumber-glue")
public class AccountDomainInterface {
    @Autowired
    private Account account;

    public void accountHasBeenCreditedWith(int amount) {
        account.credit(amount);
        assertAccountBalance(amount);
    }

    public void assertAccountBalance(int balance) {
        assertThat(account.getBalance()).isEqualTo(balance);
    }

}
