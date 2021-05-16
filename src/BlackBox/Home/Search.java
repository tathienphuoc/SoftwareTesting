package BlackBox.Home;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL+ "/Book_Controller/books");

    @Test
    public void test() {
        testFailSearch();
        testSuccessSearch();
        driver.close();
    }

    //Trường hợp không tìm thấy kết quả.
    @Test
    public void testFailSearch(){
        navigateTo(driver,Config.BaseURL+ "/Book_Controller/books");
        WebElement search_input = getWebElementByName(driver, "search");
        WebElement search_button = getWebElementByXPath(driver, "/html/body/nav[1]/div/form/button");
        search_input.sendKeys(getSaltString());
        search_button.click();

        WebElement result=getWebElementByXPath(driver,"/html/body/h1");
        String expect_text_result="Không tìm thấy kết quả.";
        testText(result,expect_text_result);
    }

    //Trường hợp tìm thấy kết quả.
    @Test
    public void testSuccessSearch(){
        navigateTo(driver,Config.BaseURL+ "/Book_Controller/books");

        String first_book_text_title = getWebElementByXPath(driver, "/html/body/div/div/div[1]/h5").getText();

        WebElement search_input = getWebElementByName(driver, "search");
        WebElement search_button = getWebElementByXPath(driver, "/html/body/nav[1]/div/form/button");
        search_input.sendKeys(first_book_text_title);
        search_button.click();

        WebElement first_book_result = getWebElementByXPath(driver, "/html/body/div/h5[2]");
        testText(first_book_result,first_book_text_title);
    }
}
