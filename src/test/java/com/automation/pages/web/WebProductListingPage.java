package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProductListingPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebProductListingPage extends BasePage implements ProductListingPage {

    @FindBy(xpath = "//div[@class='title']")
    List<WebElement> productsTitle;

    @FindBy(xpath = "//span[text()='Sort By']")
    WebElement sortIcon;

    @FindBy(xpath = "//div[text()='Sort By'")
    WebElement sort;


    @FindBy(xpath = "//span[text()='Price - Low to High']")
    WebElement lowToHighOption;

    @FindBy(xpath = "//span[text()='Price - High to Low']")
    WebElement highToLowOption;

    @FindBy(xpath = " //span[text()='Rating']")
    WebElement byRateOption;

    @FindBy(xpath = "//div[text()=\"Our Products\"]/../following-sibling::div[@class=\"product-faq-container\"]/div/section/section/div/div[2]/div/div/div[5]/div[1]")
    List<WebElement> priceElements;

    @FindBy(xpath = "//span[@class=\"addTocart_desktop\" or text()=\"Add To Cart\"]")
    List<WebElement> addToCartBtns;

    @FindBy(xpath = "//span[@class=\"rating\"]")
    List<WebElement> ratingsElements;

    @FindBy(xpath = "//button[text()='Body Lotion']")
    WebElement bodyLotionBtn ;

    @FindBy(xpath = "//div[@class=\"resultsfor\"]")
    WebElement resultsFound ;





    @FindBy(xpath="//div[text()='No products found']")
    WebElement invalidProductMessage ;

    @FindBy(xpath="//div[@class='searchKey']")
    WebElement searchKey;


    @Override
    public boolean isProductListingPageDisplayed() {
//        System.out.println(addToCartBtns.size());
        // System.out.println(isPresent(sortIcon));
        return !addToCartBtns.isEmpty() || isPresent(sortIcon);
        //return true;
    }

    @Override
    public void clickOnFirstProductWithKeyword(String keyword) {
        System.out.println(productsTitle.size());
        for (WebElement itemItemTitle : productsTitle) {
            if (itemItemTitle.getText().toLowerCase().contains(keyword.toLowerCase())) {
                itemItemTitle.click();
                break;
            }
        }
    }

    public void clickOnSortIcon() {
        sortIcon.click();

    }

    public void selectLowToHighOption() {
        lowToHighOption.click();
    }

    public boolean isSortedLowToHigh() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
            if (!priceText.isEmpty() && priceText.matches("\\d+")) { // Check if valid number
                prices.add(Integer.parseInt(priceText));
                // System.out.println(priceText);
            }
        }
        List<Integer> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        return prices.equals(sortedPrices);

    }

    public void selectHighToLowOption() {
        highToLowOption.click();
    }

    public boolean isSortedHighToLow() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
            if (!priceText.isEmpty() && priceText.matches("\\d+")) { // Check if valid number
                prices.add(Integer.parseInt(priceText));
                //System.out.println(priceText);
            }
        }
        //System.out.println(prices);
        List<Integer> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        return prices.equals(sortedPrices);

    }

    public void selectByRateOption() {
        byRateOption.click();
    }

    public boolean isSortedByRatings() {
        List<Integer> ratings = new ArrayList<>();
        for (WebElement ratingsElement : ratingsElements) {
            String ratingText = ratingsElement.getText().replaceAll("[^0-9]", "").trim(); // Remove non-numeric characters
            if (!ratingText.isEmpty()) {
                ratings.add(Integer.parseInt(ratingText));
            }
        }
        System.out.println("Extracted Ratings: " + ratings);

        List<Integer> sortedRatings = new ArrayList<>(ratings);
        sortedRatings.sort(Collections.reverseOrder());

        return ratings.equals(sortedRatings);

    }

    public boolean isSearchResultFound(String product){
        System.out.println(searchKey.getText());
        return (searchKey.getText().contains(product));
    }

    public boolean isInvalidMessageDisplayed(){
        return isDisplayed(invalidProductMessage);
    }

    public void addToCartFirstItem(){
        addToCartBtns.get(0).click();
    }

    public void selectBabyBodyLotion(){
        bodyLotionBtn.click();
    }

    public void selectFirstItem(){
        productsTitle.get(0).click();
    }

    public  boolean isProductsTitleWithKeyword(String keyword){
//        System.out.println(resultsFound.getText());
        for (WebElement each : productsTitle){
            //System.out.println(each.getText());
            if(!each.getText().contains(keyword))
                return false;
        }
        return true;
    }

    public boolean isCountEqualsTotalProducts(){
        String count = resultsFound.getText().replaceAll("[^0-9]", "");
        ConfigReader.setConfigValue("results.count",count);
//        System.out.println(count);
//        System.out.println(ConfigReader.getIntConfigValue("results.count") );
        return ConfigReader.getIntConfigValue("results.count") == productsTitle.size();
    }
}



