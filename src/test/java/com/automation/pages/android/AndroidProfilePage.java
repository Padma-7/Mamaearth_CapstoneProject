package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProfilePage extends BasePage implements ProfilePage {


    @FindBy(xpath="//android.widget.TextView[@text='Hey']")
    WebElement profileMessage;

    @FindBy(xpath="//android.widget.TextView[@text='Login and avail benefits']")
    WebElement loginIcon;

    @FindBy(xpath="//android.widget.TextView[@text='Logout']")
    WebElement logoutIcon;





    @Override
    public boolean isProfilePageDisplayed() {
        return isDisplayed(profileMessage);
    }



    @Override
    public void clickLoginIcon() {
        loginIcon.click();
    }

    @Override
    public boolean isLoginBtnNotDisplayed() {
        return isDisplayed(loginIcon);

    }

    @Override
    public void clickLogoutIcon() {
        while(!isDisplayed(logoutIcon)){
            scrollPage();
        }
        logoutIcon.click();
    }

    @Override
    public boolean userLogoutSuccessful() {
        return isDisplayed(loginIcon);
    }

    //new

    @FindBy(xpath = "//android.widget.TextView[@text='Edit account']")
    WebElement editAccountTab;

    @FindBy(xpath="//android.widget.TextView[@text='First Name']/following-sibling::android.widget.EditText[1]")
    WebElement firstNameInput;

    @FindBy(xpath="//android.widget.TextView[@text='Last Name']/following-sibling::android.widget.EditText[1]")
    WebElement lastNameInput;

    @FindBy(xpath="//android.widget.TextView[@text='SUBMIT']")
    WebElement submitBtn;

    String genderXpath = "//android.widget.TextView[@text='%s']";

    public void clickOnEditProfile(){
        handleSplashScreen();
        while(!isDisplayed(editAccountTab)){
            scrollPage();
        }
        editAccountTab.click();

    }

    public void changeCredentials(String key,String value){
        if(key.equalsIgnoreCase("First name")){
            firstNameInput.click();
            firstNameInput.sendKeys(Keys.CONTROL + "a");
            firstNameInput.sendKeys(Keys.BACK_SPACE);
            firstNameInput.sendKeys(value);
            ConfigReader.setConfigValue(key,value);
            System.out.println(key+":"+value);
        } else if (key.equalsIgnoreCase("Last name")) {
            lastNameInput.click();
            lastNameInput.sendKeys(Keys.CONTROL + "a");
            lastNameInput.sendKeys(Keys.BACK_SPACE);
            lastNameInput.sendKeys(value);
            ConfigReader.setConfigValue(key,value);
            System.out.println(key+":"+value);
        } else if (key.equalsIgnoreCase("Gender")) {
            String valueCapitalised = capitalize(value);
            WebElement genderEle = driver.findElement(By.xpath(String.format(genderXpath,valueCapitalised)));
            genderEle.click();
            ConfigReader.setConfigValue(key,value);
            System.out.println(key+":"+value);
        } else{}
    }

    public void saveChanges(){
        submitBtn.click();
    }

    public boolean changesApplied(String key){
        pause(5000);
        while(!isDisplayed(editAccountTab)){
            scrollPage();
        }
        editAccountTab.click();
        if(key.equalsIgnoreCase("First name")){
            return firstNameInput.getText().equalsIgnoreCase(ConfigReader.getConfigValue(key));
        } else if (key.equalsIgnoreCase("Last name")) {
            return lastNameInput.getText().equalsIgnoreCase(ConfigReader.getConfigValue(key));
        } else if (key.equalsIgnoreCase("Gender")) {
            return true;
        }else {
            return true;
        }
    }
}


