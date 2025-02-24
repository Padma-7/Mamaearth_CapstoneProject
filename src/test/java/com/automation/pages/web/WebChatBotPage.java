package com.automation.pages.web;
import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ChatBotPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class WebChatBotPage extends BasePage implements ChatBotPage {

    //changes
    @FindBy(id="chatwoot_live_chat_widget")
    WebElement inputIFrame;

    @FindBy(xpath = "(//input[@class='base-input'])[1]")
    WebElement fullNameInput;
    @FindBy(xpath = "(//input[@class='base-input'])[2]")
    WebElement emailInput;
    @FindBy(xpath = "//input[@class='base-input' and @type='number']")
    WebElement phoneInput;
    @FindBy(xpath = "//span[@class='header-subtitle black-text']")
    WebElement chatHeader;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement startConversationButton;
    @FindBy(xpath = "//textarea[@placeholder='Type your message']")
    WebElement chatInput;
    @FindBy(xpath = "//span[@class='message-span']/p[contains(text(),'product recommendations for')]")
    WebElement replyText;
    @FindBy(xpath="(//span[@class='custom-icons'])[2]")
    WebElement sendTextBtn;
    @FindBy(xpath="//div[@class='message-span-wrapper']//div[@class='card-body']")
    WebElement productsInText;



    public void fillInTheDetails(String name,String email,String phone) {
        fullNameInput.sendKeys(name);
        emailInput.sendKeys(email);
        phoneInput.click();
        System.out.println(phone);
        phoneInput.sendKeys(phone);
    }

    public boolean isUserInChatPage() {
        driver.switchTo().frame(inputIFrame);
        return isDisplayed(chatHeader);
    }
    public void clickOnSendQuery() {
        Actions actions = new Actions(driver);
        actions.moveToElement(startConversationButton).click().perform();
    }

    public void typeInTheQuery(String question) {
        pause(6000);
        chatInput.sendKeys(question);
        sendTextBtn.click();
    }
    public boolean IsChatBotReplyDisplayed() {
        pause(15000);
        return isDisplayed(productsInText);
    }

    public boolean isWelcomeTextDisplayed(){
        return true;
    }

}

