package BlackBox.Home;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sort extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL+ "/Book_Controller/books");

    @Test
    public void test() {
        testSortByPrice();
        testSortByTitle();
        driver.close();
    }

    //Trường hợp sắp xếp theo giá.
    @Test
    public void testSortByPrice(){
        navigateTo(driver,Config.BaseURL+ "/Book_Controller/books");

        WebElement sort_button=getWebElementByXPath(driver,"/html/body/nav[1]/div/div[1]/button");
        hover(driver,sort_button);

        WebElement sort_by_price_button=getWebElementByXPath(driver,"/html/body/nav[1]/div/div[1]/div/a[2]");
        sort_by_price_button.click();

    }

    //Trường hợp sắp xếp theo tên.
    @Test
    public void testSortByTitle(){
        navigateTo(driver,Config.BaseURL+ "/Book_Controller/books");

        WebElement sort_button=getWebElementByXPath(driver,"/html/body/nav[1]/div/div[1]/button");
        hover(driver,sort_button);

        WebElement sort_by_title_button=getWebElementByXPath(driver,"/html/body/nav[1]/div/div[1]/div/a[1]");
        sort_by_title_button.click();

    }
}
