package pl.pragmatists.atm.support;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import pl.pragmatists.atm.domain.AutomatedTeller;
import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.domain.Teller;

@Configuration
@ComponentScan(basePackages = {"pl.pragmatists.atm"})
@ImportResource("classpath:cucumber/runtime/java/spring/cucumber-glue.xml") // defines 'cucumber-glue' (scenario) scope
@Import(AccountFactory.class)
public class CukesSpringConfiguration {

    @Autowired
    private ApplicationContext context;

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
}
