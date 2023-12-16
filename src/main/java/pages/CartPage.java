package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CartPage extends MethodHandles {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By termsAndConditionsCheckBox = By.id("termsofservice");
    private final By checkOutButton = By.id("checkout");

    public void clickOnTermsAndConditionsCheckBox(){
        click(termsAndConditionsCheckBox);
    }
    public LoginPage clickCheckOutButton(){
        click(checkOutButton);
        return new LoginPage(driver);
    }
}
