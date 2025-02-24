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

    void clickOnCartIcon();

    void addSameProductToCart(String productNumber);

    void addToCartFirstItem();

    boolean isPopUpDisplayed();

    boolean verifyCartNumberShowsOne();

    void addProductToCart(String productNumber);

    boolean isCartNumberUpdated(String cartNumber);

    void removeProductFromCart();

    boolean isRemovedPopUpDisplayed();


    void userSelectFirstProductFromHomePage();
    void goToBabyCareProducts();
    void clickOnViewAllBtn();
    default void clickOnHomeIcon(){}
    void clickOnSearchBar();
}
