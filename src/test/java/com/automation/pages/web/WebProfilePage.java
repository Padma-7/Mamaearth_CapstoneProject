package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//new

public class WebProfilePage extends BasePage implements ProfilePage {

    @FindBy(xpath="//button[text()='Edit']")
    WebElement editProfileBtn ;
    
    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath="//div[@class='select-reason-container']")
    WebElement genderDownArrow;

    @FindBy(xpath="//button[@type='submit']")
    WebElement saveBtn;

    @FindBy(xpath="//span[@class='name']")
    WebElement nameText;

    @FindBy(xpath="//span[@class='details'][3]")
    WebElement genderDisplayEle;

    String genderXpath = "//div[text()='%s']";

    public void clickOnEditProfile(){
        editProfileBtn.click();
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
            genderDownArrow.click();
            String valueCapitalised = capitalize(value);
            WebElement genderEle = driver.findElement(By.xpath(String.format(genderXpath,valueCapitalised)));
            genderEle.click();
            ConfigReader.setConfigValue(key,value);
            System.out.println(key+":"+value);
        } else{}
    }

    public void saveChanges(){
        saveBtn.click();
    }

    public boolean changesApplied(String key){
        pause(5000);
        String fullNameText = nameText.getText();
        fullNameText = fullNameText.replace("Welcome, ", "").replace("!", "").trim();
        String[] nameParts = fullNameText.split("\\s+");
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        if(key.equalsIgnoreCase("First name")){
            return firstName.equalsIgnoreCase(ConfigReader.getConfigValue(key));
        } else if (key.equalsIgnoreCase("Last name")) {
            return lastName.equalsIgnoreCase(ConfigReader.getConfigValue(key));
        } else if (key.equalsIgnoreCase("Gender")) {
            String genderText=genderDisplayEle.getText().replace("Gender : ","");
            return genderText.equalsIgnoreCase(ConfigReader.getConfigValue(key));
        }else {
            return true;
        }
    }

}
