package Runner;

import Base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions (
        features = "src/test/resources/feature/FeatureStory.feature",
        glue = "Steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/RunnerTest.html",
                "json:target/cucumber-reports/RunnerTest.json",
                // "junit:target/cucumber-reports/cucumber.xml"
        }

)
@Test
public class RunnerTest extends AbstractTestNGCucumberTests {
    //Parallel Execution Scenario
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
