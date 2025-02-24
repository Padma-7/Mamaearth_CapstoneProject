package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.AddressPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebAddressPage extends BasePage implements AddressPage {

    @FindBy(xpath = "//div[text()='Add address'  and @class='proceed-text']")
    WebElement addressPageHeading;

    @FindBy(xpath = "//input[@name='firstName' or @name ='firstname']")
    WebElement firstnameInput;

    @FindBy(xpath = "//input[@name='lastName' or @name=\"lastname\"]")
    WebElement lastnameInput;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='mobile' or @name='telephone']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@name='postCode' or @name=\"postcode\"]")
    WebElement postCodeInput;

    @FindBy(xpath = "//textarea[@name='address']")
    WebElement addressInput1;


    @FindBy(xpath = "//input[@name='address']")
    WebElement addressInput2;


    @FindBy(id = "homeOption")
    WebElement homeOption;

    @FindBy(id = "workOption")
    WebElement workOption;

    @FindBy(id = "homeOption")
    WebElement otherOption;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveAddressBtn ;

    @FindBy(xpath = "//div[text()='Proceed to pay']")
    WebElement proceedToPayBtn ;

    @FindBy(xpath = "//button[text()='+ ADD NEW ADDRESS']")
    WebElement addAddressBtn ;

    @FindBy(xpath = "//button[text()='Remove']")
    List<WebElement> removeBtns ;



    public boolean isAddressPageDisplayed() {
        return isDisplayed(addressPageHeading) || isDisplayed(addAddressBtn);
    }

    public void fillAddressDetails() {
        firstnameInput.sendKeys(ConfigReader.getConfigValue("first.name"));
        lastnameInput.sendKeys(ConfigReader.getConfigValue("last.name"));
        emailInput.sendKeys(ConfigReader.getConfigValue("email"));
        mobileNumberInput.sendKeys(ConfigReader.getConfigValue("mobile.number"));
        postCodeInput.sendKeys(ConfigReader.getConfigValue("postal.code"));
        if(isPresent(addressInput1))
        addressInput1.sendKeys(ConfigReader.getConfigValue("address"));
        else if (isDisplayed(addressInput2)) {
            addressInput2.sendKeys(ConfigReader.getConfigValue("address"));
        }
    }

    public void clickOnSaveAddressButton(){
        saveAddressBtn.click();
    }

    public void selectAddressType(String addressType){
//        if(homeOption.getText().toLowerCase().equals(addressType.toLowerCase())) {
//            if(!homeOption.isSelected())
//                homeOption.click();
//        }
//        else if (workOption.getText().toLowerCase().equals(addressType.toLowerCase())) {
//            workOption.click();
//        }
//        else {
//            otherOption.click();
//        }
    }

    public boolean isAddressSaved(){
        return isDisplayed(proceedToPayBtn);
    }

    public void clickOnAddAddressButton(){
        ConfigReader.setConfigValue("numberof.address",String.valueOf(removeBtns.size()));
        addAddressBtn.click();
    }

    public boolean isAddressFillingPageDisplayed(){
        return isDisplayed(firstnameInput);}

    public boolean isAddressAdded(){
        int previous = ConfigReader.getIntConfigValue("numberof.address");
        int current = removeBtns.size();
        System.out.println(previous);
        System.out.println(current);
        if(previous+1 == current)
            return true;
        else
        return false;
    }

}
