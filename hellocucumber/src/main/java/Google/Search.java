package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Search {
    private final WebDriver driver;
    private final By searchBox = By.id("APjFqb");

    public Search(WebDriver driver){
        this.driver = driver;

    }
    public Search goTo(){
        driver.navigate().to("https://www.google.com.sa/");
        return this;
    }

    public Result searchKey(String search){
        driver.findElement(searchBox).sendKeys(search + Keys.RETURN);
        return new Result(driver);
    }

}
