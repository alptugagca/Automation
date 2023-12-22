package pom.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        String file="/Users/alptug.agca/Desktop/SeleniumProject/HepsiBuradaPomProject/src/main/java/pom/qa/config/config.properties";
        try {

            FileInputStream fileInputStream=new FileInputStream(file);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;
    }



}
