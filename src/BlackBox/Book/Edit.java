package BlackBox.Book;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Edit extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL);
    public static HashMap<String, String> BookToTest;


    @BeforeClass
    public static void setup() {
        LoginAsAdmin(driver);
        BookToTest = createBookToTest(driver);
        WebElement edit_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(1)");
        edit_button.click();
    }

    @Test
    public void test() {
        testBlankTitle();
        testBlankPrice();
        testNonPositivePrice();
        testBlankPublishYear();
        testNonPositivePublishYear();
        testEditBook();
    }

    //Trường hợp tiêu đề sách để trống.
    @Test
    public void testBlankTitle() {
        driver.navigate().refresh();
        WebElement title = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        title.clear();
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        submit_button.click();

        String title_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        String expect_title_validation_message = "Please fill out this field.";
        testStringEquals(title_validation_message, expect_title_validation_message);
    }

    //Trường hợp giá sách để trống.
    @Test
    public void testBlankPrice() {
        driver.navigate().refresh();
        WebElement price = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        price.clear();
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        String expect_price_validation_message = "Please enter a number.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp giá sách không là số > 0.
    @Test
    public void testNonPositivePrice() {
        driver.navigate().refresh();
        WebElement price = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        price.sendKeys(String.valueOf(randNumber(Integer.MIN_VALUE, 0)));
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        String expect_price_validation_message = "Please select a value that is no less than 1.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp năm xuất bản sách để trống.
    @Test
    public void testBlankPublishYear() {
        driver.navigate().refresh();
        WebElement publish_year = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        publish_year.clear();
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        String expect_price_validation_message = "Please enter a number.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp năm xuất bản sách không là số > 1000.
    @Test
    public void testNonPositivePublishYear() {
        driver.navigate().refresh();
        WebElement publish_year = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        publish_year.sendKeys(String.valueOf(randNumber(Integer.MIN_VALUE, 999)));
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        String expect_price_validation_message = "Please select a value that is no less than 1000.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp chỉnh sửa sách thành công.
    @Test
    public void testEditBook() {
        driver.navigate().refresh();

        WebElement title_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement publish_year_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement save_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");

        title_input.sendKeys(getSaltString());
        price_input.sendKeys(String.valueOf(randNumber(1,10000000)));
        publish_year_input.sendKeys(String.valueOf(randNumber(1000,2020)));

        save_button.click();

        WebElement title=getWebElementByXPath(driver,"/html/body/div/div/div[1]/h5");
        testTextNotEquals(title,BookToTest.get("title"));
    }
}
