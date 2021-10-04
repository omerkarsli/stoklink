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
            pro = new Properties();
            pro.load(fis);
        } catch (IOException var3) {
            System.out.println(var3.getMessage());
        }
    }

    public String getApplicationURL() {
        return pro.getProperty("baseURL");
    }

    public String getMusteriUsername() {
        return pro.getProperty("musteriUsername");
    }

    public String getTedarikciUsername() {
        return pro.getProperty("tedarikciUsername");
    }

    public String getAdminUsername() {
        return pro.getProperty("adminUsername");
    }

    public String getPassword() {
        return pro.getProperty("password");
    }

    public String getTedarikciPassword() {
        return pro.getProperty("tedarikciPassword");
    }

}
