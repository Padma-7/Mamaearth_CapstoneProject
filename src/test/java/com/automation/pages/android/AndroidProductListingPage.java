package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProductListingPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class AndroidProductListingPage extends BasePage implements ProductListingPage {

    @FindBy(xpath = "//android.widget.TextView[@text='ADD']")
    WebElement ADDBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Add to cart']")
    List<WebElement> addToCartBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Add to cart\"]/../preceding-sibling::android.widget.TextView[2]/..")
    List<WebElement> productsCard ;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SORT\"]")
    WebElement sortIcon ;

    @FindBy(xpath = "//android.widget.TextView[@text='Price - Low to High']")
    WebElement lowToHighOption ;

    @FindBy(xpath = "//android.widget.TextView[@text='Price - High to Low']")
    WebElement HighToLowOption ;

    @FindBy(xpath = "//android.widget.TextView[@text='By Rating']")
    WebElement ByRateOption ;

    @FindBy(xpath = "//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[3]")
    List<WebElement> priceElements;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Free Shipping\"]")
    WebElement freeShipping ;

    @FindBy(xpath = "//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[5]")
    List<WebElement> ratingsElements;

    @FindBy(xpath = "//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[1]")
    List<WebElement> productsTitle ;

  @FindBy(xpath = "//android.widget.TextView[contains(@text,'results found for ')]")
  WebElement topBar ;

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'results found')]")
  WebElement resultsFound;


    String XpathProductResult = "//android.widget.TextView[contains(@text,'results found for \"%s\"')]";

    @FindBy(xpath="//android.widget.TextView[@text='No Results']")
    WebElement invalidSearchMessage;

    @FindBy(xpath="//android.widget.TextView[contains(@text,'results found')]/following-sibling::android.view.ViewGroup[1]")
    WebElement firstItem ;



    @Override
    public boolean isProductListingPageDisplayed(){
        pause(4000);
        return isDisplayed(productsTitle.get(0)) || isDisplayed(addToCartBtn.get(0)) || isDisplayed(sortIcon) ;
    }

    @Override
    public void clickOnFirstProductWithKeyword(String keyword){
        boolean flag = false;
        while(true) {
            for (WebElement each : productsTitle) {
                if (each.getText().contains(keyword)) {
                    each.click();
                    flag = true;
                }
            }
            if(flag)
                break;
            int startX = addToCartBtn.get(0).getLocation().getX();
            int endX = startX;
            int startY = addToCartBtn.get(0).getLocation().getY() + addToCartBtn.get(0).getSize().height;
            int endY = productsCard.get(0).getLocation().getY();
            scroll(startX, startY,endX,endY);
            productsTitle = driver.findElements(By.xpath("//android.widget.TextView[@text=\"Add to cart\"]/..//preceding-sibling::android.widget.TextView[2]"));
        }
    }

    @Override
    public void clickOnSortIcon(){
        sortIcon.click();
    }

    @Override
    public void selectLowToHighOption(){
        lowToHighOption.click();
    }

    @Override
    public void selectHighToLowOption(){
        HighToLowOption.click();
    }

    @Override
    public void selectByRateOption(){
        ByRateOption.click();
    }


    public boolean isSortedLowToHigh(){
       // scrollPage();

        List<Integer> prices;
        while(true){
        prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
            if (!priceText.isEmpty() && priceText.matches("\\d+")) { // Check if valid number
                prices.add(Integer.parseInt(priceText));
                System.out.println(priceText);
            }
        }
//        int startX = productsCard.get(0).getLocation().getX();
//        int endX = startX;
//        int startY = productsCard.get(0).getLocation().getY()+productsCard.get(0).getSize().height;
//        int endY = productsCard.get(0).getLocation().getY();
//        scroll(startX, startY, endX, endY);
            scrollPage();
        if(isDisplayed(freeShipping))
            break;
        else
        priceElements = driver.findElements(By.xpath("//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[3]"));
        }


        List<Integer> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);


        if (prices.equals(sortedPrices)) {
            return true;
        } else {

        return false;
        }


    }

    @Override
    public boolean isSortedHighToLow(){
        List<Integer> prices;
        while(true){
            prices = new ArrayList<>();
            for (WebElement priceElement : priceElements) {
                String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
                if (!priceText.isEmpty()) {
                    prices.add(Integer.parseInt(priceText));
                    System.out.println(priceText);
                }
            }

            scrollPage();
            if(isDisplayed(freeShipping))
                break;
            else
                priceElements = driver.findElements(By.xpath("//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[3]"));
        }


        System.out.println(prices);
        List<Integer> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        if (prices.equals(sortedPrices)) {
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean isSortedByRatings(){
        List<Integer> ratings;
        while(true){
            ratings = new ArrayList<>();
            for (WebElement ratingsElement : ratingsElements) {
                String priceText = ratingsElement.getText().replace(".", "").trim();
                if (!priceText.isEmpty() && priceText.matches("\\d+")) {
                    ratings.add(Integer.parseInt(priceText));
                    System.out.println(priceText);
                }
            }
            scrollPage();
            if(isDisplayed(freeShipping))
                break;
            else
                ratingsElements = driver.findElements(By.xpath("//android.widget.TextView[@text=\" ADD\"]/../../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView[5]"));
        }


        List<Integer> sortedPrices = new ArrayList<>(ratings);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        if (ratings.equals(sortedPrices)) {
            return true;
        } else {

            return false;
        }
    }



    public  boolean isProductsTitleWithKeyword(String keyword){
        boolean flag = true;
        int count = 0;
        while(flag) {
            for (WebElement each: productsTitle){
                count++;
                if(!each.getText().contains(keyword)){
                    flag = false;
                }
            }
            scrollPage();
            productsTitle = driver.findElements(By.xpath("//android.widget.TextView[@text=\"Add to cart\"]/../preceding-sibling::android.widget.TextView[2]"));
        }
        ConfigReader.setConfigValue("total.products", String.valueOf(count));
        System.out.println(count);
        return flag;
    }

    public     boolean isCountEqualsTotalProducts(){

//        System.out.println(count);
//        System.out.println(ConfigReader.getIntConfigValue("results.count") );

        int endY = productsCard.get(0).getLocation().getY();

        Set<String> productNames = new LinkedHashSet<>();

        Set<String> previousProductsTitle = new LinkedHashSet<>();
        Set<String> currentProductsTitle = new LinkedHashSet<>();

        do {
            List<WebElement> flightNames = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tv_flight_name\" ]"));
            for(int i =0;i<flightNames.size();i++) {
                String flightName = flightNames.get(i).getText();
                currentProductsTitle.add(flightName);
            }

            if(currentProductsTitle.equals(previousProductsTitle)){
                break;
            }
            productNames.addAll(currentProductsTitle);


            for (int j = 1; j < productsCard.size(); j++) {
                int x = productsTitle.get(j).getLocation().getX();
                int y = productsCard.get(j).getLocation().getY();
                int width = productsCard.get(j).getSize().getWidth();
                int updatedX = x + width / 2;
                scroll(updatedX, y, updatedX, endY);
            }
            productsCard = driver.findElements(By.xpath("//android.widget.TextView[@text=\"Add to cart\"]/../preceding-sibling::android.widget.TextView[2]/.."));
            previousProductsTitle.clear();
            previousProductsTitle.addAll(currentProductsTitle);
            currentProductsTitle.clear();

        }while(true);

        String count = resultsFound.getText().replaceAll("[^0-9]", "");
        ConfigReader.setConfigValue("results.count",count);


        return ConfigReader.getIntConfigValue("results.count") == productNames.size();
    }

    public boolean isSearchResultFound(String product) {
        WebElement resultsFoundText=driver.findElement(By.xpath(String.format(XpathProductResult,product)));
        return isDisplayed(resultsFoundText);
    }

    public boolean isInvalidMessageDisplayed(){
        return isDisplayed(invalidSearchMessage);
    }

    @Override
    public void clickOnFirstItem(){
        firstItem.click();
    }


}
