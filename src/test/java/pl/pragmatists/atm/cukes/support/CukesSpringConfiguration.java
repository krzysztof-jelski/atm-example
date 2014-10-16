package pl.pragmatists.atm.cukes.support;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriver;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.domain.AutomatedTeller;
import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.domain.Teller;

@Configuration
@ComponentScan(basePackages = {"pl.pragmatists.atm.cukes"})
@ImportResource("classpath:cucumber/runtime/java/spring/cucumber-glue.xml") // defines 'cucumber-glue' (scenario) scope
@Import({AccountFactory.class, Application.class})
public class CukesSpringConfiguration {

    @Autowired
    private WebApplicationContext context;

    @Bean
    @Scope("cucumber-glue")
    public Display createDisplay() {
        return Mockito.mock(Display.class);
    }

    @Bean
    @Scope("cucumber-glue")
    public Teller createTeller() {
        return new AutomatedTeller(context.getBean(CashDispenser.class), context.getBean(Display.class));
    }

    @Bean
    public MockMvcHtmlUnitDriver createDriver() {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        return new MockMvcHtmlUnitDriver(mockMvc, true);
    }
}
