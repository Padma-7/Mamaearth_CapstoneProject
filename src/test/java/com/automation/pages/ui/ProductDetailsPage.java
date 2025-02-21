package com.automation.pages.ui;

public interface ProductDetailsPage {
    boolean isTitleWithKeyword(String keyword);

    void ClickOnAddToCartBtn();

    void clickOnCartIcon();

    default boolean isProductDetailsPageDisplayed() {
        return false;
    }
}
