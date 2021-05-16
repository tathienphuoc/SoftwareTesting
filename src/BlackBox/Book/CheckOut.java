package BlackBox.Book;

import BlackBox.TestFunction.TestFunction;
import Configuration.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class CheckOut extends TestFunction {
    public static WebDriver driver = Config.run(Config.BaseURL);
    public static HashMap<String, String> BookToTest;
    public static String card_owner_text = "Đại Học Sài Gòn";
    public static String card_number_text = String.valueOf(randNumber(1000000000, Integer.MAX_VALUE));
    public static String address_text = getSaltString();
    public static String city_text = getSaltString();
    public static String phone_number_text = String.valueOf(randNumber(1000000000, Integer.MAX_VALUE));
    ;


    @BeforeClass
    public static void setup() {
        LoginAsAdmin(driver);
    }

    @Test
    public void test() {
        testAddBookToShoppingCart();
        testDeleteBookInShoppingCart();
        testBlankPaymentForm();
        testSuccessPaymentForm();
        testCardOwnerContainerNumber();
        testCardOwnerNotTitleCase();
        testInvalidCardNumber();
        driver.close();
    }

    //Trường hợp thêm sách vào giỏ hàng.
    @Test
    public void testAddBookToShoppingCart() {
        BookToTest = createBookToTest(driver);

        navigateTo(driver, Config.BaseURL + "/Book_Controller/books");

        WebElement detail_button = getWebElementByXPath(driver, "/html/body/div/div/div[1]/a");
        detail_button.click();

        WebElement quantity_number = getWebElementByXPath(driver, "/html/body/div/main/div/div/div/div/div[2]/div/div/div[5]/div[2]/div/form/input");
        WebElement add_product_button = getWebElementByClassName(driver, "btn-outline-primary");

        quantity_number.clear();
        quantity_number.sendKeys(String.valueOf(randNumber(1, 10)));
        add_product_button.click();

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");

        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();

        testExistText(driver, BookToTest.get("title"));
    }

    //Trường hợp xóa sách đã có trong giỏ hàng.
    @Test
    public void testDeleteBookInShoppingCart() {
        testAddBookToShoppingCart();

        WebElement first_book = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/tbody/tr[1]/th/div/div/h5/a");
        String first_book_title = first_book.getText();

        WebElement first_book_delete_icon = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/tbody/tr/td[4]/a");
        first_book_delete_icon.click();

        try {
            WebElement second_book = getWebElementByXPath(driver, "/html/body/div/div[2]/div/div/div/div/table/tbody/tr[1]/th/div/div/h5/a");
            String second_book_title = second_book.getText();

            testStringNotEquals(first_book_title, second_book_title);
        } catch (TimeoutException ex) {

        }
    }

    //Trường hợp thông tin thanh toán để trống.
    @Test
    public void testBlankPaymentForm() {

        LoginAsUser(driver);

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");
        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();

        driver.navigate().refresh();

        WebElement payment_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        payment_button.click();

        //Kiểm tra input Tên chủ tài khoản
        WebElement card_onwer_error = getWebElementById(driver, "errCardOwner");
        String expect_text_card_onwer_error = "Vui lòng nhập tên chủ thẻ.";
        testText(card_onwer_error, expect_text_card_onwer_error);

        //Kiểm tra input Số tài khoản
        WebElement card_number_error = getWebElementById(driver, "errCardNumber");
        String expect_text_card_number_error = "Vui lòng nhập số tài khoản.";
        testText(card_number_error, expect_text_card_number_error);

        //Kiểm tra input Địa chỉ giao hàng
        WebElement address_error = getWebElementById(driver, "errAddress");
        String expect_text_address_error = "Vui lòng nhập địa chỉ giao hàng.";
        testText(address_error, expect_text_address_error);


        //Kiểm tra input Thành phố
        WebElement city_error = getWebElementById(driver, "errCity");
        String expect_text_city_error = "Vui lòng nhập tên thành phố.";
        testText(city_error, expect_text_city_error);

        WebElement phone_number_error = getWebElementById(driver, "errPhone");
        String expect_text_phone_number_error = "Vui lòng nhập số điện thoại gồm ít nhất 10 số.";
        testText(phone_number_error, expect_text_phone_number_error);

    }

    //Trường hợp thanh toán thành công.
    @Test
    public void testSuccessPaymentForm() {

        LoginAsUser(driver);

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");
        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();
//
//        WebElement payment_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
//        payment_button.click();

        driver.navigate().refresh();

        //Kiểm tra input Tên chủ tài khoản
        WebElement card_onwer_input = getWebElementByXPath(driver, "//*[@id=\"cardOwner\"]");
        card_onwer_input.sendKeys(card_owner_text);

        //Kiểm tra input Số tài khoản
        WebElement card_number_input = getWebElementByXPath(driver, "//*[@id=\"cardNumber\"]");
        card_number_input.sendKeys(card_number_text);


        //Kiểm tra input Địa chỉ giao hàng
        WebElement address_input = getWebElementByXPath(driver, "//*[@id=\"address\"]");
        address_input.sendKeys(address_text);


        //Kiểm tra input Thành phố
        WebElement city_input = getWebElementByXPath(driver, "//*[@id=\"city\"]");
        city_input.sendKeys(city_text);


        //Kiểm tra input Số điện thoại liên lạc
        WebElement phone_number_input = getWebElementByXPath(driver, "//*[@id=\"phoneNumber\"]");
        phone_number_input.sendKeys(phone_number_text);


        // Kiểm trả button thanh toán
        WebElement checkout_button = getWebElementById(driver, "btnSubmit");
        checkout_button.click();

        WebElement success = getWebElementByXPath(driver, "/html/body/div/h1");
        String expect_success_text = "Cám ơn đã mua sắm";
        testText(success, expect_success_text);
    }

    //Trường hợp tên chủ thẻ chứa số.
    @Test
    public void testCardOwnerContainerNumber() {

        LoginAsUser(driver);

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");
        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();

        WebElement payment_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        payment_button.click();

        driver.navigate().refresh();

        //Kiểm tra input Tên chủ tài khoản
        WebElement card_onwer_input = getWebElementByXPath(driver, "//*[@id=\"cardOwner\"]");
        card_onwer_input.sendKeys(card_owner_text + String.valueOf(randNumber(0, 10)));

        //Kiểm tra input Số tài khoản
        WebElement card_number_input = getWebElementByXPath(driver, "//*[@id=\"cardNumber\"]");
        card_number_input.sendKeys(card_number_text);


        //Kiểm tra input Địa chỉ giao hàng
        WebElement address_input = getWebElementByXPath(driver, "//*[@id=\"address\"]");
        address_input.sendKeys(address_text);


        //Kiểm tra input Thành phố
        WebElement city_input = getWebElementByXPath(driver, "//*[@id=\"city\"]");
        city_input.sendKeys(city_text);


        //Kiểm tra input Số điện thoại liên lạc
        WebElement phone_number_input = getWebElementByXPath(driver, "//*[@id=\"phoneNumber\"]");
        phone_number_input.sendKeys(phone_number_text);


        // Kiểm trả button thanh toán
        WebElement checkout_button = getWebElementById(driver, "btnSubmit");
        checkout_button.click();


        WebElement card_onwer_error = getWebElementById(driver, "errCardOwner");
        String expect_text_card_onwer_error = "Vui lòng nhập tên không chứa số.";
        testText(card_onwer_error, expect_text_card_onwer_error);
    }

    //Trường hợp tên chủ thẻ không viết đúng theo định dạng tiêu đề (Title Case).
    @Test
    public void testCardOwnerNotTitleCase() {

        LoginAsUser(driver);

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");
        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();

        WebElement payment_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        payment_button.click();

        driver.navigate().refresh();

        //Kiểm tra input Tên chủ tài khoản
        WebElement card_onwer_input = getWebElementByXPath(driver, "//*[@id=\"cardOwner\"]");
        card_onwer_input.sendKeys(card_owner_text.toLowerCase());

        //Kiểm tra input Số tài khoản
        WebElement card_number_input = getWebElementByXPath(driver, "//*[@id=\"cardNumber\"]");
        card_number_input.sendKeys(card_number_text);


        //Kiểm tra input Địa chỉ giao hàng
        WebElement address_input = getWebElementByXPath(driver, "//*[@id=\"address\"]");
        address_input.sendKeys(address_text);


        //Kiểm tra input Thành phố
        WebElement city_input = getWebElementByXPath(driver, "//*[@id=\"city\"]");
        city_input.sendKeys(city_text);


        //Kiểm tra input Số điện thoại liên lạc
        WebElement phone_number_input = getWebElementByXPath(driver, "//*[@id=\"phoneNumber\"]");
        phone_number_input.sendKeys(phone_number_text);


        // Kiểm trả button thanh toán
        WebElement checkout_button = getWebElementById(driver, "btnSubmit");
        checkout_button.click();


        WebElement card_onwer_error = getWebElementById(driver, "errCardOwner");
        String expect_text_card_onwer_error = "Vui lòng viết hoa chữ cái đầu của mỗi từ.";
        testText(card_onwer_error, expect_text_card_onwer_error);
    }

    //Trường hợp số thẻ không hợp lệ.
    @Test
    public void testInvalidCardNumber() {

        LoginAsUser(driver);

        WebElement user_icon = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/i");
        hover(driver, user_icon);

        WebElement shopping_cart = getWebElementByXPath(driver, "/html/body/nav[1]/div/div[2]/ul/li[3]/a");
        shopping_cart.click();

        WebElement payment_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");
        payment_button.click();

        driver.navigate().refresh();

        //Kiểm tra input Tên chủ tài khoản
        WebElement card_onwer_input = getWebElementByXPath(driver, "//*[@id=\"cardOwner\"]");
        card_onwer_input.sendKeys(card_owner_text);

        //Kiểm tra input Số tài khoản
        WebElement card_number_input = getWebElementByXPath(driver, "//*[@id=\"cardNumber\"]");
        card_number_input.sendKeys(String.valueOf(randNumber(0, 1000)));


        //Kiểm tra input Địa chỉ giao hàng
        WebElement address_input = getWebElementByXPath(driver, "//*[@id=\"address\"]");
        address_input.sendKeys(address_text);


        //Kiểm tra input Thành phố
        WebElement city_input = getWebElementByXPath(driver, "//*[@id=\"city\"]");
        city_input.sendKeys(city_text);


        //Kiểm tra input Số điện thoại liên lạc
        WebElement phone_number_input = getWebElementByXPath(driver, "//*[@id=\"phoneNumber\"]");
        phone_number_input.sendKeys(phone_number_text);


        // Kiểm trả button thanh toán
        WebElement checkout_button = getWebElementById(driver, "btnSubmit");
        checkout_button.click();

        WebElement card_number_error = getWebElementById(driver, "errCardNumber");
        String expect_text_card_number_error = "Số tài khoản ít nhất 10 số.";
        testText(card_number_error, expect_text_card_number_error);
    }
}
