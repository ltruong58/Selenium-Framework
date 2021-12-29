
package tests;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@smoke"}
)
public class Remote extends AbstractTestNGCucumberTests{
    @BeforeClass
    public static void setup() {
        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
    }
}