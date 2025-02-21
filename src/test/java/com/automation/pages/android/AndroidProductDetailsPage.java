package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProductDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProductDetailsPage extends BasePage implements ProductDetailsPage {


    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")
    WebElement productTitle;

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
    WebElement addToCartBtn ;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    WebElement cancelBtn ;

    @FindBy(xpath = "//android.widget.TextView[@text=\"VIEW CART\"]\n")
    WebElement viewCartBtn;




    @Override
    public boolean isTitleWithKeyword(String keyword){
        return productTitle.getText().toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public void ClickOnAddToCartBtn(){
        addToCartBtn.click();
       // cancelBtn.click();
    }

    @Override
    public void clickOnCartIcon(){
        viewCartBtn.click();
    }
}
