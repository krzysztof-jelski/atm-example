package pl.pragmatists.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"pl.pragmatists.atm"})
@ImportResource("classpath:cucumber/runtime/java/spring/cucumber-glue.xml") // defines 'cucumber-glue' (scenario) scope
public class CukesSpringConfiguration {
}
