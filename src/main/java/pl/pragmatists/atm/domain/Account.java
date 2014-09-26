package pl.pragmatists.atm.domain;

public class Account {

    private int balance;
    @SuppressWarnings("unused")
    private Long number;

    public Account(Long number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int toWithdraw) {
        balance -= toWithdraw;
    }

    public void credit(int amount) {
        this.balance += amount;
    }
}
