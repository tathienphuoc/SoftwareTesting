package BlackBox.Book;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Delete extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");
    public static HashMap<String, String> BookToTest;

    @BeforeClass
    public static void setup() {
        driver.findElement(By.id("validationCustomUsername")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.id("submitBtn")).click();
    }

    @Test
    public void test() {
        testCancelDeleteBook();
        testAcceptDeleteBook();
        testAcceptDeleteBookInCart();
    }

    //Trường hợp hủy xác nhận xóa sách.
    @Test
    public void testCancelDeleteBook() {
        BookToTest = createBookToTest(driver);

        WebElement delete_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(2)");
        delete_button.click();

        Alert confirm_alert = getConfirmAlert(driver);
        confirm_alert.dismiss();

        WebElement title = getWebElementByXPath(driver, "/html/body/div/div/div[1]/h5");
        testText(title, BookToTest.get("title"));
    }

    //Trường hợp đồng ý xác nhận xóa sách.
    @Test
    public void testAcceptDeleteBook() {
        BookToTest = createBookToTest(driver);

        WebElement delete_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(2)");
        delete_button.click();

        Alert confirm_alert = getConfirmAlert(driver);
        confirm_alert.accept();

        driver.navigate().refresh();
        WebElement title = getWebElementByXPath(driver, "/html/body/div/div/div[1]/h5");
        testTextNotEquals(title, BookToTest.get("title"));
    }

    //Trường hợp xóa sách thất bại.
    @Test
    public void testAcceptDeleteBookInCart() {
        buyBookToTest(driver);

        LoginAsAdmin(driver);

        WebElement delete_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(2)");
        delete_button.click();

        Alert confirm_alert = getConfirmAlert(driver);
        confirm_alert.accept();

        Alert fail_delete_alert = getConfirmAlert(driver);
        String expect_text_fail_delete_alert = "Xóa thất bại!";
        testAlertMessage(fail_delete_alert, expect_text_fail_delete_alert);
        fail_delete_alert.dismiss();
    }
}
