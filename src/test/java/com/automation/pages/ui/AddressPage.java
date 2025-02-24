package com.automation.pages.ui;

public interface AddressPage {
    boolean isAddressPageDisplayed();

    void fillAddressDetails();

    void selectAddressType(String addressType);

    void clickOnSaveAddressButton();

    boolean isAddressSaved();

     void clickOnAddAddressButton();

    boolean isAddressFillingPageDisplayed();

    boolean isAddressAdded();

    default void fillInvalidAddress(){}
}
