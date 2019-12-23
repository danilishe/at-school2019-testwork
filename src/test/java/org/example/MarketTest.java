package org.example;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        glue = {"org.example.steps"},
        features = "src/test/resources/feature"
)

public class MarketTest extends AbstractTestNGCucumberTests {
}
