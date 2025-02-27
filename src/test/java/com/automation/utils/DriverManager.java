package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Set;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));

            driver = new AndroidDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }


    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void switchWindow()
    {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows)
        {
            if(!window.equals(currentWindow))
            {
                driver.switchTo().window(window);
            }
        }

    }
}
