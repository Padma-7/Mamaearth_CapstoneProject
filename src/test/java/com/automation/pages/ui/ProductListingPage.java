package com.automation.pages.ui;

public interface ProductListingPage {
    boolean isProductListingPageDisplayed();

    void clickOnFirstProductWithKeyword(String keyword);

    void clickOnSortIcon();

    void selectLowToHighOption();

    boolean isSortedLowToHigh();

    void selectHighToLowOption();

     boolean isSortedHighToLow();

    void selectByRateOption();

  boolean isSortedByRatings();

    boolean isSearchResultFound(String product);

    boolean isInvalidMessageDisplayed();

     void clickOnFirstItem();

    default void addToCartFirstItem(){}

    default void selectBabyBodyLotion(){}


    boolean isProductsTitleWithKeyword(String keyword);

    boolean isCountEqualsTotalProducts();


}
