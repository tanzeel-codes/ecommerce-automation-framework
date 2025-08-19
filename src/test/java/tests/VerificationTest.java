package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import resources.Base;

import java.time.Duration;

public class VerificationTest extends Base {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opencart.dreamvention.com/index.php?route=product/product&path=20_27&product_id=41");
        Thread.sleep(3000);
        driver.findElement(By.id("button-cart")).click();
        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]"));


        System.out.println("TEXT HERE ----> "+element.getText());
    }

}
