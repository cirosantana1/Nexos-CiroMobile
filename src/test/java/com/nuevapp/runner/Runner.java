package com.nuevapp.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@FeatureUno",
        features = "src/test/resources/Features",
        glue = {"com.nuevapp.stepdefinitions", "com.nuevapp.utils"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner {
}
