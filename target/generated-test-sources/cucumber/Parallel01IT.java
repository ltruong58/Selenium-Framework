import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"C:/Users/LongTruong/IdeaProjects/connect-autotest/src/test/resources/features/Login.feature"},
        plugin = {"json:C:/Users/LongTruong/IdeaProjects/connect-autotest/target/cucumber-parallel/1.json"},
        monochrome = false,
        tags = {"@smoke", "~@regression", "~@ignore"},
        glue = {"com.example", "com.example.other", "steps"})
public class Parallel01IT extends AbstractTestNGCucumberTests {
}
