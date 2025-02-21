package com.automation.pages.ui;

public interface ProfilePage {

    default boolean isProfilePageDisplayed(){return false;}

    default void clickLoginIcon(){}

    default boolean isLoginBtnNotDisplayed() {return false;}

    default void clickLogoutIcon(){}

    default boolean userLogoutSuccessful() {return false;}

    default void selectAddresses(){}
}
