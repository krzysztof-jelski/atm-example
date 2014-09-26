package pl.pragmatists.atm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/cucumber-html-report"},
        strict = true,
        tags = {"@wip", "~@slow"})
public class RunCukesTest {

}
