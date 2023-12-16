package checkOut;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.NoteBooksPage;

import static org.testng.Assert.assertEquals;

public class CheckOutTests extends BaseTests {

    @Test
    public void testCheckOutWithOutLogin() {
        homePage.hoverOverComputers();
        NoteBooksPage noteBooksPage = homePage.clickOnNoteBookLink();
        ItemPage itemPage = noteBooksPage.clickOnAddToCartButton();
        itemPage.clickOnAddToCardButton();
        itemPage.clickOnCloseButton();
        itemPage.hoverOverIconCart();
        CartPage cartPage = itemPage.clickOnGoToCartPage();
        cartPage.clickOnTermsAndConditionsCheckBox();
        LoginPage loginPage = cartPage.clickCheckOutButton();
        String actualResult  =loginPage.getLoginInValidation();
        String expectedResult = "Welcome, Please Sign In!";
        assertEquals(actualResult,expectedResult);

    }
}
