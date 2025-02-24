package com.automation.pages.ui;

public interface LoginPage {

    default void clickOnLoginIcon(){}

    boolean isLoginPageDisplayed();

    void enterPhoneNumber(String phoneNumber);

    default void clickOnLoginWithOTPBtn(){}

    boolean isErrorMessageDisplayed();

    default boolean isPhoneNumberDisplayed(){return false;}

    default void clickOnLogoutLink(){}

    default boolean isLoggedOut(){return false;}

    void enterOTP();

    boolean isOTPDetailsPageDisplayed();

    default void clickOnContinueBtn(){}
}
