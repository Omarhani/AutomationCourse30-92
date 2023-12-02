package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;

    WebDriverWait wait;
    private final By loader = By.cssSelector(".ajax-loading-block-window");
    public MethodHandles (WebDriver driver){
        this.driver =driver;
    }
    protected void explicitWait(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }
    protected void invisibilityOf(By locator, int time){
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
        }catch (NoSuchElementException e){

        }

    }
    protected void scrollIntoElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        invisibilityOf(loader,20);
        explicitWait(locator,20);
        scrollIntoElement(driver, webElement(locator));
        webElement(locator).click();

    }

    protected void sendKeys(By locator,String text){
        invisibilityOf(loader,20);
        explicitWait(locator,20);
        scrollIntoElement(driver, webElement(locator));
        webElement(locator).sendKeys(text);

    }

}
