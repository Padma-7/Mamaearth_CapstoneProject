package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebHomePage extends BasePage implements HomePage {

    @FindBy(xpath = "//p[@class=\"sc-cMljjf gCenij\"]")
    WebElement searchBar;

    @FindBy(xpath = "//input[@type=\"search\"]")
    WebElement searchInput;

    //@FindBy(xpath = "//div[ text()='Login']")
    //WebElement loginIcon;

    @FindBy(xpath = "//i[@class=\"display-1024\"]")
    WebElement loginIcon;

    @FindBy(xpath = "//li[@class='category']/a[text()='Ingredient']")
    WebElement ingredientCategory;

    @FindBy(xpath = "//li[@class='category']/a[text()='Baby']")
    WebElement babyCategory;


    @FindBy(xpath = "//div/img[@alt='bubble-icon']")
    WebElement chatBotIcon;

    @FindBy(id = "chatwoot_live_chat_widget")
    WebElement iframe;

    @FindBy(xpath = "//button[text()='All']")
    WebElement allButton;

    @FindBy(xpath = "//a[text()='All Products']")
    WebElement allProductsOption;

    @FindBy(xpath = "//p[@class='sc-kpOJdX hgUZfJ' and text()='Manage Address']")
    WebElement manageAddressOtion;

    @FindBy(xpath = "//div[text()='Cart']")
    WebElement cart;

    @FindBy(xpath = "//span[text()='Add To Cart']")
    List<WebElement> addToCart;

    @FindBy(xpath = "(//i[@class='plus-icon'])[1]")
    WebElement plusIcon;

    @FindBy(xpath = "//span[@class='item-count']")
    WebElement cartCount;

    @FindBy(xpath = "(//i[@class='minus-icon'])[1]")
    WebElement minusIcon;

    @FindBy(xpath="//span[@class=\"addTocart_desktop\"]")
        WebElement firstAddToCart;

    @FindBy(xpath="//button/span[text()='Add To Cart']")
        List<WebElement> firstAddToCart2;

    @FindBy(xpath="//span[@class=\"addTocart_desktop\"]/../../preceding-sibling::div/div[@class='title']")
        WebElement productName;

    @FindBy(xpath="//button[@id=\"wzrk-cancel-id\"]")
        WebElement laterBtn;

    @FindBy(xpath = "//a[text()='VIEW ALL' and @href='/product-category/for-babies']")
    WebElement viewAllBabyProducts ;
    @FindBy(xpath = "//div[@class=\"categorytitle\" and text()=\"Baby Care\"]")
    WebElement babyCareproducts ;

    @FindBy(xpath = "//a[text()='Home']")
    List<WebElement> homeIcon ;



    String XPATH_CATEGORY = "//li[@class='category']/a[text()='%s']";

    String XPATH_INGREDIENT_OPTION = "//a[@class='sc-kpOJdX hgUZfJ' and text()='%s']";

    @Override
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
        if(isDisplayed(laterBtn)){
            laterBtn.click();
        }
    }

    @Override
    public boolean isHomePageDisplayed() {
        return searchBar.isDisplayed() && loginIcon.isDisplayed();
    }

    @Override
    public void clickOnLoginIcon() {
        loginIcon.click();
    }

    @Override
    public void searchForProduct(String desiredProduct) {
        searchBar.click();
        searchInput.sendKeys(desiredProduct);
    }

    @Override
    public void clickOnChatBotIcon() {
        chatBotIcon.click();
    }


    @Override
    public void clickOnCategory(String desiredCategory) {
        String xpath = String.format(XPATH_CATEGORY, desiredCategory);
        System.out.println(xpath);
        driver.findElement(By.xpath(xpath));
    }

    @Override
    public void clickOnAllProductsOption() {
        allProductsOption.click();
    }

    @Override
    public void selectDesiredIngredient(String ingredientOption) {
        driver.findElement(By.xpath(String.format(XPATH_INGREDIENT_OPTION, ingredientOption))).click();
        allButton.click();

    }

    @Override
    public void clickOnIngredientCategory() {
        ingredientCategory.click();
    }

    @Override
    public void clickOnBabyCategory() {
        babyCategory.click();
    }

    public void selectManageAddressOption() {
        manageAddressOtion.click();
    }

    @Override
    public void goToBabyCareProducts(){
        Actions actions=new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isDisplayed("//div[text()='Baby Care']/../following-sibling::div[@class='viewAlL']//a[text()='VIEW ALL']"))
            js.executeScript("window.scrollBy(0, 500);");
    }
    public void clickOnViewAllBtn(){
        viewAllBabyProducts.click();
    }
    public void clickOnHomeIcon(){
        homeIcon.get(0).click();
    }
    public void clickOnSearchBar(){
        searchBar.click();
    }

    public void clickOnCartIcon() {
        cart.click();
    }

    public void addSameProductToCart(String productNumber) {
        int n = Integer.parseInt(productNumber);
        for (int i = 1; i <= n; i++) {
            plusIcon.click();
            pause(2000);
        }

    }

    public void addToCartFirstItem() {
        addToCart.get(1).click();
    }

    public boolean isPopUpDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement popUpMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Product has been added to cart')]")));
        return isDisplayed(popUpMessage);
    }

    public boolean verifyCartNumberShowsOne() {
        int i = Integer.parseInt(cartCount.getText());
        return i == 1;
    }

    public void addProductToCart(String productNumber){
        int n = Integer.parseInt(productNumber);
        for (int i = 1; i <= n; i++) {
            addToCart.get(1).click();
            pause(2000);
        }
    }

    public boolean isCartNumberUpdated(String cartNumber){
        int i = Integer.parseInt(cartCount.getText());
        int cartNumberInt = Integer.parseInt(cartNumber);
        return i == cartNumberInt;
    }

    public void removeProductFromCart(){
        pause(5000);
        minusIcon.click();

    }

    public boolean isRemovedPopUpDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement popUpMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Product has been removed from cart')]")));
        return isDisplayed(popUpMessage);
    }

    public void userSelectFirstProductFromHomePage(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(firstAddToCart2).click().perform();
        for (int i=0;i< firstAddToCart2.size();i++){
            if(firstAddToCart2.get(i).isEnabled()) {
                firstAddToCart2.get(i).click();
                return;
            }
        }
    }

}
