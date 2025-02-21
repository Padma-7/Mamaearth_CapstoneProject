package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebSearchPage extends BasePage implements SearchPage {



    @FindBy(xpath = "//div[@class=\"trendingsearch-desktop\"]/button")
    List<WebElement> trendingSearchs;

    @FindBy(xpath = "//div[@class=\"heading-desktop\" and text()='Recently Viewed']")
    WebElement recentlySearched ;

    @FindBy(xpath = "//div[@class=\"heading-desktop\" and text()='Recently Viewed']/../following-sibling::div/div/div/div/div/div[2]/div/div/div[1]")
    List<WebElement> productsTitle;



    String XPATH_TRENDING_SEARCH = "//button[@class=\"sc-gpHHfC bbgIJc searchbar-dropdown\" and text()='%s']";

    public boolean isTrendingSearchesDisplayed(){
        System.out.println(trendingSearchs.size());
        return !trendingSearchs.isEmpty();
    }

    public   void selectFromTrendingSearch(String desiredSearch){
        driver.findElement(By.xpath(String.format(XPATH_TRENDING_SEARCH,desiredSearch))).click();
    }

    public  boolean isRecentlyViewedDisplayed(){
        return isDisplayed(recentlySearched);
    }

    public boolean isViewedProductPresent(){
       // System.out.println(ConfigReader.getConfigValue("viewed.product") +productsTitle.get(0).getText() );
        return ConfigReader.getConfigValue("viewed.product").equals(productsTitle.get(0).getText());

    }




}
