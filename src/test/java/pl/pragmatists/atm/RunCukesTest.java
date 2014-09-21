package pl.pragmatists.atm;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report"}, strict = false, tags = {"@wip"})
public class RunCukesTest {

}
