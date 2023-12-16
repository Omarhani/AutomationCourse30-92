package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ItemPage extends MethodHandles {
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    private final By addToCartButton = By.id("add-to-cart-button-4");

    private final By closeButton = By.cssSelector(".close");

    private final By iconCart = By.cssSelector(".ico-cart");

    private final By goToCartButton = By.cssSelector(".button-1.cart-button");

    public void clickOnAddToCardButton (){
        click(addToCartButton);
    }
    public void clickOnCloseButton(){
        click(closeButton);
    }
    public void hoverOverIconCart(){
        hoverOverElement(iconCart);
    }
    public CartPage clickOnGoToCartPage(){
        click(goToCartButton);
            return new CartPage(driver);
    }
}
