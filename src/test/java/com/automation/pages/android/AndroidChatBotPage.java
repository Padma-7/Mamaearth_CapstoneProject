package com.automation.pages.android;
import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ChatBotPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AndroidChatBotPage extends BasePage implements ChatBotPage {
    @FindBy(xpath = "//android.widget.TextView[@text='Full Name']/following-sibling::android.widget.EditText")
    WebElement fullNameInput;
    @FindBy(xpath = "//android.widget.TextView[@text='Email Address']/following-sibling::android.widget.EditText")
    WebElement emailInput;
    @FindBy(xpath = "//android.widget.TextView[@text='Phone Number']/following-sibling::android.widget.EditText")
    WebElement phoneInput;
    @FindBy(xpath = "//android.widget.TextView[@text='Chat with us']")
    WebElement chatHeader;
    @FindBy(xpath = "//android.widget.Button[@text='Start Conversation']")
    WebElement startConversationButton;
    @FindBy(xpath = "//android.widget.EditText")
    WebElement chatInput;
    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Here are some great product recommendations')]")
    WebElement replyText;
    @FindBy(xpath="//p[contains(text(),'Welcome to Mamaearth')]")
    WebElement welcomeText;

    public void fillInTheDetails(String name,String email,String phone) {
        fullNameInput.sendKeys(name);
        emailInput.sendKeys(email);
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public boolean isUserInChatPage() {
        return isDisplayed(chatHeader);
    }
    public void clickOnSendQuery() {
        startConversationButton.click();
    }
    public void typeInTheQuery(String question) {
        pause(2000);
        chatInput.sendKeys(question);
    }
    public boolean IsChatBotReplyDisplayed() {
        do{
            scrollPageUp();
        }while(!replyText.isDisplayed());
        return isDisplayed(replyText);
    }

    public boolean isWelcomeTextDisplayed(){
        return isDisplayed(welcomeText);
    }
}