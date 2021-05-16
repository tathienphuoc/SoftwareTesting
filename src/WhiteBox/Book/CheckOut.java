package WhiteBox.Book;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static BlackBox.TestFunction.TestFunction.LoginAsUser;

public class CheckOut extends TestCSS {
    public static WebDriver driver = Config.run(Config.BaseURL + "/Account_Controller/login");

    @BeforeClass
    public static void setup() {
        LoginAsUser(driver);

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html/body/nav[1]/div/div[2]/i"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/nav[1]/div/div[2]/ul/li[3]/a"))).click().build().perform();
    }

    @Test
    public void test() {
        testProductTable();
        testPaymentForm();
    }

    //Kiểm tra giỏ hàng.
    @Test
    public void testProductTable() {

        //Kiểm tra màu thead
        WebElement thead = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/thead/tr/th[1]");
        String expect_background_color_thead = "#f8f9fa";
        testBackgroundColor(thead, expect_background_color_thead);

        //Kiểm tra div chứ bảng sản phẩm
        WebElement margin_bottom_table_product = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div"));

        String expect_margin_bottom_table_product = "48px";
        testMarginBottom(margin_bottom_table_product, expect_margin_bottom_table_product);

        // kiểm tra tiêu sản phẩm đề của bảng
        WebElement title_product_name = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/thead/tr/th[1]/div");
        String expect_text_title_product_name = "SẢN PHẨM";
        testText(title_product_name, expect_text_title_product_name);

        // kiểm tra tiêu giá của bảng
        WebElement title_product_price = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/thead/tr/th[3]/div");
        String expect_text_title_product_price = "GIÁ";
        testText(title_product_price, expect_text_title_product_price);

        // kiểm tra tiêu giá của bảng
        WebElement title_product_date = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/thead/tr/th[4]/div");
        String expect_text_title_product_date = "NGÀY ĐẶT HÀNG";
        testText(title_product_date, expect_text_title_product_date);

        // kiểm tra tiêu giá của bảng
        WebElement title_product_delete = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/thead/tr/th[5]/div");
        String expect_text_title_product_delete = "XÓA";
        testText(title_product_delete, expect_text_title_product_delete);

        //Table product trống
        try {
            //Kiểm tra hình ảnh của sản phẩm
            WebElement product_image = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/tbody/tr/th/div/img");
            int expect_height_product_image = 70;
            int expect_width_product_image = 70;
            testHeight(product_image, expect_height_product_image);
            testWidth(product_image, expect_width_product_image);


            //Kiểm tra icon thùng rác xoá sản phẩm
            WebElement delete_product_icon = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/tbody/tr/td[4]/a/i[2]");
            int expect_height_delete_product_icon = 16;
            int expect_width_delete_product_icon = 12;
            testHeight(delete_product_icon, expect_height_delete_product_icon);
            testWidth(delete_product_icon, expect_width_delete_product_icon);

        } catch (TimeoutException ex) {
            // Do something when the second button does not exist
        }
    }

    //Kiểm tra form thanh toán.
    @Test
    public void testPaymentForm() {
        // Kiểm trả chiều dài và rộng của div container
        WebElement container_div = getWebElementByXPath(driver, "/html/body/div/div[2]/div/form/div");
        int expect_height_container_div = 719;
        int expect_width_container_div = 1140;
        testHeight(container_div,expect_height_container_div);
        testWidth(container_div,expect_width_container_div);

        //Kiểm tra title div phương thức thánh toán
        WebElement title_payment = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div[1]/div[1]"));
        String expect_background_color_title_payment = "#f8f9fa";
        testBackgroundColor(title_payment,expect_background_color_title_payment);

        //Kiểm tra title div hoá đơn
        WebElement title_receipt = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div[2]/div[1]"));
        String expect_background_color_title_receipt = "#f8f9fa";
        testBackgroundColor(title_receipt,expect_background_color_title_receipt);

        //Kiểm tra ảnh các credit cards
        // master card
        WebElement master_card = getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[1]/div/div/img[1]");
        String expect_source_image_master_card = "https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Mastercard-Curved.png";
        testSourceImage(master_card,expect_source_image_master_card);

        // discover card
        WebElement discover_card = getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[1]/div/div/img[2]");
        String expect_source_image_discover_card = "https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Discover-Curved.png";
        testSourceImage(discover_card,expect_source_image_discover_card);

        // discover card
        WebElement paypal_card = getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[1]/div/div/img[3]");
        String expect_source_image_paypal_card = "https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Paypal-Curved.png";
        testSourceImage(paypal_card,expect_source_image_paypal_card);

        //  American express  card
        WebElement american_express_card = getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[1]/div/div/img[4]");
        String expect_source_image_american_express_card = "https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/American-Express-Curved.png";
        testSourceImage(american_express_card,expect_source_image_american_express_card);

        //Kiểm tra label Tên chủ tài khoản
        WebElement card_onwer_label=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[2]/div[1]/span/label");
        WebElement card_onwer_input = getWebElementByXPath(driver, "//*[@id=\"cardOwner\"]");
        String expect_text_card_onwer_label="Tên chủ tài khoản";
        String expect_placeHolder_card_onwer_input="Đại học Sài Gòn";
        testText(card_onwer_label,expect_text_card_onwer_label);
        testPlaceHolder(card_onwer_input,expect_placeHolder_card_onwer_input);

        //Kiểm tra label Địa chỉ giao hàng
        WebElement address_label=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[2]/div[3]/span[1]/label");
        WebElement address_input = getWebElementByXPath(driver, "//*[@id=\"address\"]");
        String expect_text_address_label="Địa chỉ giao hàng";
        String expect_placeHolder_address_input="273 An Dương Vương, Phường 3, Quận 5";
        testText(address_label,expect_text_address_label);
        testPlaceHolder(address_input,expect_placeHolder_address_input);

        //Kiểm tra label Số tài khoản
        WebElement card_number_label=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[2]/div[2]/span[1]/label");
        WebElement card_number_input = getWebElementByXPath(driver, "//*[@id=\"cardNumber\"]");
        String expect_text_card_number_label="Số tài khoản";
        String expect_placeHolder_card_number_input="1606201036100";
        testText(card_number_label,expect_text_card_number_label);
        testPlaceHolder(card_number_input,expect_placeHolder_card_number_input);

        //Kiểm tra label Thành phố
        WebElement city_label=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[2]/div[4]/span[1]/label");
        WebElement city_input = getWebElementByXPath(driver, "//*[@id=\"city\"]");
        String expect_text_city_label="Thành phố";
        String expect_placeHolder_city_input="Thành phố Hồ Chí Minh";
        testText(city_label,expect_text_city_label);
        testPlaceHolder(city_input,expect_placeHolder_city_input);

        //Kiểm tra label Số điện thoại liên lạc
        WebElement phone_number_label=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[1]/div[2]/div[2]/div[5]/span[1]/label");
        WebElement phone_number_input = getWebElementByXPath(driver, "//*[@id=\"phoneNumber\"]");
        String expect_text_phone_number_label="Số điện thoại liên lạc";
        String expect_placeHolder_phone_number_input="(028) 38382 664";
        testText(phone_number_label,expect_text_phone_number_label);
        testPlaceHolder(phone_number_input,expect_placeHolder_phone_number_input);

        //Kiểm tra p chi phí vận chuyển
        WebElement fee_ship_p=getWebElementByXPath(driver,"/html/body/div/div[2]/div/form/div/div[2]/div[2]/p");
        String expect_text_fee_ship_p="Chi phí vận chuyển sẽ bằng 5% chi phí đơn hàng";
        String expect_font_style_fee_ship_p="italic";
        testText(fee_ship_p,expect_text_fee_ship_p);
        testFontStyle(fee_ship_p,expect_font_style_fee_ship_p);

        // Kiểm trả button thanh toán
        WebElement checkout_button = getWebElementById(driver, "btnSubmit");
        String expect_color_checkout_button = "#ffffff";
        String expect_background_color_checkout_button = "#343a40";
        String expect_text_checkout_button = "Thanh toán";
        testColor(checkout_button,expect_color_checkout_button);
        testBackgroundColor(checkout_button,expect_background_color_checkout_button);
        testText(checkout_button,expect_text_checkout_button);

        // Kiểm tra button tiếp tục mua sắm
        WebElement continue_buy_button = getWebElementByXPath(driver, "/html/body/div/div[2]/div/form/div/div[2]/div[2]/div/a");
        String expect_color_continue_buy_button = "#007bff";
        String expect_text_continue_buy_button = "Tiếp tục mua sắm";
        testColor(continue_buy_button,expect_color_continue_buy_button);
        testText(continue_buy_button,expect_text_continue_buy_button);

    }
}
