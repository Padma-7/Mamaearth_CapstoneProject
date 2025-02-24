package com.automation.pages.ui;

public interface CartPage {

    boolean isCartPageDisplayed();

    boolean isPriceSummaryDisplayed();

    void clickOnProceedToPay();

    void clickOnAddAddressButton();

    default void increaseTheQuantity(String quantity){}

    boolean isCartEmpty();

    void goToHomePage();

    boolean isProductDisplayed();

    default boolean isRecentlyViewedDisplayed(){return false;}

    default boolean isViewedProductPresent(){return false;}
}
