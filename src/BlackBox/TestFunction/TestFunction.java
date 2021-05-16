package BlackBox.TestFunction;

import Configuration.Config;
import WhiteBox.TestCSS.TestCSS;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Random;

public class TestFunction extends TestCSS {
    public static Alert getConfirmAlert(WebDriver driver) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public static String getValidationMessageByXPath(WebDriver driver,String xpath) throws TimeoutException {
        WebElement element = getWebElementByXPath(driver,xpath);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    public static void testTextNotEquals(WebElement element, String compareText) {
        String actual_text = element.getText();
        Assert.assertNotEquals(actual_text, compareText);
    }

    public static HashMap<String, String> createBookToTest(WebDriver driver) {
        LoginAsAdmin(driver);
        HashMap<String, String> BookToTest = new HashMap<String, String>();
        String title = getSaltString();
        int price =randNumber(1,10000000);
        int publishYear =randNumber(1000,2020);
        //Addbook to test
        WebElement add_button = getWebElementByCSSSelector(driver, "li.nav-item:nth-child(2) > a:nth-child(1)");
        add_button.click();

        WebElement title_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[1]/div/input");
        WebElement price_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[3]/div/input");
        WebElement publish_year_input = getWebElementByXPath(driver, "/html/body/form/div/div[2]/div[3]/div[5]/div/input");
        WebElement save_button = getWebElementByXPath(driver, "//*[@id=\"btnSubmit\"]");

        title_input.sendKeys(title);
        price_input.sendKeys(String.valueOf(price));
        publish_year_input.sendKeys(String.valueOf(publishYear));

        save_button.click();

        BookToTest.put("title", title);
        BookToTest.put("price", String.valueOf(price));
        BookToTest.put("publishYear", String.valueOf(publishYear));

        return BookToTest;
    }

    public static int randNumber(int start,int end){
        return (int) (Math.random() * end + start);
    }

    public static void buyBookToTest(WebDriver driver) {
        navigateTo(driver, Config.BaseURL+"/Book_Controller/books");

        WebElement detail_button = getWebElementByXPath(driver, "/html/body/div/div/div[1]/a");
        detail_button.click();

        WebElement buy_button = getWebElementByXPath(driver, "/html/body/div/main/div/div/div/div/div[2]/div/div/div[5]/div[2]/div/form/button");
        buy_button.click();
    }

    public static void LoginAsAdmin(WebDriver driver){
        navigateTo(driver, Config.BaseURL+"/Account_Controller/login");
        driver.findElement(By.id("validationCustomUsername")).sendKeys(Config.ADMIN.get("username"));
        driver.findElement(By.name("password")).sendKeys(Config.ADMIN.get("password"));
        driver.findElement(By.id("submitBtn")).click();
    }

    public static void LoginAsUser(WebDriver driver){
        navigateTo(driver, Config.BaseURL+"/Account_Controller/login");
        driver.findElement(By.id("validationCustomUsername")).sendKeys(Config.USER.get("username"));
        driver.findElement(By.name("password")).sendKeys(Config.USER.get("password"));
        driver.findElement(By.id("submitBtn")).click();
    }

    public static void navigateTo(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 26) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
