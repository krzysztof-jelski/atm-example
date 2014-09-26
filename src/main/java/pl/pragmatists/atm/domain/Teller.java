package pl.pragmatists.atm.domain;

public interface Teller {
    void authenticateAs(Account account);

    void withdraw(int amount);
}
