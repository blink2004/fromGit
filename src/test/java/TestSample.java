import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Freeman on 26.09.2016.
 */
public class TestSample {

    public WebDriver driver;

    protected String domain = "http://ya.ru";

    @BeforeSuite
    public void before() {
        String baseUrl = System.getenv("baseUrl");
        String browser = System.getenv("browser");

        baseUrl = baseUrl!=null ? baseUrl : domain;
        browser = browser!=null ? browser : "no browser selected";
        System.out.println("ENV var \"baseUrl\": " + baseUrl);
        System.out.println("ENV var \"browser\": " + browser);

//        String webdriversPath = "D:\\Program Files (x86)\\webdrivers\\";
//        String webdriversPath = "./";
//        String webdriversPath = "D:\\Work\\Test-Cases\\fromGit\\";

        // for Windows
        /*System.setProperty("webdriver.chrome.driver",
                webdriversPath + "chromedriver.exe");*/
//        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//        System.setProperty("webdriver.gecko.driver", webdriversPath + "geckodriver.exe");

        // for Linux
//        System.setProperty("webdriver.chrome.bin",
//        System.setProperty("webdriver.chrome.bin", "./../linux_chromedriver");
//        System.setProperty("webdriver.chrome.driver", "./../linux_chromedriver_2_23");
//        System.setProperty("webdriver.gecko.driver", "./../geckodriver");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(enabled = false)
    public void testGit() {
        System.out.println("Simple test from git");
    }

    @Test
    public void getCurUrl(){
        System.out.println("Current URL is " + driver.getCurrentUrl());
    }

    @AfterSuite
    public void after() {
        if ( driver!=null ){
            driver.quit();
            driver.close();
        }
    }

}
