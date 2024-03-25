package homework;

import engine.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    protected WebDriver driver = new ChromeDriver();
    String path = System.getProperty("user.home") + "/IdeaProjects/testProjectCucumber/hellocucumber/src/main/resources/configuration.properties";

    @Given("user goes to the {string}")
    public void userGoesToThe(String url) {
        PropertiesReader.readPropertyFile(path);
        driver.navigate().to(PropertiesReader.props.getProperty(url));
    }

    @Then("user waits for {int} seconds")
    public void userWaitsForSeconds(int time) throws InterruptedException {
        Thread.sleep((time * 1000L));
    }

    @And("verifies that the page title contains the word {string}")
    public void verifiesThatThePageTitleContainsTheWord(String title) {
        Assertions.assertTrue(driver.getTitle().contains(title));
    }

    @And("closes the page")
    public void closesThePage() {
        driver.quit();
    }

}

