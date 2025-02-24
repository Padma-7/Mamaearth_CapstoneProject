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

    default void clickOnFirstItem(){}

    default void addToCartFirstItem(){}

    default void selectBabyBodyLotion(){}

    default void selectFirstItem(){}

    boolean isProductsTitleWithKeyword(String keyword);

    boolean isCountEqualsTotalProducts();


}
