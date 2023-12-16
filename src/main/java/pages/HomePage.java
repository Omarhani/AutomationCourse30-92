package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;


public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By loginLink = By.cssSelector(".ico-login");

    private final By computersLink = By.partialLinkText("Computers");
    private final By noteBookLink =
            By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']");


    public LoginPage clickOnLoginLink(){
        click(loginLink);
        return new LoginPage(driver);
    }
    public void hoverOverComputers(){
        hoverOverElement(computersLink);
    }
    public NoteBooksPage clickOnNoteBookLink(){
        click(noteBookLink);
        return new NoteBooksPage(driver);
    }
}
