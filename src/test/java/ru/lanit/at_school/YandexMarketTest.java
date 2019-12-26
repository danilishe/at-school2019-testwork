package ru.lanit.at_school;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "ru.lanit.at_school",
        features = "src/test/resources/feature",
        tags = {"@start"}
)

public class YandexMarketTest extends AbstractTestNGCucumberTests {
}
