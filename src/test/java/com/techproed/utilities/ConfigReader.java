package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {
        String path = "bilgiler.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {

        }
    }

    public static String getProperty (String key){
        return  properties.getProperty(key);
    }
}
