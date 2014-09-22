package pl.pragmatists.atm;

public interface Teller {
    void authenticateAs(Account account);

    void withdraw(int amount);
}
