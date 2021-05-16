package WhiteBox.Account;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class SignUp extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/register");

    @Test
    public void test() {
        testBackground();
        testSignUpForm();
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
    public void testSignUpForm() {
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

        String expect_text_title = "Đăng ký tài khoản";
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


        //test giá trị label tên tài khoảnas
        WebElement password_lable = getWebElementByXPath(driver, "//label[@for='validationCustom03']");

        String expect_text_password_lable = "Mật khẩu";
        String expect_color_password_lable = "#212529";

        testText(password_lable, expect_text_password_lable);
        testColor(password_lable, expect_color_password_lable);

        WebElement password_input = getWebElementByXPath(driver, "//*[@id=\"validationCustom03\"]");

        String expect_background_color_password_input = "#ffffff";
        String expect_type_password_input = "password";

        testBackgroundColor(password_input, expect_background_color_password_input);
        testInputType(password_input, expect_type_password_input);


        WebElement confirmPassword_lable = getWebElementByXPath(driver, "/html/body/div/form/div[4]/label");

        String expect_text_confirmPassword_lable = "Nhập lại mật khẩu";
        String expect_color_confirmPassword_lable = "#212529";

        testText(confirmPassword_lable, expect_text_confirmPassword_lable);
        testColor(confirmPassword_lable, expect_color_confirmPassword_lable);

        WebElement confirmPassword_input = getWebElementByXPath(driver, "//*[@id=\"validationCustom03\"]");

        String expect_background_color_confirmPassword_input = "#ffffff";
        String expect_type_confirmPassword_input = "password";

        testBackgroundColor(confirmPassword_input, expect_background_color_confirmPassword_input);
        testInputType(confirmPassword_input, expect_type_confirmPassword_input);

        WebElement user_image = getWebElementByXPath(driver, "/html/body/div/form/div[5]/label");
        String expect_text_user_image_input = "Chọn ảnh đại diện";
        testText(user_image, expect_text_user_image_input);

        WebElement user_image_input = getWebElementByXPath(driver, "//*[@id=\"exampleFormControlFile1\"]");
        String expect_type_user_image_input = "file";
        testInputType(user_image_input, expect_type_user_image_input);


        //test giá trị của link: tạo tài khoản?
        WebElement Login_link = getWebElementByXPath(driver, "/html/body/div/form/div[6]/a");

        String expect_text_Login_link = "Đã có tài khoản?";
        String expect_color_Login_link = "#007bff";

        testText(Login_link, expect_text_Login_link);
        testColor(Login_link, expect_color_Login_link);


        //test kích thước nút đăng ký
        WebElement login_button = getWebElementById(driver, "submitBtn");

        String expect_color_login_button = "#ffffff";
        String expect_background_color_login_button = "#007bff";
        String expect_text_login_button = "Đăng ký";

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
