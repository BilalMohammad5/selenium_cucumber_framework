package step_definitions;

import Helper.Helper;
import config.BaseClass;
import config.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(listernerConfig.Listeners.class)
public class product_search extends BaseClass {
    String rating;
    String actual_amount;
    JavascriptExecutor js = (JavascriptExecutor) driver;
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
        action.close_pop_up();
        action.click_element(element.add_button());
        action.click_element(element.add_to_cart_1());

    }

    @Then("^User must see product added to cart message$")
    public void user_should_navigate_to_product_page() {
        action.close_pop_up();
        System.out.println(element.product_added_to_cart().getText());
        Assert.assertTrue(element.product_added_to_cart().isDisplayed());
        System.out.println("Product added to cart");
        action.click_element(element.view_account_button());
        action.click_element(element.login_button());
    }

    // scenarios to  Verify product rating

    @Given("^User launches the product([^\"]*)$")
    public void user_launches_the_product(String product_name) {
        driver.get(product_url);
        String actual_title = driver.getTitle();
        Assert.assertEquals(actual_title, product_name);
        System.out.println("user is on product page" + "\t" + product_name);


    }

    @When("^User verifies Product rating$")
    public void ser_verifies_product_rating() {
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

        action.compare_ratings(rating, product_rating);

    }
// scenarios to verify free shipping

    @When("^User verifies product price$")
    public void user_verifies_product_price() {
        element.product_amount().getText();
        try {
            String[] amount = element.product_amount().getText().split(" ");
            actual_amount = amount[0];
            System.out.println("Price of the product is" + "\t" + actual_amount);

        } catch (Throwable e) {
            action.close_pop_up();   //pop up killer
            String[] amount = element.product_amount().getText().split(" ");
            actual_amount = amount[0];
            System.out.println("Price of the product is" + "\t" + actual_amount);
        }
    }

    @Then("^User should be able to verify free shipping message as per ([^\"]*)$")
    public void user_should_be_able_to_verify_free_shipping_as_per_price(String price) {
        Integer expected_amount = Integer.valueOf(price);
        Integer actual_product_amount = Integer.valueOf(actual_amount);

        if (actual_product_amount > expected_amount) {
            Assert.assertTrue(element.free_shipping().isDisplayed());

        } else {
            Assert.assertFalse(element.free_shipping().isDisplayed());
        }


    }

    @When("^User navigates to similar products$")
    public void User_navigates_to_similar_products() {
        WebElement ele = driver.findElement(By.xpath("//div[@class='product-list-container product-list-container-0']"));
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        System.out.println("Scrolled to required product view ");


    }


    @Then("^User should only see products from parent ([^\"]*)$")
    public void User_should_only_see_products_from_parent_brand(String brand) {
        System.out.println("Required brands to be validates is " + brand);
        action.comparing_similar_products(brand);   //calling a reusable method to compare similar product brand

    }
}
