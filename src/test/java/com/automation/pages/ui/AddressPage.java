package com.automation.pages.ui;

public interface AddressPage {
    boolean isAddressPageDisplayed();

    void fillAddressDetails();

    void selectAddressType(String addressType);

    void clickOnSaveAddressButton();

    boolean isAddressSaved();

    default void clickOnAddAddressButton(){}

    default boolean isAddressFillingPageDisplayed(){return false;}

    default boolean isAddressAdded(){return false;}}
