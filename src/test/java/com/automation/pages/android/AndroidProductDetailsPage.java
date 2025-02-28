package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProductDetailsPage;
import com.automation.utils.ConfigReader;
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

    @FindBy(xpath="(//android.widget.TextView[@text='Add to cart'])[1]")
    WebElement addToCartBtn1;

    @FindBy(xpath="(//com.horcrux.svg.PathView)[1]")
        WebElement backBtn ;

    @FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
        WebElement productAddToCart;

    @FindBy(xpath="(//com.horcrux.svg.SvgView/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
    WebElement cartQty;

    @FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")
        WebElement productName;

    @FindBy(xpath="(//com.horcrux.svg.PathView)[3]")
        WebElement cartIcon ;

    @FindBy(xpath="(//com.horcrux.svg.PathView)[2]")
    WebElement profileIcon ;

    @FindBy(xpath="//android.widget.TextView[@text=\"Recommendations for you\"]/../preceding-sibling::android.view.ViewGroup")
        WebElement closeBtn;



    @Override
    public boolean isTitleWithKeyword(String keyword){
        ConfigReader.setConfigValue("viewed.product", productTitle.getText());

        return productTitle.getText().toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public void ClickOnAddToCartBtn(){
        addToCartBtn.click();
        // cancelBtn.click();
    }


    public void clickOnBackButton(){
        backBtn.click();
    }

    public void clickOnProductAddToCartBtn(){
        pause(2000);
        productAddToCart.click();
        if (isDisplayed(closeBtn)) {
            closeBtn.click();

        }
    }

    public boolean HasCartQtyIncreased(int number){

        System.out.println(number+":numberInt");
        pause(3000);
        System.out.println(cartQty.getText());
        int cartQtyIntNow=Integer.parseInt(cartQty.getText());
        System.out.println(cartQtyIntNow+":cartQtyIntNow");
        int cartQtyNumber= ConfigReader.getIntConfigValue("cartQtyNumber");
        if (cartQtyNumber+number==cartQtyIntNow){
            ConfigReader.setConfigValue("cartQtyNumber",cartQty.getText());
            return true;

        }
        else{
            return false;
        }

    }

    public boolean HasCartQtyDecreased(){
        System.out.println(cartQty.getText());
        int cartQtyIntNow=Integer.parseInt(cartQty.getText());
        int cartQtyNumber= ConfigReader.getIntConfigValue("cartQtyNumber");
        if (cartQtyNumber-1==cartQtyIntNow){
            ConfigReader.setConfigValue("cartQtyNumber",cartQty.getText());
            return true;

        }
        else{
            return false;
        }


    }




    @Override
    public String getProductName(){
        System.out.println(productName.getText());
        return productName.getText();
    }

    @Override
    public void clickOnCartIcon(){
        pause(2000);
        if(isDisplayed(cartIcon)){
            cartIcon.click();
        } else if (isDisplayed(viewCartBtn)) {
            viewCartBtn.click();
        }

    }

    public void ClickOnAddToCartBtn1(){}

    public void clickOnProfileIcon(){
        profileIcon.click();
    }
}

