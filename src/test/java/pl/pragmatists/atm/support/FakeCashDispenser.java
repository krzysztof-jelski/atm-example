package pl.pragmatists.atm.support;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.domain.CashDispenser;

@Component
@Scope("cucumber-glue")
public class FakeCashDispenser implements CashDispenser {

    private int dispensed;

    @Override
    public int getDispensed() {
        return dispensed;
    }

    @Override
    public void dispense(int amount) {
        this.dispensed = amount;
    }

}
