package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.AddressPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class AndroidAddressPage extends BasePage implements AddressPage {
    @FindBy(xpath = "//div[text()='Add address'  and @class='proceed-text']")
    WebElement addressPageHeading;
    @FindBy(xpath = "//android.widget.TextView[@text=\" ADD NEW ADDRESS\"]\n")
    WebElement addAddressBtn;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Save Address\"]")
    WebElement saveAddressBtn;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]")
    WebElement pincodeInput;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]")
    WebElement addressInput1;
    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    List<WebElement> deleteBtns ;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]")
    WebElement firstNameInput;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]")
    WebElement lastNameInput;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]")
    WebElement emailInput ;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]")
    WebElement mobileNumberInput ;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[5]")
    WebElement postCodeInput;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[8]")
    WebElement addressInput2 ;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Proceed to pay\"]")
    WebElement proceedToPayBtn ;

    public boolean isAddressPageDisplayed() {
        return isDisplayed(addressPageHeading) || isDisplayed(addAddressBtn) || isDisplayed(saveAddressBtn);
    }
    public void fillAddressDetails() {
        if(isDisplayed(firstNameInput)&&isDisplayed(lastNameInput)&&isDisplayed(emailInput)&&isDisplayed(mobileNumberInput)&&isDisplayed(postCodeInput)&&isDisplayed(addressInput2)) {
            firstNameInput.sendKeys(ConfigReader.getConfigValue("first.name"));
            lastNameInput.sendKeys(ConfigReader.getConfigValue("last.name"));
            emailInput.sendKeys(ConfigReader.getConfigValue("email"));
            mobileNumberInput.sendKeys(ConfigReader.getConfigValue("mobile.number"));
            postCodeInput.sendKeys(ConfigReader.getConfigValue("postal.code"));
            addressInput2.sendKeys(ConfigReader.getConfigValue("address"));
        }
        else if (isDisplayed(pincodeInput)&&isDisplayed(addressInput1)){
            pincodeInput.sendKeys(ConfigReader.getConfigValue("postal.code"));
            addressInput1.sendKeys(ConfigReader.getConfigValue("address"));

        }
    }
    public void selectAddressType(String addressType) {
        scrollPage();
    }
    public void clickOnSaveAddressButton() {
        saveAddressBtn.click();
    }
    public boolean isAddressSaved() {
        return isDisplayed(proceedToPayBtn);
    }
    public void clickOnAddAddressButton() {
        ConfigReader.setConfigValue("numberof.address",String.valueOf(deleteBtns.size()));
        addAddressBtn.click();
    }
    public boolean isAddressFillingPageDisplayed() {
        return isDisplayed(saveAddressBtn);
    }
    public boolean isAddressAdded() {
        int previous = ConfigReader.getIntConfigValue("numberof.address");
        int current = deleteBtns.size();
        System.out.println(previous);
        System.out.println(current);
        if(previous+1 == current)
            return true;
        else
            return false;
    }


}

