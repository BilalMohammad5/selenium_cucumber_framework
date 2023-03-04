package config;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Helper extends BaseClass {


    public Helper(WebDriver driver) {
        this.driver = driver;

    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement js_element;
    WebDriverWait wait = new WebDriverWait(driver,10); //passing driver instance to wait


    public void click_element(WebElement element) {
        js_element = element;   // assigning local element value to class level js element
        try {

            WebElement element_Field = wait.until(elementToBeClickable(element));
            element_Field.click();
            System.out.println("element clicked");
        }catch (Throwable e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            js.executeScript("arguments[0].click();", js_element); //try to interact with element using js executor

        }
    }


    public void enter_text  (WebElement element, String text) {
        js_element = element;
        try {
            WebElement element_Field = wait.until(elementToBeClickable(element));
            element_Field.sendKeys(text);
            System.out.println( text +"\t" +" entered into the field");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            js.executeScript("arguments[0].click();", js_element);
            js.executeScript("document." + element + "[0].value= " + text + ""); //trying to enter text using js executor
        }
    }


}
