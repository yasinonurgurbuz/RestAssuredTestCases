package com.petstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    public  static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private   Config() {
        throw new IllegalStateException("TestBase.Config");
    }
    static Properties prop = new Properties();
    static String propertiesPath = System.getProperty("user.dir")+"/src/main/resources/config.properties";

    public static String getProperties(String key){
        String val = System.getenv(key);
        if (val == null || val.isEmpty()) {
            try {
                InputStream input = new FileInputStream(propertiesPath);
                prop.load(input);
                val = prop.getProperty(key);
                input.close();
            }
            catch (Exception e){
                LOGGER.info("Config class getProperties error  {}  ",key);
            }
        }
        return val;
    }
}
