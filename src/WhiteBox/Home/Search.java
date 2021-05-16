package WhiteBox.Home;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Search extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Book_Controller/books");

    @Test
    public void test() {
        testSearchButton();
        testSearchInput();
        driver.close();
    }

    //Kiểm tra nút tìm kiếm theo tiêu đề sách.
    @Test
    public void testSearchButton() {
        WebElement search_button = getWebElementByXPath(driver, "/html/body/nav[1]/div/form/button");
        String expect_color_search_button = "#28a745";
        String expect_background_color_search_button = "#000000";
        int expect_height_search_button = 38;
        int expect_width_search_button = 56;

        testColor(search_button, expect_color_search_button);
        testBackgroundColor(search_button, expect_background_color_search_button);
        testHeight(search_button, expect_height_search_button);
        testWidth(search_button, expect_width_search_button);

//        driver.close();
    }

    //Kiểm tra ô tìm kiếm theo tiêu đề sách.
    @Test
    public void testSearchInput() {
        WebElement search_input = getWebElementByXPath(driver, "/html/body/nav[1]/div/form/input");
        String expect_color_search_input = "#495057";
        String expect_background_color_search_input = "#ffffff";
        String expect_type_search_input = "text";
        String expect_placeHolder_search_input = "Tìm kiếm";
        int expect_height_search_input = 38;
        int expect_width_search_input = 220;

        testColor(search_input,expect_color_search_input);
        testBackgroundColor(search_input,expect_background_color_search_input);
        testInputType(search_input,expect_type_search_input);
        testPlaceHolder(search_input,expect_placeHolder_search_input);
        testHeight(search_input,expect_height_search_input);
        testWidth(search_input,expect_width_search_input);

//        driver.close();
    }


    @AfterClass
    public static void onDestroy() {
        driver.quit();
    }
}
