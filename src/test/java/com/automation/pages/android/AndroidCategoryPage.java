package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidCategoryPage extends BasePage implements CategoryPage {

    @FindBy(xpath = "//android.widget.TextView[@text='INGREDIENTS']")
    WebElement ingredients;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    List<WebElement> ingredientsoptions ;

String XPATH_INGREDIENTS = "//android.widget.TextView[@text='%s']";
String XPATH_INGREDIENTS_OPTIONS = "//android.widget.TextView[@text='%s']";

    public boolean isCategoryPageDisplayed(){
        return isDisplayed(ingredients);
    }

    @Override
    public void selectIngredient(String ingredient) {
        while (!isDisplayed(XPATH_INGREDIENTS, ingredient)) {
            scrollPage();
        }
        WebElement targetElement = driver.findElement(By.xpath(String.format(XPATH_INGREDIENTS, ingredient)));
        targetElement.click();

    }

    @Override
    public void selectProductUnderIngredient(String desiredProduct){
        WebElement productName = driver.findElement(By.xpath(String.format(XPATH_INGREDIENTS_OPTIONS,desiredProduct)));
        productName.click();
    }

}
