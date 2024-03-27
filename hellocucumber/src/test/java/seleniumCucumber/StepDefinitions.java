package seleniumCucumber;

import Google.Search;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    WebDriver driver;
    Search search;
    String actualText;

    @Given("my browser is open")
    public void myBrowserIsOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @When("I navigate to google")
    public void i_navigate_to_google() {
        search = new Search(driver).goTo();
    }

    @And("I search for {string}")
    public void i_search_for_selenium_webdriver(String query) {
        actualText = search.searchKey(query).queryResult();
    }

    @Then("result should not be emitter")
    public void result_should_not_be_emitter() {

        Assertions.assertNotEquals("", actualText);
    }


   /* @Before
    public void myBrowserIsOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/

   @After
    public void after(Scenario scenario){
       if (scenario.isFailed()){
           byte [] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenShot, "image/png","screenShot-"+System.currentTimeMillis());
       }
        driver.quit();
    }

    @When("I search for something")
    public void iNavigateForSomething() {
       actualText = new Search(driver)
               .goTo()
               .searchKey("selenium webdriver")
               .queryResult();
    }
}
