package com.fidelity.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html"
        },
        features = {
                "src/test/resources"
        },
        glue = "com/fidelity/step_definitions",
        tags = "@regression"
)
public class CucumberRunner {

}
