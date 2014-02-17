package pl.pragmatists.atm;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report"}, strict=false)
public class RunCukesTest {

}
