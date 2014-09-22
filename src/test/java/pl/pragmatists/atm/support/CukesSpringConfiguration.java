package pl.pragmatists.atm.support;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import pl.pragmatists.atm.AutomatedTeller;
import pl.pragmatists.atm.CashDispenser;
import pl.pragmatists.atm.Display;
import pl.pragmatists.atm.Teller;

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
    public Teller getTeller() {
        return new AutomatedTeller(context.getBean(CashDispenser.class), context.getBean(Display.class));
    }
}
