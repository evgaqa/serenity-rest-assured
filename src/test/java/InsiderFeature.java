import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "com.useinsider.bddtests.stepdefinitions",
        features = "src/test/resources/insider.feature"
)
public class InsiderFeature {
}