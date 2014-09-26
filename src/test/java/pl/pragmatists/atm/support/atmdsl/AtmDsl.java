package pl.pragmatists.atm.support.atmdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@Component
@Scope("cucumber-glue")
public class AtmDsl {

    @Autowired
    private CashDispenser cashDispenser;
    @Autowired
    private Display display;


    public void assertDispensed(int amount) {
        assertThat(cashDispenser.getDispensed()).isEqualTo(amount);
    }

    public void assertMessageShown(String expectedMessage) {
        verify(display).showMessage(expectedMessage);
    }
}
