package com.university.university.util;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class MessageSourceUtil {

    private Properties properties;

    public MessageSourceUtil(){
        FileInputStream fis;
        try{
            fis = new FileInputStream("src/main/resources/static/messages/statusMessages.properties");
            properties = new Properties();
            properties.load(fis);
        }catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public String getMessages(String properties){
        return this.properties.getProperty(properties);
    }
}
