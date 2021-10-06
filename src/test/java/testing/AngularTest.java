package testing;


import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularTest {

    WebDriver driver;

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        NgWebDriver ng = new NgWebDriver(js);
        driver.get("https://panel.stoklink.com/page/auth/login");
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.id("input-email")).sendKeys("omerkrsli@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Aa123456");
        driver.findElement(ByAngular.partialButtonText("GİRİŞ YAP")).click();
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.cssSelector("a[title='Tedarikçi']")).click();
        ng.waitForAngularRequestsToFinish();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Teklif Arama / Verme']"))).click();

    }
}
