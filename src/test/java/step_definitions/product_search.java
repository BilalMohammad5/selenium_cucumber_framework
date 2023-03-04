package step_definitions;

import config.BaseClass;
import config.Helper;
import config.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Listeners(listernerConfig.Listeners.class)
public class product_search extends BaseClass {
    String rating;
    WebDriverWait wait = new WebDriverWait(driver, 30);

    String product_url = "https://www.goldenscent.com/en/p/gucci-guilty-absolute-pour-homme-eau-de-parfum-for-men.html?action=prod&id=6108";

    PageObject element = new PageObject(driver); // Creating Page Object reference
    Helper action = new Helper(driver); // Creating helper class Object reference

    public product_search() throws SQLException, IOException, ClassNotFoundException {
    }

    //step definitions for features
    @Given("^User logs into golden_scent application using ([^\"]*) and ([^\"]*)$")
    public void user_logs_into_golden_scent_application_using_email_and_password(String email, String password) {
        action.click_element(element.view_account_button());   //invoking reusable click_element function from helper class
        action.enter_text(element.email_id(), email);           //invoking reusable click_element function from helper class
        action.enter_text(element.pwd(), password);
        action.click_element(element.login_button());

        // code for validating pop up//
    }

    @When("^User searches for a product ([^\"]*)$")
    public void User_searches_for_a_product(String product_name) throws InterruptedException {
        action.enter_text(element.search_bar(), product_name);
        element.search_bar().sendKeys(Keys.ENTER);

    }

    @And("User adds product to cart")
    public void User_adds_product_to_cart() throws InterruptedException {
        try {
            action.click_element(element.add_button());
            action.click_element(element.add_to_cart_1());
        } catch (Throwable e) {
            System.out.println("entered cache block");
            e.printStackTrace();
            e.getMessage();
            WebElement element_Field = wait.until(visibilityOf(element.close_pop_up()));
            element_Field.click();
            System.out.println("pop up closed");
            action.click_element(element.add_to_cart_1());
        }

    }

    @Then("user should navigate to product page")
    public void user_should_navigate_to_product_page() {
    }
    //Scenario Outline: Verify product rating

    @Given("^User launches the product ([^\"]*)$")
    public void user_launches_the_product(String product_name) {
        driver.get(product_url);
        String actual_title = driver.getTitle();
        Assert.assertEquals(actual_title, product_name);
        System.out.println("user is on product page" + "\t" + product_name);


    }

    @When("^User verifies Product rating$")
    public void  ser_verifies_product_rating() {
        try {
             rating = element.rating_by_number().getText();
            System.out.println("product rating is" + "\t" + rating);
        } catch (Throwable e) {
            action.close_pop_up();   //pop up killer
            rating = element.rating_by_number().getText();
            System.out.println("product rating is" + rating);
        }

    }

    @Then("^User should be able see that rating is more than ([^\"]*) stars$")
    public void user_should_be_able_to_see_that_the_product_ratings(String product_rating) {

        action.compare_ratings(product_rating,rating);
//
//       Double expected_rating = Double.valueOf((product_rating));
//       Double actual_rating = Double.valueOf(rating);
//
//       Assert.assertTrue(actual_rating>expected_rating);
//        System.out.println("product actual rating is "+"\t"+actual_rating+"\t"+"expected rating is"+"\t"+expected_rating);


    }
}
