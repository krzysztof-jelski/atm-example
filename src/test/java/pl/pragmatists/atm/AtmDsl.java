package pl.pragmatists.atm;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

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
