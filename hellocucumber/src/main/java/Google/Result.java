package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Result {
    private  final WebDriver driver;
    private  final By resultState = By.id("result-stats");
    public Result(WebDriver driver){
        this.driver = driver;
    }

    public String queryResult(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> !driver.findElement(resultState).getText().isEmpty());
        return driver.findElement(resultState).getText();

    }


}
