package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HeaderAndFooter extends MethodHandles {

    public HeaderAndFooter(WebDriver driver) {
        super(driver);
    }
    private final By loginLink = By.cssSelector(".ico-login");

    public LoginPage clickOnLoginLink(){
        click(loginLink);
        return new LoginPage(driver);
    }
}
