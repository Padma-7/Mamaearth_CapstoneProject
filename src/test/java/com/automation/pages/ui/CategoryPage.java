package com.automation.pages.ui;

public interface CategoryPage {
    default boolean isCategoryPageDisplayed(){return false;}

    default void selectIngredient(String ingredient){}

    default void selectProductUnderIngredient(String desiredProduct){}
}
