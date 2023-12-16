package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;

    WebDriverWait wait;
    Actions actions;
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
            wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(driver.findElement(locator)),
                    ExpectedConditions.invisibilityOf(driver.findElement(locator))));
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
        for (int i = 0 ;i<10;i++){
            try {
                invisibilityOf(loader,20);
                explicitWait(locator,20);
//                scrollIntoElement(driver,webElement(locator));
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException |ElementNotInteractableException e){

            }
        }
    }

    protected void sendKeys(By locator,String text){
        invisibilityOf(loader,20);
        explicitWait(locator,20);
        scrollIntoElement(driver, webElement(locator));
        webElement(locator).sendKeys(text);

    }
    protected String  getText(By locator){
        invisibilityOf(loader,20);
        explicitWait(locator,20);
        scrollIntoElement(driver, webElement(locator));
        return webElement(locator).getText();

    }
    protected void hoverOverElement(By locator){
        actions = new Actions(driver);
        actions.moveToElement(webElement(locator)).build().perform();
    }

}
