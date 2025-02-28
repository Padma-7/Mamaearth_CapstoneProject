package com.automation.pages.ui;

public interface HomePage {

    void openApplication();

    boolean isHomePageDisplayed();

    default void clickOnProfileIcon(){}

    default void clickOnLoginIcon(){}

    void searchForProduct(String desiredProduct);

    default void clickOnCategoryIcon(){}

    void clickOnChatBotIcon();

    default void clickOnIngredientCategory(){}

    default void selectDesiredIngredient(String ingredientOption){}

    default void clickOnAllProductsOption(){}


    default void clickOnCategory(String desiredCategory){}

    default void clickOnBabyCategory(){}

    default void selectManageAddressOption(){}

    void goToSpecificCategory(String category);

    void clickOnViewAllBtn();

    default void clickOnHomeIcon(){}

    void clickOnSearchBar();

    void clickOnCartIcon();
    void addSameProductToCart(int productNumber);
    void addToCartFirstItem();
    boolean isPopUpDisplayed();
    boolean verifyCartNumberShowsOne();
    void addProductToCart(int productNumber);

    boolean isCartNumberUpdated(int cartNumber);
    void removeProductFromCart();
    boolean isRemovedPopUpDisplayed();

    void userSelectFirstProductFromHomePage();
}
