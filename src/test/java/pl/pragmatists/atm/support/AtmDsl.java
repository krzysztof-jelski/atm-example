package pl.pragmatists.atm.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.Account;
import pl.pragmatists.atm.CashDispenser;
import pl.pragmatists.atm.Display;
import pl.pragmatists.atm.Teller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@Component
@Scope("cucumber-glue")
public class AtmDsl {

    @Autowired
    private Account account;
    @Autowired
    private CashDispenser cashDispenser;
    @Autowired
    private Display display;
    @Autowired
    private Teller teller;

    public void accountHasBeenCreditedWith(int amount) {
        account.credit(amount);
        assertAccountBalance(amount);
    }

    public void withdraw(int amount) {
        teller.authenticateAs(account);
        teller.withdraw(amount);
    }

    public void assertDispensed(int amount) {
        assertThat(cashDispenser.getDispensed()).isEqualTo(amount);
    }

    public void assertAccountBalance(int balance) {
        assertThat(account.getBalance()).isEqualTo(balance);
    }

    public void assertMessageShown(String expectedMessage) {
        verify(display).showMessage(expectedMessage);
    }
}
