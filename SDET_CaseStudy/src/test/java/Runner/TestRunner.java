package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src\\test\\resources\\Login\\Login.feature",
glue= {"StepDefinition"},
monochrome=true,
dryRun=false,
plugin= {"html:testoutput/CaseStudyReport.html","junit:testoutput/CaseStudyReport.xml","json:testoutput/CaseStudyReport.json"})

public class TestRunner {

}
