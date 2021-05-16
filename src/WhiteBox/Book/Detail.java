package WhiteBox.Book;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static BlackBox.TestFunction.TestFunction.LoginAsUser;

public class Detail extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");

    @BeforeClass
    public static void setup() {
        LoginAsUser(driver);
        WebElement detail_button = getWebElementByXPath(driver, "/html/body/div/div/div[1]/a");
        detail_button.click();
    }

    @Test
    public void test(){
        testDetail();
    }

    //Kiểm tra trang chi tiết sách.
    @Test
    public void testDetail() {
        //kt màu title
        WebElement title = getWebElementByClassName(driver, "single-product-name");
        String expect_color_title = "#444444";
        testColor(title, expect_color_title);

        //kt màu tác giả
        WebElement author = getWebElementByClassName(driver, "product-sku");
        String expect_color_author = "#212529";
        testColor(author, expect_color_author);

        //kt màu giá
        WebElement price = getWebElementByClassName(driver, "price");
        String expect_color_price = "#212529";
        testColor(author, expect_color_price);

        //kt màu detail
        WebElement detail = getWebElementByClassName(driver, "product-info");
        String expect_color_detail = "#333333";
        testColor(detail, expect_color_detail);


        //kt ô nhập số lượng
        WebElement quantity = getWebElementByClassName(driver, "cart-plus-minus");
        int expect_width_quantity = 100;
        String expect_type_quantity = "number";
        testWidth(quantity, expect_width_quantity);
        testInputType(quantity, expect_type_quantity);


        //kt màu chữ button thêm giỏ hàng
        WebElement add_product_button = getWebElementByClassName(driver, "btn-outline-primary");
        String expect_color_add_product_button = "#007bff";
        String expect_background_color_add_product_button = "#000000";
        String expect_text_add_product_button = "Thêm vào giỏ hàng";
        testColor(add_product_button, expect_color_add_product_button);
        testBackgroundColor(add_product_button, expect_background_color_add_product_button);
        testText(add_product_button, expect_text_add_product_button);


        //kt màu chữ button tiếp tục mua hàng
        WebElement continueBuy_product_button = getWebElementByXPath(driver, "/html/body/div/main/div/div/div/div/div[2]/div/div/div[5]/div[2]/div/form/a");
        String expect_color_continueBuy_product_button = "#007bff";
        String expect_background_color_continueBuy_product_button = "#000000";
        String expect_text_continueBuy_product_button = "Tiếp tục mua sắm";
        testColor(continueBuy_product_button, expect_color_continueBuy_product_button);
        testBackgroundColor(continueBuy_product_button, expect_background_color_continueBuy_product_button);
        testText(continueBuy_product_button, expect_text_continueBuy_product_button);


        //kt màu chữthanh toan
        WebElement checkout_button = getWebElementByXPath(driver, "/html/body/div/main/div/div/div/div/div[2]/div/a");
        String expect_color_checkout_button = "#007bff";
        String expect_background_color_checkout_button = "#000000";
        String expect_text_checkout_button = "Thanh toán";
        testColor(checkout_button, expect_color_checkout_button);
        testBackgroundColor(checkout_button, expect_background_color_checkout_button);
        testText(checkout_button, expect_text_checkout_button);
    }
}
