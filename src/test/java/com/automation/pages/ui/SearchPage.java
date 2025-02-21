package com.automation.pages.ui;

public interface SearchPage {
    boolean isTrendingSearchesDisplayed();

    void selectFromTrendingSearch(String desiredSearch);

    boolean isRecentlyViewedDisplayed();

    boolean isViewedProductPresent();
}
