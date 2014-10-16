package pl.pragmatists.atm.cukes.hooks;

import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.cukes.support.CukesSpringConfiguration;
import pl.pragmatists.atm.cukes.support.atmdsl.AtmInterfaceFactory;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class EnableWebHook {

    @Autowired
    public AtmInterfaceFactory atmInterfaceFactory;

    @Before("@web")
    public void enableWeb() {
        atmInterfaceFactory.webEnabled = true;
    }
}

