package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends BasePage implements LoginPage {



    @FindBy(xpath = "//div[ text()='Login']")
    WebElement loginIcon;


    @FindBy(xpath = "//button[@type='submit' and text()='Login with OTP']")
    WebElement loginWithOTPBtn;

    @FindBy(xpath = "//input[@type='number']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@type='submit' and text()='VERIFY']")
    WebElement verifyOTPBtn;

    @FindBy(xpath = "//div[text()='Click Allow to get Coupon Code']")
    WebElement couponPopUp;

    @FindBy(xpath = "//button[@id=\"wzrk-cancel-id\"]")
    WebElement cancelBtn;

    @FindBy(xpath = "//span[@class=\"display-1024 isLoggedIn\"]")
    WebElement loggedInIcon;

    @FindBy(xpath = "//p[text()='Logout']")
    WebElement logoutLink ;

    @FindBy(xpath = "//div[@class=\"error-new\"]")
    WebElement errorMsg ;




    String xPath = "//p[text()='%s']";



    @Override
    public boolean isLoginPageDisplayed() {
        return loginWithOTPBtn.isDisplayed();
    }

    @Override
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    @Override
    public void clickOnLoginWithOTPBtn() {
        loginWithOTPBtn.click();
    }

    @Override
    public boolean isOTPDetailsPageDisplayed() {
        return verifyOTPBtn.isDisplayed();
    }

    @Override
    public void enterOTP() {
        pause(10);
        if(isDisplayed(couponPopUp))
            cancelBtn.click();
        // verifyOTPBtn.click();
    }

    @Override
    public boolean isPhoneNumberDisplayed() {
        WebElement phoneNumber = driver.findElement(By.xpath(String.format(xPath, ConfigReader.getConfigValue("login.phone"))));
        loggedInIcon.click();
        return isPresent(phoneNumber);
    }

    @Override
    public void clickOnLogoutLink() {
        loggedInIcon.click();
        logoutLink.click();
    }

    @Override
    public boolean isLoggedOut() {
        return isPresent(loginIcon);
    }

    @Override
    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMsg);
    }

}
