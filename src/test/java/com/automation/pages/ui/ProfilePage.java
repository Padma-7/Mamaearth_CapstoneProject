package com.automation.pages.ui;

public interface ProfilePage {

    default boolean isProfilePageDisplayed(){return false;}

    default void clickLoginIcon(){}

    default boolean isLoginBtnNotDisplayed() {return false;}

    default void clickLogoutIcon(){}

    default boolean userLogoutSuccessful() {return false;}


    //new
    void clickOnEditProfile();

    void changeCredentials(String key,String Value);

    void saveChanges();

    boolean changesApplied(String key);
}
