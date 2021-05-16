package WhiteBox.Book;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

import static BlackBox.TestFunction.TestFunction.LoginAsAdmin;

public class Edit extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");

    @BeforeClass
    public static void login() {
        LoginAsAdmin(driver);

    }

    @Test
    public void test() throws InterruptedException {
        testEditButton();
        testEditForm();
        driver.close();
    }

    //Kiểm tra nút chỉnh sửa.
    @Test
    public void testEditButton() {
        WebElement edit_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(1)");
        String expect_color_edit_button = "#007bff";
        String expect_background_color_edit_button = "#000000";
        String expect_text_edit_button = "Chỉnh sửa";
        int expect_height_edit_button = 38;

        testColor(edit_button, expect_color_edit_button);
        testBackgroundColor(edit_button, expect_background_color_edit_button);
        testText(edit_button, expect_text_edit_button);
        testHeight(edit_button, expect_height_edit_button);

//        driver.close();
    }

    //Kiểm tra form chỉnh sửa.
    @Test
    public void testEditForm() {
        WebElement edit_button = getWebElementByCSSSelector(driver, "div.card:nth-child(1) > div:nth-child(6) > a:nth-child(1)");
        edit_button.click();

        //Back Button
        WebElement back_button = getWebElementByCSSSelector(driver, "div.btn > a:nth-child(1)");
        String expect_color_back_button = "#337ab7";
        String expect_background_color_back_button = "#000000";
        String expect_text_back_button = "Trở về";
        int expect_height_back_button = 15;

        testColor(back_button, expect_color_back_button);
        testBackgroundColor(back_button, expect_background_color_back_button);
        testText(back_button, expect_text_back_button);
        testHeight(back_button, expect_height_back_button);

        //Header
        WebElement header = getWebElementByCSSSelector(driver, ".container > h1:nth-child(1) > strong:nth-child(1)");
        String expect_text_header = "Chỉnh thông tin sản phẩm";
        String expect_color_header = "#333333";
        String expect_background_color_header = "#000000";
        int expect_height_header = 37;
        //Test Header
        testText(header, expect_text_header);
        testHeight(header, expect_height_header);
        testColor(header, expect_color_header);
        testBackgroundColor(header, expect_background_color_header);

        //Body Header
        WebElement title = getWebElementByCSSSelector(driver, ".col-md-9 > h3:nth-child(3)");
        String expect_text_title = "Thông tin sản phẩm";
        String expect_color_title = "#333333";
        String expect_background_color_title = "#000000";
        int expect_height_title = 26;
        //Test Body Header
        testText(title, expect_text_title);
        testHeight(title, expect_height_title);
        testColor(title, expect_color_title);
        testBackgroundColor(title, expect_background_color_title);


        //Body Edit Form

        //Book Image
        WebElement book_image = getWebElementByCSSSelector(driver, ".avatar");
        int expect_height_book_image = 200;
        int expect_width_book_image = 200;
        //TestBook Image
        testHeight(book_image, expect_height_book_image);
        testWidth(book_image, expect_width_book_image);

        //Book Image Title
        WebElement book_image_title = getWebElementByCSSSelector(driver, ".text-center > h6:nth-child(2)");
        String expect_text_book_image_title = "Cập nhật ảnh sản phẩm";
        String expect_color_book_image_title = "#333333";
        String expect_background_color_book_image_title = "#000000";
        int expect_height_book_image_title = 13;
        //TestBook Image
        testText(book_image_title, expect_text_book_image_title);
        testHeight(book_image_title, expect_height_book_image_title);
        testColor(book_image_title, expect_color_book_image_title);
        testBackgroundColor(book_image_title, expect_background_color_book_image_title);

        //Book Image Input
        WebElement book_image_input = getWebElementByCSSSelector(driver, "input.form-control:nth-child(3)");
        String expect_color_book_image_input = "#555555";
        String expect_background_color_book_image_input = "#ffffff";
        int expect_height_book_image_input = 34;
        //Test Book Image Input
        testHeight(book_image_input, expect_height_book_image_input);
        testColor(book_image_input, expect_color_book_image_input);
        testBackgroundColor(book_image_input, expect_background_color_book_image_input);


        //Book Title
        WebElement book_title = getWebElementByCSSSelector(driver, "div.form-group:nth-child(1) > label:nth-child(1)");
        String expect_text_book_title = "Tiêu đề sách:";
        String expect_color_book_title = "#333333";
        String expect_background_color_book_title = "#000000";
        int expect_height_book_title = 27;
        //Test Book Title
        testText(book_title, expect_text_book_title);
        testHeight(book_title, expect_height_book_title);
        testColor(book_title, expect_color_book_title);
        testBackgroundColor(book_title, expect_background_color_book_title);

        //Book Title Input
        WebElement book_title_input = getWebElementByCSSSelector(driver, "div.form-group:nth-child(1) > div:nth-child(2) > input:nth-child(1)");
        String expect_color_book_title_input = "#555555";
        String expect_background_color_book_title_input = "#ffffff";
        int expect_height_book_title_input = 34;
        //Test Book Title Input
        testHeight(book_title_input, expect_height_book_title_input);
        testColor(book_title_input, expect_color_book_title_input);
        testBackgroundColor(book_title_input, expect_background_color_book_title_input);


        //Author
        WebElement author = getWebElementByCSSSelector(driver, "div.form-group:nth-child(2) > label:nth-child(1)");
        String expect_text_author = "Tác giả:";
        String expect_color_author = "#333333";
        String expect_background_color_author = "#000000";
        int expect_height_author = 27;
        //Test Author
        testText(author, expect_text_author);
        testHeight(author, expect_height_author);
        testColor(author, expect_color_author);
        testBackgroundColor(author, expect_background_color_author);

        //Author Dropdown
        WebElement author_dropdown = getWebElementByCSSSelector(driver, "div.form-group:nth-child(2) > div:nth-child(2) > select:nth-child(2)");
        String expect_color_author_dropdown = "#333333";
        String expect_background_color_author_dropdown = "#f6f6f6";
        int expect_height_author_dropdown = 30;
        //Test Author Dropdown
        testHeight(author_dropdown, expect_height_author_dropdown);
        testColor(author_dropdown, expect_color_author_dropdown);
        testBackgroundColor(author_dropdown, expect_background_color_author_dropdown);


        //Book Price
        WebElement book_price = getWebElementByCSSSelector(driver, "div.form-group:nth-child(3) > label:nth-child(1)");
        String expect_text_book_price = "Giá:";
        String expect_color_book_price = "#333333";
        String expect_background_color_book_price = "#000000";
        int expect_height_book_price = 27;
        //Test Book Price
        testText(book_price, expect_text_book_price);
        testHeight(book_price, expect_height_book_price);
        testColor(book_price, expect_color_book_price);
        testBackgroundColor(book_price, expect_background_color_book_price);

        //Book Price Input
        WebElement book_price_input = getWebElementByCSSSelector(driver, "div.form-group:nth-child(3) > div:nth-child(2) > input:nth-child(1)");
        String expect_color_book_price_input = "#555555";
        String expect_background_color_book_price_input = "#ffffff";
        int expect_height_book_price_input = 34;
        //Test Book Price Input
        testHeight(book_price_input, expect_height_book_price_input);
        testColor(book_price_input, expect_color_book_price_input);
        testBackgroundColor(book_price_input, expect_background_color_book_price_input);


        //Book Category
        WebElement book_category = getWebElementByCSSSelector(driver, "div.form-group:nth-child(4) > label:nth-child(1)");
        String expect_text_book_category = "Thể loại:";
        String expect_color_book_category = "#333333";
        String expect_background_color_book_category = "#000000";
        int expect_height_book_category = 27;
        //Test Book Category
        testText(book_category, expect_text_book_category);
        testHeight(book_category, expect_height_book_category);
        testColor(book_category, expect_color_book_category);
        testBackgroundColor(book_category, expect_background_color_book_category);

        //Book Category Dropdown
        WebElement book_category_dropdown = getWebElementByCSSSelector(driver, "div.form-group:nth-child(4) > div:nth-child(2) > select:nth-child(2)");
        String expect_color_book_category_dropdown = "#333333";
        String expect_background_color_book_category_dropdown = "#f6f6f6";
        int expect_height_book_category_dropdown = 30;
        //Test Book Category Dropdown
        testHeight(book_category_dropdown, expect_height_book_category_dropdown);
        testColor(book_category_dropdown, expect_color_book_category_dropdown);
        testBackgroundColor(book_category_dropdown, expect_background_color_book_category_dropdown);


        //Publish Year
        WebElement publish_year = getWebElementByCSSSelector(driver, "div.form-group:nth-child(5) > label:nth-child(1)");
        String expect_text_publish_year = "Năm phát hành:";
        String expect_color_publish_year = "#333333";
        String expect_background_color_publish_year = "#000000";
        int expect_height_publish_year = 27;
        //Test Publish Year
        testText(publish_year, expect_text_publish_year);
        testHeight(publish_year, expect_height_publish_year);
        testColor(publish_year, expect_color_publish_year);
        testBackgroundColor(publish_year, expect_background_color_publish_year);

        //Publish Year Input
        WebElement publish_year_input = getWebElementByCSSSelector(driver, "div.form-group:nth-child(5) > div:nth-child(2) > input:nth-child(1)");
        String expect_color_publish_year_input = "#555555";
        String expect_background_color_publish_year_input = "#ffffff";
        int expect_height_publish_year_input = 34;
        //Test Publish Year Input
        testHeight(publish_year_input, expect_height_publish_year_input);
        testColor(publish_year_input, expect_color_publish_year_input);
        testBackgroundColor(publish_year_input, expect_background_color_publish_year_input);


        //Book Description
        WebElement book_description = getWebElementByCSSSelector(driver, "div.form-group:nth-child(6) > label:nth-child(1)");
        String expect_text_book_description = "Trích dẫn:";
        String expect_color_book_description = "#333333";
        String expect_background_color_book_description = "#000000";
        int expect_height_book_description = 20;
        //Test Book Description
        testText(book_description, expect_text_book_description);
        testHeight(book_description, expect_height_book_description);
        testColor(book_description, expect_color_book_description);
        testBackgroundColor(book_description, expect_background_color_book_description);

        //Book Description Input
        WebElement book_description_input = getWebElementByCSSSelector(driver, "textarea.form-control");
        String expect_color_book_description_input = "#555555";
        String expect_background_color_book_description_input = "#ffffff";
        int expect_height_book_description_input = 106;
        //Test Book Description Input
        testHeight(book_description_input, expect_height_book_description_input);
        testColor(book_description_input, expect_color_book_description_input);
        testBackgroundColor(book_description_input, expect_background_color_book_description_input);

        //Save Edit
        WebElement save_edit_button = getWebElementByCSSSelector(driver, "#btnSubmit");
        String expect_color_save_edit_button = "#ffffff";
        String expect_background_color_save_edit_button = "#337ab7";
        String expect_text_save_edit_button = "Lưu";
        int expect_height_save_edit_button = 34;

        testColor(save_edit_button, expect_color_save_edit_button);
        testBackgroundColor(save_edit_button, expect_background_color_save_edit_button);
        testValue(save_edit_button, expect_text_save_edit_button);
        testHeight(save_edit_button, expect_height_save_edit_button);

//        driver.close();
    }

    @AfterClass
    public static void onDestroy() {
        driver.quit();
    }
}
