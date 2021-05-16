package WhiteBox.Home;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Sort extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Book_Controller/books");

    @Test
    public void test() {
        testSortButton();
        driver.close();
    }

    //Kiểm tra nút sắp xếp.
    @Test
    public void testSortButton()  {
        WebElement sort_button = getWebElementByXPath(driver, "//button[@class='form-control mr-sm-2']");
        String expect_text_sort_button = "Sắp xếp";
        String expect_background_color_sort_button = "#ffffff";
        String expect_color_sort_button = "#495057";
        int expect_height_sort_button = 38;
        int expect_width_sort_button = 92;

        testText(sort_button,expect_text_sort_button);
        testBackgroundColor(sort_button, expect_background_color_sort_button);
        testColor(sort_button, expect_color_sort_button);
        testHeight(sort_button, expect_height_sort_button);
        testWidth(sort_button, expect_width_sort_button);

//        driver.close();
    }

    @AfterClass
    public static void onDestroy() {
        driver.quit();
    }
}
