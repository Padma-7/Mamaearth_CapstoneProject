package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHomePage extends BasePage implements HomePage {

    @FindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    WebElement dontAllow;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search\"]\n")
    WebElement searchBar ;

    @FindBy(xpath = "//android.widget.EditText[@text='Search by keywords']")
    WebElement searchBarInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Profile']")
    WebElement profileIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Category']")
    WebElement categoryIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Chat']")
    WebElement chatTab;

    @FindBy(xpath = "(//com.horcrux.svg.SvgView/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
    WebElement cartQty;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[3]")
    WebElement plusIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Add to cart']")
    List<WebElement> addToCart;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]")
    WebElement minusIcon;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Add to cart\"]/../..")
    WebElement firstPdtHome;

    String specificCategoryXpath = "//android.widget.TextView[@text='%s']";


    @Override
    public void openApplication() {
        if (isDisplayed(dontAllow)) {
            dontAllow.click();
        }
        pause(3000);
    }

    @Override
    public boolean isHomePageDisplayed() {
        handleSplashScreen();
        return isDisplayed(searchBar);
    }

    @Override
    public void clickOnProfileIcon() {
        handleSplashScreen();
        profileIcon.click();
    }

    @Override
    public void searchForProduct(String desiredProduct) {
        handleSplashScreen();
        searchBar.click();
        pause(2000);
        searchBarInput.sendKeys(desiredProduct);
    }

    @Override
    public void clickOnCategoryIcon() {
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
    public void goToSpecificCategory(String category){

        driver.findElement(By.xpath(String.format(specificCategoryXpath,category))).click();

    }

    public void clickOnViewAllBtn(){



    }

    public void clickOnSearchBar(){
        searchBar.click();
    }

    public void clickOnCartIcon() {


    }

    public void addSameProductToCart(int productNumber) {



        for (int i = 0; i < productNumber; i++) {

            plusIcon.click();

            pause(2000);

        }


    }

    public void addToCartFirstItem() {
        firstPdtHome.click();
    }

    public boolean isPopUpDisplayed() {

        return false;

    }

    public boolean verifyCartNumberShowsOne() {

        int n = Integer.parseInt(cartQty.getText());

        ConfigReader.setConfigValue("cartQtyNumber", cartQty.getText());

        return n == 1;

    }

    public void addProductToCart(int productNumber) {



        for (int i = 0; i < productNumber; i++) {

            addToCart.getFirst().click();

        }

    }

    public boolean isCartNumberUpdated(int cartNumber) {

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


