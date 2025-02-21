package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHomePage extends BasePage implements HomePage {

    @FindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    WebElement dontAllow;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search\"]\n")
    WebElement searchBar ;

    @FindBy(xpath="//android.widget.EditText[@text='Search by keywords']")
    WebElement searchBarInput;

    @FindBy(xpath="//android.widget.TextView[@text='Profile']")
    WebElement profileIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Category']")
    WebElement categoryIcon ;


    @FindBy(xpath="//android.widget.TextView[@text='Chat']")
    WebElement chatTab;

    @FindBy(xpath = "(//com.horcrux.svg.SvgView/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
    WebElement cartQty;
    @FindBy(xpath = "(//com.horcrux.svg.SvgView)[5]")
    WebElement plusIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Add to cart']")
    List<WebElement> addToCart;
    @FindBy(xpath = "(//com.horcrux.svg.SvgView)[4]")
    WebElement minusIcon;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Add to cart\"]/../..")
    WebElement firstPdtHome;


    @Override
    public void openApplication() {
        if(isDisplayed(dontAllow))
        {
            dontAllow.click();
        }
        pause(5000);
    }

    @Override
    public boolean isHomePageDisplayed() {
        pause(5000);
        return isDisplayed(profileIcon);
    }

    @Override
    public void clickOnProfileIcon() {
        profileIcon.click();
    }

    @Override
    public void searchForProduct(String desiredProduct){
       searchBar.click();
       pause(3000);
       searchBarInput.sendKeys(desiredProduct);

    }

    @Override
    public void clickOnCategoryIcon(){
        categoryIcon.click();
    }

    @Override
    public void clickOnChatBotIcon() {
        profileIcon.click();
        pause(3000);
        scrollPage();
        chatTab.click();
    }

    @Override
    public void goToBabyCareProducts(){

    }

    public void clickOnViewAllBtn(){

    }

    public void clickOnSearchBar(){
        searchBar.click();
    }

    public void clickOnCartIcon() {


    }

    public void addSameProductToCart(String productNumber) {

        int n = Integer.parseInt(productNumber);

        for (int i = 0; i < n; i++) {

            plusIcon.click();

            pause(2000);

        }


    }

    public void addToCartFirstItem() {

    }

    public boolean isPopUpDisplayed() {

        return false;

    }

    public boolean verifyCartNumberShowsOne() {

        int n = Integer.parseInt(cartQty.getText());

        ConfigReader.setConfigValue("cartQtyNumber", cartQty.getText());

        return n == 1;

    }

    public void addProductToCart(String productNumber) {

        int productNumberInt = Integer.parseInt(productNumber);

        for (int i = 0; i < productNumberInt; i++) {

            addToCart.get(1).click();

            scrollPage();

        }

    }

    public boolean isCartNumberUpdated(String cartNumber) {

        return true;

    }

    public void removeProductFromCart() {

        minusIcon.click();

    }

    public boolean isRemovedPopUpDisplayed() {

        return false;

    }

    public void userSelectFirstProductFromHomePage() {

        firstPdtHome.click();

    }



}


