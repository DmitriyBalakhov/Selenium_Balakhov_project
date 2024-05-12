package org.example.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertyFactory {
    private static Properties properties = new Properties();
    public static Properties loadProperties(String filePath){

        try {
            InputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
        public static String getBrowserProperty(){
            return properties.getProperty("browser");

        }
    }

