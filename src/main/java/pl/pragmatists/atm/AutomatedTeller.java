package pl.pragmatists.atm;

public class AutomatedTeller implements Teller {

    private CashDispenser cashDispenser;
    private Display display;
    private Account account;

    public AutomatedTeller(CashDispenser cashDispenser, Display display) {
        this.cashDispenser = cashDispenser;
        this.display = display;
    }

    @Override
    public void authenticateAs(Account account) {
        this.account = account;
    }

    @Override
    public void withdraw(int amount) {
        if (account.getBalance() < amount) {
            display.showMessage("Insufficient funds");
            return;
        }
        account.withdraw(amount);
        cashDispenser.dispense(amount);
    }

}
