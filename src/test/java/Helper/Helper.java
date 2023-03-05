package Helper;

import config.BaseClass;
import config.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Helper extends BaseClass {
    PageObject element = new PageObject(driver); // Creating Page Object reference


    public Helper(WebDriver driver) {

        this.driver = driver;

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement js_element;
    WebDriverWait wait = new WebDriverWait(driver, 20); //passing driver instance to wait


    public void click_element(WebElement element) {
        js_element = element;   // assigning local element value to class level js element
        try {

            WebElement element_Field = wait.until(elementToBeClickable(element));
            element_Field.click();
            System.out.println(element.getText() + "\t" + "element clicked");
        } catch (Throwable e) {
            js.executeScript("arguments[0].click();", js_element); //try to interact with element using js executor

        }
    }

    public void enter_text(WebElement element, String text) {
        js_element = element;
        try {
            WebElement element_Field = wait.until(visibilityOf(element));
            element_Field.sendKeys(text);
            System.out.println(text + "\t" + " entered into the field");
        } catch (Throwable e) {

            js.executeScript("arguments[0].click();", js_element);
            js.executeScript("document." + element + "[0].value= " + text + ""); //trying to enter text using js executor
        }
    }

    public void close_pop_up() {
        try {
            System.out.println("entered pop up killer");
            WebElement element_Field = wait.until(visibilityOf(element.close_pop_up()));
            element_Field.click();
            System.out.println("pop up closed");
        } catch (Throwable e) {
            System.out.println("pop up not found");
        }
    }

    public void compare_ratings(String act_rating, String exp_rating) {
        Double expected_rating = Double.valueOf((exp_rating));
        Double actual_rating = Double.valueOf(act_rating);

        Assert.assertTrue(actual_rating > expected_rating);
        System.out.println("product actual rating is " + "\t" + actual_rating + "\t" + "expected rating is" + "\t" + expected_rating);

    }

    public void comparing_similar_products(String product_brand) {
        close_pop_up();

        List<WebElement> list = new ArrayList<>();
        list = driver.findElements(By.xpath("//div[@class='product-list-container product-list-container-0']/ul/li/div/a/div[4]/div/div[1]"));

        System.out.println("Total number of similar products found are" + "\t" + list.size());

        for (WebElement itr : list) {
            Assert.assertTrue(itr.getText().equalsIgnoreCase(product_brand)); //comparing similar products brand with Expected Brand
        }

    }
}















