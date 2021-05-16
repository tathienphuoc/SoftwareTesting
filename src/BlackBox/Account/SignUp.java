package BlackBox.Account;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL+"/Account_Controller/register");

    @Test
    public void test() {
        testBlankFullName();
        testBlankUserName();
        testBlankPassword();
        testBlankConfirmPassword();
        testUnMatchPassword();
        testInvalidPassword();
        testAlreadyExistUserName();
        testSuccessSignUp();

        driver.close();
    }

    //Trường hợp tên đầy đủ để trống.
    @Test
    public void testBlankFullName() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(getSaltString());
        confirm_password_input.sendKeys(getSaltString());

        sign_up_button.click();

        WebElement full_name_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[1]/div");
        String expect_full_name_validation_message = "Vui lòng nhập tên đầy đủ.";
        testText(full_name_validation_message, expect_full_name_validation_message);
    }

    //Trường hợp tên tài khoản để trống.
    @Test
    public void testBlankUserName() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        full_name_input.sendKeys(getSaltString());
        password_input.sendKeys(getSaltString());
        confirm_password_input.sendKeys(getSaltString());

        sign_up_button.click();

        WebElement user_name_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[2]/div/div");
        String expect_user_name_validation_message = "Vui lòng nhập tên tài khoản.";
        testText(user_name_validation_message, expect_user_name_validation_message);
    }

    //Trường hợp mật khẩu để trống.
    @Test
    public void testBlankPassword() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(getSaltString());
        confirm_password_input.sendKeys(getSaltString());

        sign_up_button.click();

        WebElement password_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[3]/div");
        String expect_password_validation_message = "Vui lòng nhập mật khẩu.";
        testText(password_validation_message, expect_password_validation_message);
    }

    //Trường hợp nhập lại mật khẩu để trống.
    @Test
    public void testBlankConfirmPassword() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(getSaltString());

        sign_up_button.click();

        WebElement confirm_password_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[4]/div");
        String expect_confirm_password_validation_message = "Vui lòng nhập lại mật khẩu.";
        testText(confirm_password_validation_message, expect_confirm_password_validation_message);
    }

    //Trường hợp mật khẩu và mật khẩu nhập lại không khớp.
    @Test
    public void testUnMatchPassword() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(getSaltString());
        confirm_password_input.sendKeys(getSaltString());

        sign_up_button.click();

        WebElement unmatch_password_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[6]");
        String expect_unmatch_password_validation_message = "Mật khẩu nhập lại không khớp.";
        testText(unmatch_password_validation_message, expect_unmatch_password_validation_message);
    }

    //Trường hợp mật khẩu không thỏa các quy định về mật khẩu.
    @Test
    public void testInvalidPassword() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        String passwordString=getSaltString().toLowerCase();

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(passwordString);
        confirm_password_input.sendKeys(passwordString);

        sign_up_button.click();

        WebElement invalid_password_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[6]");
        String expect_invalid_password_validation_message = "Độ dài mật khẩu phải lớn hơn 8 ký tự bao gồm chữ hoa, chữ thường và số.";
        testText(invalid_password_validation_message, expect_invalid_password_validation_message);
    }

    //Trường hợp tên tài khoản đã tồn tại.
    @Test
    public void testAlreadyExistUserName() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        String passwordString=getSaltString();

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(Config.USER.get("username"));
        password_input.sendKeys(passwordString);
        confirm_password_input.sendKeys(passwordString);

        sign_up_button.click();

        WebElement already_exist_user_name_validation_message = getWebElementByXPath(driver, "/html/body/div/form/div[6]");
        String expect_already_exist_user_name_validation_message = "Tài khoản đã tồn tại.";
        testText(already_exist_user_name_validation_message, expect_already_exist_user_name_validation_message);
    }

    //Trường hợp đăng ký tài khoản thành công.
    @Test
    public void testSuccessSignUp() {
        driver.navigate().refresh();
        WebElement sign_up_button = getWebElementByXPath(driver, "//*[@id=\"submitBtn\"]");

        WebElement full_name_input = getWebElementByName(driver, "fullname");
        WebElement user_name_input = getWebElementByName(driver, "username");
        WebElement password_input = getWebElementByName(driver, "password");
        WebElement confirm_password_input = getWebElementByName(driver, "confirm_password");

        String passwordString=getSaltString();

        full_name_input.sendKeys(getSaltString());
        user_name_input.sendKeys(getSaltString());
        password_input.sendKeys(passwordString);
        confirm_password_input.sendKeys(passwordString);

        sign_up_button.click();

        WebElement login_title = getWebElementByXPath(driver, "/html/body/div/form/h1");
        String expect_login_title = "Đăng nhập tài khoản";
        testText(login_title, expect_login_title);
    }
}
