package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.ui.ProductDetailsPage;
import com.automation.pages.web.*;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    ProductListingPage productListingPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    PaymentPage paymentPage;
    AddressPage addressPage;
    CategoryPage categoryPage;
    ChatBotPage chatBotPage;
    SearchPage searchPage;

    public BaseSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            profilePage = new WebProfilePage();
            productListingPage = new WebProductListingPage();
            productDetailsPage = new WebProductDetailsPage();
            cartPage = new WebCartPage();
            paymentPage = new WebPaymentPage();
            addressPage = new WebAddressPage();
            chatBotPage = new WebChatBotPage();
            searchPage = new WebSearchPage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            profilePage = new AndroidProfilePage();
            productListingPage = new AndroidProductListingPage();
            productDetailsPage = new AndroidProductDetailsPage();
            cartPage = new AndroidCartPage();
            paymentPage = new AndroidPaymentPage();
            addressPage = new AndroidAddressPage();
            categoryPage = new AndroidCategoryPage();
            chatBotPage = new AndroidChatBotPage();
            searchPage = new AndroidSearchPage();
        }
    }
}
