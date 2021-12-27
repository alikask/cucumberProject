package testRunner;
import java.nio.file.Files;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "Features//cucumber.feature",
        glue = "stepDefinitions",
        publish = true,
        plugin = {"pretty"
        ,"html:target/cucumber-reports/report.html"
        ,"json:target/cucumber-reports/report.json"
        ,"usage:target/cucumber_usage.json"
}
)


public class testRunner {

}

