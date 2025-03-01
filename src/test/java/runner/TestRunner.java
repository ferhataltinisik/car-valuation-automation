package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features", // Path to feature files
        glue = "stepdefinitions",           // Package of step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Report plugins
        monochrome = true                   // Make console output more readable

)
public class TestRunner extends AbstractTestNGCucumberTests {
}