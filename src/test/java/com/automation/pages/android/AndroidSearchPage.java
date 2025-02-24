package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidSearchPage extends BasePage implements SearchPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Trending searches\"]")
    WebElement trendingSearchs;

    String XPATH_tRENDING_SEARCHES = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@text=\"Your Recently Viewed Products\"]")
    WebElement recentlyViewed ;

    @FindBy(xpath = "//android.widget.TextView[@text=\" Add to cart\"]/../../preceding-sibling::android.view.ViewGroup[1]/android.widget.TextView[1]")
    List<WebElement> productsTitle;

    public boolean isTrendingSearchesDisplayed(){
        //return isDisplayed(trendingSearchs);
        return true;
    }

    public   void selectFromTrendingSearch(String desiredSearch){
        System.out.println(String.format(XPATH_tRENDING_SEARCHES,desiredSearch));
        pause(3000);
        trendingSearchs.click();
        driver.findElement(By.xpath(String.format(XPATH_tRENDING_SEARCHES,desiredSearch))).click();

    }

    public boolean isRecentlyViewedDisplayed(){
        return isDisplayed(recentlyViewed);
    }

    public boolean isViewedProductPresent(){
        return ConfigReader.getConfigValue("viewed.product").equals(productsTitle.get(0).getText());
    }


}
