package pl.pragmatists.atm.cukes.transforms;

import cucumber.api.Transformer;
import pl.pragmatists.atm.domain.Money;

public class MoneyConverter extends Transformer<Money> {
    @Override
    public Money transform(String value) {
        String[] parts = value.split("\\.");
        int dollars = Integer.valueOf(parts[0]);
        int cents = Integer.valueOf(parts[1]);
        return new Money(dollars, cents);
    }
}
