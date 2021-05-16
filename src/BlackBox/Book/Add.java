package BlackBox.Book;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL);

    @BeforeClass
    public static void setup() {
        LoginAsAdmin(driver);
        WebElement add_button = getWebElementByCSSSelector(driver, "li.nav-item:nth-child(2) > a:nth-child(1)");
        add_button.click();
    }

    @Test
    public void test() {
        testBlankTitle();
        testBlankPrice();
        testNonPositivePrice();
        testBlankPublishYear();
        testNonPositivePublishYear();
        testAddBook();
        driver.close();
    }

    //Trường hợp tiêu đề sách để trống.
    @Test
    public void testBlankTitle() {
        driver.navigate().refresh();
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
        WebElement title = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        title.sendKeys(getSaltString());
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        String expect_price_validation_message = "Please enter a number.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp giá sách không là số > 0.
    @Test
    public void testNonPositivePrice() {
        driver.navigate().refresh();
        WebElement title = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        title.sendKeys(getSaltString());
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
        WebElement title = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        title.sendKeys(getSaltString());
        price.sendKeys(String.valueOf(randNumber(Integer.MAX_VALUE, 1)));
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        String expect_price_validation_message = "Please enter a number.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp năm xuất bản sách không là số > 1000.
    @Test
    public void testNonPositivePublishYear() {
        driver.navigate().refresh();
        WebElement title = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement publish_year = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement submit_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        title.sendKeys(getSaltString());
        price.sendKeys(String.valueOf(randNumber(Integer.MAX_VALUE, 1)));
        publish_year.sendKeys(String.valueOf(randNumber(Integer.MIN_VALUE, 999)));
        submit_button.click();

        String price_validation_message = getValidationMessageByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        String expect_price_validation_message = "Please select a value that is no less than 1000.";
        testStringEquals(price_validation_message, expect_price_validation_message);
    }

    //Trường hợp tạo sách thành công.
    @Test
    public void testAddBook() {
        driver.navigate().refresh();

        String title=getSaltString();
        int price =randNumber(1,10000000);
        int publishYear =randNumber(1000,2020);

        WebElement title_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement publish_year_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement save_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");

        title_input.sendKeys(title);
        price_input.sendKeys(String.valueOf(price));
        publish_year_input.sendKeys(String.valueOf(publishYear));

        save_button.click();

        WebElement titleElement=getWebElementByXPath(driver,"/html/body/div/div/div[1]/h5");
        testText(titleElement,title);
    }
}
