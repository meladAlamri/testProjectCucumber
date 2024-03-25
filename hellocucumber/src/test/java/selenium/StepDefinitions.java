package selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    WebDriver driver;

    @Given("my browser is open")
    public void my_browser_is_open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I navigate to google")
    public void i_navigate_to_google() {
        driver.navigate().to("https://www.google.com.sa/");
    }

    @And("I search for selenium webdriver")
    public void i_search_for_selenium_webdriver() {
        By searchBox = By.id("APjFqb");
        driver.findElement(searchBox).sendKeys("selenium webdriver");
        driver.findElement(searchBox).submit();
    }

    @Then("result should not be emitter")
    public void result_should_not_be_emitter() {
        By resultState = By.id("result-stats");
        String actualText = driver.findElement(resultState).getText();
        Assertions.assertNotEquals("", actualText);
        driver.quit();
    }

   /* @After
    public void after(){
        driver.quit();
    }*/
}
