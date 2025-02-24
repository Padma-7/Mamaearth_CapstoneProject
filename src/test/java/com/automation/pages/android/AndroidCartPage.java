package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCartPage extends BasePage implements CartPage {
    @FindBy(xpath="//android.widget.TextView[@text='View cart']/..")
    WebElement viewCartTab;

    @FindBy(xpath="//android.widget.TextView[@text=\"Cart details\"]/following-sibling::android.widget.TextView[5]")
        WebElement productnameFromCart ;

    @FindBy(xpath="//android.widget.TextView[@text=\"Mamaearth\"]")
        WebElement homePage ;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Your cart\"]")
    WebElement cartPageTitle;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Price Summary\"]/..")
    WebElement priceSummary ;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Add address\"]\n")
    WebElement addAddressBtn ;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Proceed to pay\"]")
    WebElement proceedToPayBtn ;

    public boolean isCartPageDisplayed(){
        return isDisplayed(cartPageTitle) || isDisplayed(addAddressBtn);
    }
    public boolean isPriceSummaryDisplayed(){
        while(!isDisplayed(priceSummary)){
            scrollPage();
        }
        scrollPage();
        return isDisplayed(priceSummary);
    }
    public void clickOnProceedToPay(){
        proceedToPayBtn.click();
    }
    public void clickOnAddAddressButton() {
        addAddressBtn.click();
    }


    public boolean isCartEmpty() {
        return !isDisplayed(viewCartTab);
    }

    public void goToHomePage(){
        homePage.click();
    }


    public boolean isProductDisplayed(){
        return ((productnameFromCart.getText()).equals(ConfigReader.getConfigValue("productAddedToCart")));
    }


}
