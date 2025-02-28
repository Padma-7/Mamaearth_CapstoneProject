package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProductDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebProductDetailsPage extends BasePage implements ProductDetailsPage {

    @FindBy(xpath = "//span[@class=\"addTocart_pdp\"]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h1[@class=\"product-name\"]")
    WebElement productTitle ;

    @FindBy(xpath ="//div[text()='Cart']")
    WebElement cartIcon ;



    @Override
    public boolean isTitleWithKeyword(String keyword){
        ConfigReader.setConfigValue("product.name", productTitle.getText());
        return productTitle.getText().toLowerCase().contains(keyword.toLowerCase());

    }

    @Override
    public void ClickOnAddToCartBtn(){
        addToCartBtn.click();
    }


    public boolean isProductDetailsPageDisplayed() {
        return isDisplayed(addToCartBtn);
    }

    @Override
    public void ClickOnAddToCartBtn1() {
        addToCartBtn.click();
    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }

    public void clickOnProductAddToCartBtn(){
        addToCartBtn.click();
    }


}
