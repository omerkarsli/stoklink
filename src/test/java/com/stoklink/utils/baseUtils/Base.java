package com.stoklink.utils.baseUtils;

import com.stoklink.pageObjects.Login;
import com.stoklink.pageObjects.admin.A_Menu;
import com.stoklink.pageObjects.admin.A_TeklifIslemleri;
import com.stoklink.pageObjects.musteri.M_Menu;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.pageObjects.tedarikci.T_Menu;
import com.stoklink.pageObjects.tedarikci.T_TeklifAraVer;
import com.stoklink.utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public ReadConfig rc = new ReadConfig();
    public static WebDriverWait wait;
    public static FluentWait<WebDriver> fwait;
    public static A_Menu aMenu;
    public static A_TeklifIslemleri aTeklifIslemleri;
    public static M_Menu mMenu;
    public static M_Talepler mTalepler;
    public static M_TalepOlustur mTalepOlustur;
    public static T_Menu tMenu;
    public static T_TeklifAraVer tTeklifAraVer;
    public static Login login;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        fwait = wait.ignoring(StaleElementReferenceException.class);
        login = new Login(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        driver.get(rc.getApplicationURL());

    }

    public void musteriLogin(){
        String username = rc.getMusteriUsername();
        String password = rc.getPassword();
        login.setTxtUserName(username);
        login.setTxtPassword(password);
        login.clickLogin();
    }

    public void tedarikciLogin(){
        String username = rc.getTedarikciUsername();
        String password = rc.getTedarikciPassword();
        login.setTxtUserName(username);
        login.setTxtPassword(password);
        login.clickLogin();
    }

    public void adminLogin(){
        String username = rc.getAdminUsername();
        String password = rc.getPassword();
        login.setTxtUserName(username);
        login.setTxtPassword(password);
        login.clickLogin();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
