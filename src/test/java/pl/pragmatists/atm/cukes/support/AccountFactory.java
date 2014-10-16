package pl.pragmatists.atm.cukes.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.pragmatists.atm.domain.Account;

@Configuration
public class AccountFactory {

    private static final Long SOME_ID = 11324L;

    @Scope("cucumber-glue")
    @Bean
    public Account createAccount() {
        return new Account(SOME_ID);
    }
}
