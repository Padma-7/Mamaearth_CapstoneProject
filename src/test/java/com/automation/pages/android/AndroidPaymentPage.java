package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.PaymentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidPaymentPage extends BasePage implements PaymentPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Payment Options\"]")
    WebElement paymentPageHeading;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Net banking\"]")
    WebElement netBankingOption;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Cash on delivery (COD)\"]")
    WebElement cashOnDeliveryOption;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Pay via Cash')]")
    WebElement payViaCash;

    @FindBy(xpath = "//android.widget.TextView[@text='Thank you, your order has been placed!!']")
    WebElement confirmationMsg;


    public boolean isPaymentPageDisplayed() {
        return isDisplayed(paymentPageHeading) && isDisplayed(netBankingOption);
    }

    @Override
    public void selectCashOnDelivery() {
        cashOnDeliveryOption.click();

    }

    @Override
    public void clickOnPlaceOrderBtn() {
        payViaCash.click();
    }

    @Override
    public boolean isConfirmationMsgDisplayed() {
        pause(5000);
        return isDisplayed(confirmationMsg);
    }
}
