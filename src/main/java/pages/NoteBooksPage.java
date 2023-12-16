package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NoteBooksPage extends MethodHandles {
    public NoteBooksPage(WebDriver driver) {
        super(driver);
    }
    private final By addToCartButton = By.cssSelector(".button-2.product-box-add-to-cart-button");

    public ItemPage clickOnAddToCartButton(){
        click(addToCartButton);
        return new ItemPage(driver);
    }
}
