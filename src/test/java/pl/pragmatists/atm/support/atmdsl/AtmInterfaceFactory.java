package pl.pragmatists.atm.support.atmdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class AtmInterfaceFactory {


    @Autowired
    private TellerDomainInterface tellerDomainInterface;
    @Autowired
    private TellerWebInterface tellerWebInterface;
    public boolean webEnabled = false;

    public TellerInterface getTellerInterface() {
        if (webEnabled)
            return tellerWebInterface;
        return tellerDomainInterface;
    }
}
