package com.automation.pages.ui;

public interface PaymentPage {
    boolean isPaymentPageDisplayed();

    default void selectCashOnDelivery(){}

    default void clickOnPlaceOrderBtn(){}


    default boolean isConfirmationMsgDisplayed(){return false;}
}
