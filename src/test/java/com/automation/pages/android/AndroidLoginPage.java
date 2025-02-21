package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends BasePage implements LoginPage {


    @FindBy(xpath="//android.widget.TextView[@text='Login or Signup']")
    WebElement loginSignUpText;

    @FindBy(xpath="//android.widget.EditText[@resource-id='text-input-outlined']")
    WebElement phoneNumberInput;

    @FindBy(xpath="//android.widget.Button[@resource-id='button']")
    WebElement continueBtn;

    @FindBy(xpath="//android.widget.TextView[@resource-id='button-text']")
    WebElement verifyOtpBtn;

    @FindBy(xpath="//android.widget.TextView[@text='Enter a 10 digit mobile number']")
    WebElement errorMessage;



    @Override
    public boolean isLoginPageDisplayed() {
        return isDisplayed(phoneNumberInput);
    }

    @Override
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);

    }



    @Override
    public void enterOTP() {
        pause(5000);
    }


    @Override
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    @Override
    public void clickOnContinueBtn() {    continueBtn.click();}

    @Override
    public boolean isOTPDetailsPageDisplayed() {
        return isDisplayed(continueBtn);
    }
}


