package org.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        glue = {"org.example.steps"},
        features = "src/test/resources/feature"
//        tags = {"@subcategory"}
)

public class MarketTest extends AbstractTestNGCucumberTests {
}
