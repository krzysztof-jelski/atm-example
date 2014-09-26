package pl.pragmatists.atm.stepdefs;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.support.Banknote;
import pl.pragmatists.atm.support.CukesSpringConfiguration;
import pl.pragmatists.atm.transforms.MoneyConverter;

import java.util.List;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class BanknotesStepDefinitions {
    @Given("^Atm has banknotes:$")
    public void Atm_has_banknotes(@Transform(MoneyConverter.class) List<Banknote> banknotes) throws Throwable {
        System.out.println(">>>>>>>>>>>>>>>>>>" + banknotes.get(0).value.dollars);
    }
}
