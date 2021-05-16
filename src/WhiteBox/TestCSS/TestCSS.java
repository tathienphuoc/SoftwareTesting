package WhiteBox.TestCSS;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCSS {
    public static WebElement getWebElementByCSSSelector(WebDriver driver, String cssSelector) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static WebElement getWebElementByXPath(WebDriver driver, String xpath) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement getWebElementByName(WebDriver driver, String name) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public static WebElement getWebElementByClassName(WebDriver driver, String className) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public static WebElement getWebElementById(WebDriver driver, String id) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void testColor(WebElement element, String expect_color) {
        String actual_color = Color.fromString(element.getCssValue("color")).asHex();
        Assert.assertEquals(expect_color, actual_color);
    }

    public void testBackgroundColor(WebElement element, String expect_background_color) {
        String actual_background_color = Color.fromString(element.getCssValue("background-color")).asHex();
        Assert.assertEquals(expect_background_color, actual_background_color);
    }

    public void testText(WebElement element, String expect_text) {
        String actual_text = element.getText();
        Assert.assertEquals(expect_text, actual_text);
    }

    public void testAlertMessage(Alert alert, String expect_message) {
        String actual_message = alert.getText();
        Assert.assertEquals(expect_message, actual_message);
    }

    public void testMarginBottom(WebElement element, String expect_margin_bottom) {
        String actual_margin_bottom = element.getCssValue("margin-bottom");
        Assert.assertEquals(expect_margin_bottom, actual_margin_bottom);
    }

    public void testFontStyle(WebElement element, String expect_font_style) {
        String actual_font_style = element.getCssValue("font-style");
        Assert.assertEquals(expect_font_style, actual_font_style);
    }

    public void testInputType(WebElement element, String expect_text) {
        String actual_input_type = element.getAttribute("type");
        Assert.assertEquals(expect_text, actual_input_type);
    }

    public void testPlaceHolder(WebElement element, String expect_placeHolder) {
        String actual_placeHolder = element.getAttribute("placeholder");
        Assert.assertEquals(expect_placeHolder, actual_placeHolder);
    }

    public void testSourceImage(WebElement element, String expect_src) {
        String actual_src = element.getAttribute("src");
        Assert.assertEquals(expect_src, actual_src);
    }

    public void testValue(WebElement element, String expect_value) {
        String actual_value = element.getAttribute("value");
        Assert.assertEquals(expect_value, actual_value);
    }

    public void testHeight(WebElement element, int expect_height) {
        int actual_height = element.getSize().height;
        Assert.assertEquals(expect_height, actual_height);
    }

    public void testWidth(WebElement element, int expect_width) {
        int actual_width = element.getSize().width;
        Assert.assertEquals(expect_width, actual_width);
    }

    public void testStringEquals(String str1, String str2) {
        Assert.assertEquals(str1, str2);
    }

    public void testStringNotEquals(String str1, String str2) {
        Assert.assertNotEquals(str1, str2);
    }

    public void testExistText(WebDriver driver, String text) {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(text));
    }

    public void hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
