package pl.pragmatists.atm;

public class Teller {

    private CashDispenser cashDispenser;
    private Display display;
    private Account account;

    public Teller(CashDispenser cashDispenser, Display display) {
        this.cashDispenser = cashDispenser;
        this.display = display;
    }

    public void authenticateAs(Account account) {
        this.account = account;
    }

    public void withdraw(int amount) {
        if (account.getBalance() < amount) {
            display.showMessage("Insufficient funds");
            return;
        }
        account.withdraw(amount);
        cashDispenser.dispense(amount);
    }

}
