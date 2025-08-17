package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public Properties prop;
    private static final Logger logs = LogManager.getLogger(Base.class);

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
        FileInputStream fis = new FileInputStream(propPath);
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logs.info("Driver successfully initiated");
        return driver;
    }

    public void takeScreenshot(String testName, WebDriver driver) throws IOException {
        File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String des = System.getProperty("user.dir")+"\\screenshot\\"+testName+".png";
        FileUtils.copyFile(fileSource, new File(des));
    }
}
