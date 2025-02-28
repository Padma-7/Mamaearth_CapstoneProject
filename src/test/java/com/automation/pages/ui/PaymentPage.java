package com.automation.pages.ui;

public interface PaymentPage {
    boolean isPaymentPageDisplayed();

     void selectCashOnDelivery();

    void clickOnPlaceOrderBtn();


    boolean isConfirmationMsgDisplayed();
}
