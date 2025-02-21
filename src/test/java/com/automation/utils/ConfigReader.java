package com.automation.utils;

import io.cucumber.java.sl.In;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    public static void initConfig() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/config/config.properties"));
    }

    public static void setConfigValue(String key, String value)
    {
        properties.setProperty(key, value);
    }

    public static String getConfigValue(String key)
    {
        return properties.getProperty(key);
    }

    public static int getIntConfigValue(String key)
    {
       String value = properties.getProperty(key);
        return Integer.parseInt(value);


    }



}
