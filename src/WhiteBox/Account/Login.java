package WhiteBox.Account;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Login extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");

    @Test
    public void test(){
        testBackground();
        testLoginForm();
        driver.close();
    }

    //Kiểm tra màu nền trang web.
    @Test
    public void testBackground() {
        WebElement background = driver.findElement(By.xpath("//div[@class='container-fluid d-flex']"));
        //test màu nền trang web
        String expect_background_color_background = "#000000";
        testBackgroundColor(background, expect_background_color_background);
    }

    //Kiểm tra form đăng nhập.
    @Test
    public void testLoginForm() {
        //test kích thước nút trang chủ
        WebElement homepage_button = getWebElementByXPath(driver, "//a[@class='btn btn-outline-primary back-btn']");

        int expect_height_homepage_button = 38;
        String expect_color_homepage_button = "#007bff";
        String expect_background_color_homepage_button = "#000000";

        testHeight(homepage_button, expect_height_homepage_button);
        testColor(homepage_button, expect_color_homepage_button);
        testBackgroundColor(homepage_button, expect_background_color_homepage_button);


        //test tiêu dề trang web
        WebElement title = getWebElementByXPath(driver, "/html/body/div/form/h1");

        String expect_text_title = "Đăng nhập tài khoản";
        String expect_color_title = "#212529";

        testText(title, expect_text_title);
        testColor(title, expect_color_title);


        //test giá trị label tên tài khoản
        WebElement username_lable = getWebElementByXPath(driver, "//label[@for='validationCustomUsername']");

        String expect_text_username_lable = "Tên tài khoản";
        String expect_color_username_lable = "#212529";

        testText(username_lable, expect_text_username_lable);
        testColor(username_lable, expect_color_username_lable);

        //test màu nền input tên tài khoản
        WebElement username_input = getWebElementById(driver, "validationCustomUsername");

        String expect_background_color_username_input = "#ffffff";
        String expect_type_username_input = "text";

        testBackgroundColor(username_input, expect_background_color_username_input);
        testInputType(username_input, expect_type_username_input);

        //test giá trị span @gmail
        WebElement gmail_span = getWebElementByCSSSelector(driver, "#inputGroupPrepend");

        String expect_text_gmail_span = "@gmail.com";
        String expect_background_color_gmail_span = "#e9ecef";
        String expect_color_gmail_span = "#495057";

        testText(gmail_span, expect_text_gmail_span);
        testBackgroundColor(gmail_span, expect_background_color_gmail_span);
        testColor(gmail_span, expect_color_gmail_span);


        //test giá trị label tên tài khoản
        WebElement password_lable = getWebElementByXPath(driver, "//label[@for='validationCustom03']");

        String expect_text_password_lable = "Mật khẩu";
        String expect_color_password_lable = "#212529";

        testText(password_lable, expect_text_password_lable);
        testColor(password_lable, expect_color_password_lable);

        //test màu nền input tên tài khoản
        WebElement password_input = getWebElementById(driver, "validationCustom03");

        String expect_background_color_password_input = "#ffffff";
        String expect_type_password_input = "password";

        testBackgroundColor(password_input, expect_background_color_password_input);
        testInputType(password_input, expect_type_password_input);

        //test giá trị của link: quên mật khẩu?
        WebElement forgotPassword_link = getWebElementByXPath(driver, "/html/body/div/form/div[3]/a[1]");

        String expect_text_forgotPassword_link = "Quên mật khẩu?";
        String expect_color_forgotPassword_link = "#007bff";

        testText(forgotPassword_link, expect_text_forgotPassword_link);
        testColor(forgotPassword_link, expect_color_forgotPassword_link);


        //test giá trị của link: tạo tài khoản?
        WebElement signUp_link = getWebElementByXPath(driver, "/html/body/div/form/div[3]/a[2]");

        String expect_text_signUp_link = "Tạo tài khoản?";
        String expect_color_signUp_link = "#007bff";

        testText(signUp_link, expect_text_signUp_link);
        testColor(signUp_link, expect_color_signUp_link);


        //test kích thước nút đăng nhập
        WebElement login_button = getWebElementById(driver, "submitBtn");

        String expect_color_login_button = "#ffffff";
        String expect_background_color_login_button = "#007bff";
        String expect_text_login_button = "Đăng nhập";

        testColor(login_button, expect_color_login_button);
        testBackgroundColor(login_button, expect_background_color_login_button);
        testText(login_button, expect_text_login_button);
//        driver.close();
    }

    @AfterClass
    public static void onDestroy() {
        driver.quit();
    }
}
