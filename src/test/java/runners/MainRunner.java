package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        monochrome = true, dryRun = false, tags = "@login", plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
// dryRun false - help to know if there are any step NOT defined
// tags can help us to target some specific feature to run
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
