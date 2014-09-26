package pl.pragmatists.atm.domain;

public interface CashDispenser {

    int getDispensed();

    void dispense(int amount);

}