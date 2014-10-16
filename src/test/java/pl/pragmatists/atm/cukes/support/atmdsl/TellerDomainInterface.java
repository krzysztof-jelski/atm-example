package pl.pragmatists.atm.cukes.support.atmdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pragmatists.atm.domain.Account;
import pl.pragmatists.atm.domain.Teller;

@Component
@Scope("cucumber-glue")
public class TellerDomainInterface implements TellerInterface {
    @Autowired
    private Account account;
    @Autowired
    private Teller teller;

    @Override
    public void withdraw(int amount) {
        teller.authenticateAs(account);
        teller.withdraw(amount);
    }

}
