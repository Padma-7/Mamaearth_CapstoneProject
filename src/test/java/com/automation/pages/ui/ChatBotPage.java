package com.automation.pages.ui;
public interface ChatBotPage {

    boolean isUserInChatPage();

    void fillInTheDetails(String configValue, String configValue1, String configValue2);

    void clickOnSendQuery();

    void typeInTheQuery(String question);

    boolean IsChatBotReplyDisplayed();

    boolean isWelcomeTextDisplayed();
}