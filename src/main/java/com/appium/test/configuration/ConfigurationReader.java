package com.appium.test.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class ConfigurationReader {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Properties PROPERTIES = new Properties();
    private static ConfigurationReader instance;

    private ConfigurationReader() {
    }

    public static ConfigurationReader getInstance() {
        if (instance == null) {
            instance = new ConfigurationReader();
            try {
                PROPERTIES.load(new FileInputStream("src/main/resources/test.properties"));
            } catch (IOException e) {
                LOGGER.error("Properties were not loaded");
            }
        }
        return instance;
    }

    public String getEnv() {
        return PROPERTIES.getProperty("env.type");
    }

    public String getAppPath() {
        return PROPERTIES.getProperty("app.path");
    }

    public String getAppPackage() {
        return PROPERTIES.getProperty("app.package");
    }

    public String getAppActivity() {
        return PROPERTIES.getProperty("app.activity");
    }

    public String getPlatformName() {
        return PROPERTIES.getProperty("platform.name");
    }

    public String getPlatformVersion() {
        return PROPERTIES.getProperty("platform.version");
    }

    public String getLocalDeviceName() {
        return PROPERTIES.getProperty("local.device.name");
    }

    public String getUdId() {
        return PROPERTIES.getProperty("udid");
    }

    public String getAppiumAddress() {
        return PROPERTIES.getProperty("appium.address");
    }

    public int getAppiumPort() {
        return Integer.parseInt(PROPERTIES.getProperty("appium.port"));
    }
}
