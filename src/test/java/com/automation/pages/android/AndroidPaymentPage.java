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



    public boolean isPaymentPageDisplayed() {
        return isDisplayed(paymentPageHeading) && isDisplayed(netBankingOption);
    }
}
