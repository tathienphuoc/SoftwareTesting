package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class Config {
    public static String DriverPath = "/home/thienphuoc/KTPM/geckodriver-v0.29.1-linux64/geckodriver";
    public static String DriverKey = "webdriver.gecko.driver";
    public static String BaseURL = "http://localhost/KTPM/index.php";
    public static HashMap<String,String> ADMIN =new HashMap<String,String>();
    public static HashMap<String,String> USER =new HashMap<String,String>();
    public static WebDriver run(String url){

        ADMIN.put("username","admin");
        ADMIN.put("password","admin");

        USER.put("username","user");
        USER.put("password","userA123");

        System.setProperty(DriverKey, DriverPath);
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
//        driver.manage().window().maximize();
        return driver;
    }
}
