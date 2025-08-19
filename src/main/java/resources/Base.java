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
//    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();  // FOR THREAD SAFE
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
//            driver.set(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
//            driver.set(new FirefoxDriver());
        }else if(browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
//            driver.set(new EdgeDriver());
        }else if(browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
//            driver.set(new InternetExplorerDriver());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // THREAD SAFE DRIVER
//        driver.get().manage().window().maximize();
//        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logs.info("Driver successfully initiated");
        return driver;
    }

    public String takeScreenshot(String testName, WebDriver driver) {
        String desPath = System.getProperty("user.dir")+"/screenshot/"+testName+".png";
        try {
            File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(fileSource, new File(desPath));
            logs.info("Screenshot has been taken and stored in :" + desPath);
        }catch (Exception e) {
            logs.error("Error while taking screenshot");
        }

        return desPath;
    }
}
