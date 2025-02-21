package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProfilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProfilePage extends BasePage implements ProfilePage {


    @FindBy(xpath="//android.widget.TextView[@text='Hey']")
    WebElement profileMessage;

    @FindBy(xpath="//android.widget.TextView[@text='Login and avail benefits']")
    WebElement loginIcon;

    @FindBy(xpath="//android.widget.TextView[@text='Logout']")
    WebElement logoutIcon;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Addresses\"]\n")
    WebElement addressesOption ;


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

    public void selectAddresses(){
        addressesOption.click();
    }
}


