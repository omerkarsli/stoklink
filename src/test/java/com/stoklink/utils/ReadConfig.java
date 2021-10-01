package com.stoklink.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            this.pro = new Properties();
            this.pro.load(fis);
        } catch (IOException var3) {
            System.out.println(var3.getMessage());
        }
    }

    public String getApplicationURL() {
        return this.pro.getProperty("baseURL");
    }

    public String getUserName() {
        return this.pro.getProperty("username");
    }

    public String getTUserName() {
        return this.pro.getProperty("tUsername");
    }

    public String getPassword() {
        return this.pro.getProperty("password");
    }

}
