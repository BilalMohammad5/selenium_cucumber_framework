package config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

            System.out.println(e.getMessage());
            e.printStackTrace();
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
            System.out.println(e.getMessage());
            e.printStackTrace();
            js.executeScript("arguments[0].click();", js_element);
            js.executeScript("document." + element + "[0].value= " + text + ""); //trying to enter text using js executor
        }
    }

    public void close_pop_up() {
        System.out.println("entered pop up killer");
        WebElement element_Field = wait.until(visibilityOf(element.close_pop_up()));
        element_Field.click();
        System.out.println("pop up closed");
    }
    public void compare_ratings(String act_rating, String exp_rating){
        Double expected_rating = Double.valueOf((exp_rating));
        Double actual_rating = Double.valueOf(act_rating);

        Assert.assertTrue(actual_rating>expected_rating);
        System.out.println("product actual rating is "+"\t"+actual_rating+"\t"+"expected rating is"+"\t"+expected_rating);

    }
}















