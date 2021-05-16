package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class Config {
    //Đường dẫn web driver.
    public static String DriverPath = "/home/thienphuoc/KTPM/geckodriver-v0.29.1-linux64/geckodriver";

    //Loại driver.
    public static String DriverKey = "webdriver.gecko.driver";

    //Đường dẫn trang web.
    public static String BaseURL = "http://localhost/KTPM/index.php";

    //Lưu thông tin tài khoản người quản trị.
    public static HashMap<String,String> ADMIN =new HashMap<String,String>();

    //Lưu thông tin tài khoản người dùng.
    public static HashMap<String,String> USER =new HashMap<String,String>();

    //Chạy các cấu hình bên trên.
    public static WebDriver run(String url){

        ADMIN.put("username","admin");
        ADMIN.put("password","admin");

        USER.put("username","user");
        USER.put("password","userA123");

        System.setProperty(DriverKey, DriverPath);
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
