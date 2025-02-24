package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.PaymentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebPaymentPage extends BasePage implements PaymentPage {

    @FindBy(id = "payment-heading")
    WebElement paymentPageHeading;

    @FindBy(xpath = "//div[@class=\"button-text\" and text()=\"Cash on Delivery\"]")
    WebElement cashOnDeliveryOption ;

    @FindBy(xpath = "//button[text()=\"PLACE ORDER\"]")
    WebElement placeOrderBtn ;

        @FindBy(xpath = "//div[@class=\"thankyoutext\"]")
        WebElement confirmationMsg ;


    public boolean isPaymentPageDisplayed(){
        return isDisplayed(paymentPageHeading);
    }

    public void selectCashOnDelivery(){
        cashOnDeliveryOption.click();
    }

    public void clickOnPlaceOrderBtn(){
        placeOrderBtn.click();
    }

    public boolean isConfirmationMsgDisplayed(){
        if(isDisplayed(confirmationMsg))
            return false;
        else
            return true;
    }

}
