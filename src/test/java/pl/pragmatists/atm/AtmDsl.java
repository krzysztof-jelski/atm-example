package pl.pragmatists.atm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.support.FakeCashDispenser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Component
@Scope("cucumber-glue")
public class AtmDsl {

    private Account account;
    private FakeCashDispenser cashDispenser = new FakeCashDispenser();
    private Display display = mock(Display.class);

    public void accountHasBeenCreditedWith(int amount) {
        account = new Account(amount);
    }

    public void withdraw(int amount) {
        Teller teller = new Teller(cashDispenser, display);
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
