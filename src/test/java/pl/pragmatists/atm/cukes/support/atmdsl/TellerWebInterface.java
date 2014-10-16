package pl.pragmatists.atm.cukes.support.atmdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriver;

@Component
@Scope("cucumber-glue")
public class TellerWebInterface implements TellerInterface {

    @Autowired
    private MockMvcHtmlUnitDriver driver;

    @Override
    public void withdraw(int amount) {
        driver.get("http://localhost/atm/main");
        driver.findElementById("amount").sendKeys(String.valueOf(amount));
        driver.findElementById("withdraw").click();
    }
}
