package BlackBox.Account;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL+"/Account_Controller/login");

    @Test
    public void test() {
        testBlankUserName();
        testBlankPassword();
        testFailLogin();
        testSuccessLogin();

        driver.close();
    }

    //Trường hợp tên tài khoản để trống.
    @Test
    public void testBlankUserName() {
        driver.navigate().refresh();
        WebElement login_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");
        WebElement password_input = getWebElementByXPath(driver, "//*[@id=\"validationCustom03\"]");

        password_input.sendKeys(getSaltString());
        login_button.click();

        WebElement password_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[1]/div/div");
        String expect_password_validation_message = "Vui lòng nhập tên đầy đủ.";
        testText(password_validation_message, expect_password_validation_message);
    }

    //Trường hợp mật khẩu để trống.
    @Test
    public void testBlankPassword() {
        driver.navigate().refresh();
        WebElement login_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");
        WebElement user_name_input = getWebElementByXPath(driver, "//*[@id=\"validationCustomUsername\"]");

        user_name_input.sendKeys(getSaltString());
        login_button.click();

        WebElement user_name_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[2]/div");
        String expect_user_name_validation_message = "Vui lòng nhập mật khẩu.";
        testText(user_name_validation_message, expect_user_name_validation_message);
    }

    //Trường hợp đăng nhập thất bại( tài khoản không tồn tại, tên tài khoản hoặc mật khấu không đúng).
    @Test
    public void testFailLogin() {
        driver.navigate().refresh();
        WebElement login_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");
        WebElement user_name_input = getWebElementByXPath(driver, "//*[@id=\"validationCustomUsername\"]");
        WebElement password_input = getWebElementByXPath(driver, "//*[@id=\"validationCustom03\"]");

        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(getSaltString());

        login_button.click();

        WebElement fail_login_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[3]");
        String expect_fail_login_validation_message = "Tài khoản hoặc mật khẩu không chính xác.";
        testText(fail_login_validation_message, expect_fail_login_validation_message);
    }

    //Trường hợp đăng nhập tài khoản thành công.
    @Test
    public void testSuccessLogin() {
        driver.navigate().refresh();
        WebElement login_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");
        WebElement user_name_input = getWebElementByXPath(driver, "//*[@id=\"validationCustomUsername\"]");
        WebElement password_input = getWebElementByXPath(driver, "//*[@id=\"validationCustom03\"]");

        user_name_input.sendKeys(Config.USER.get("username"));
        password_input.sendKeys(Config.USER.get("password"));

        login_button.click();

        WebElement user_icon=getWebElementByXPath(driver,"/html/body/nav[1]/div/div[2]/i");

        hover(driver,user_icon);

        WebElement profile = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[1]/a");
        String expect_text_profile="Thông tin tài khoản";
        testText(profile,expect_text_profile);
    }
}
