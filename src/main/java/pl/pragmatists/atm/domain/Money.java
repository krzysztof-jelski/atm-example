package pl.pragmatists.atm.domain;

public class Money {
    public final int dollars;
    public final int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }
}
