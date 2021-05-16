package WhiteBox.Book;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

import static BlackBox.TestFunction.TestFunction.LoginAsAdmin;

public class Delete extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");

    @BeforeClass
    public static void login() {
        LoginAsAdmin(driver);
    }

    @Test
    public void test() throws InterruptedException {
        testDeleteButton();
        driver.close();
    }

    //Kiểm tra nút xóa sách.
    @Test
    public void testDeleteButton() throws InterruptedException {
        WebElement delete_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(2)");
        String expect_color_delete_button = "#007bff";
        String expect_background_color_delete_button = "#000000";
        String expect_text_delete_button = "Xóa";
        int expect_height_delete_button = 38;

        testColor(delete_button, expect_color_delete_button);
        testBackgroundColor(delete_button, expect_background_color_delete_button);
        testText(delete_button, expect_text_delete_button);
        testHeight(delete_button, expect_height_delete_button);

//        driver.close();
    }


    @AfterClass
    public static void onDestroy() {
        driver.quit();
    }
}
