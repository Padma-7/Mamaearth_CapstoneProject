package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCartPage extends BasePage implements CartPage {

    @FindBy(xpath = "//div[@class=\"details-title\"]")
    WebElement cartPageTitle;

    @FindBy(xpath = "//div[@class='summary-items__container']")
    WebElement priceSummary ;

    @FindBy(xpath = "//div[text()='Proceed to pay']")
    WebElement proceedToPayBtn ;

    @FindBy(xpath = "//div[text()='Add address']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//div[text()='Add address'  and @class='proceed-text']")
    WebElement addAddressPageTitle;

    @FindBy(xpath = "//div[@class=\"item-quantity\"]")
    WebElement itemQuantity ;

    @FindBy(xpath = "//div[@class=\"qty-selector\"]/div[text()=\" + \"]")
    WebElement plusButton ;

    @FindBy(xpath="//div[text()='Your cart is empty !']")
    WebElement cartEmptyMessage;

    @FindBy(xpath="//button[text()='SHOP NOW']")
    WebElement shopNowButton ;
    @FindBy(xpath="//a[text()='Home']")
    WebElement homeTab;
    @FindBy(xpath="//div[@class=\"item-name\"]")
    WebElement productnameFromCart;



    public boolean isCartPageDisplayed(){
        return isDisplayed(cartPageTitle);
    }

    public boolean isPriceSummaryDisplayed(){
        return isDisplayed(priceSummary);
    }

    public void clickOnProceedToPay(){
        proceedToPayBtn.click();
    }

    public void clickOnAddAddressButton(){
        addAddressBtn.click();
    }

    @Override
    public void increaseTheQuantity(String quantity) {
        int requiredQuantity = Integer.parseInt(quantity);
        int currentQuantity = Integer.parseInt(itemQuantity.getText());

        for (int i = currentQuantity; i <= requiredQuantity; i++) {
            plusButton.click();
        }
    }

        public boolean isCartEmpty(){
            return isDisplayed(cartEmptyMessage);
        }
        public void goToHomePage(){
            if(isDisplayed(shopNowButton)) {
                shopNowButton.click();
            } else if (isDisplayed(homeTab)) {
                homeTab.click();
            }
        }
        public boolean isProductDisplayed(){
            return ((productnameFromCart.getText()).equals(ConfigReader.getConfigValue("productAddedToCart")));
        }

    }





