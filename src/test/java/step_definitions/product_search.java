package step_definitions;

import config.BaseClass;
import config.Helper;
import config.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(listernerConfig.Listeners.class)
public class product_search extends BaseClass {
    String expectedTitle = "Perfumes On Sale and more at Golden Scent";
    String product_page_title;
    PageObject element = new PageObject(driver); // Creating Page Object reference
    Helper action = new Helper(driver); // Creating helper class Object reference

    public product_search() throws SQLException, IOException, ClassNotFoundException {
    }

    //step definitions for features
    @Given("^user logs into golden_scent application using ([^\"]*) and ([^\"]*)$")
    public void user_logs_into_golden_scent_application_using_email_and_password(String email, String password) {
        action.click_element(element.view_account_button());   //invoking reusable click_element function from helper class
        action.enter_text(element.email_id(),email);           //invoking reusable click_element function from helper class
        action.enter_text(element.pwd(),password);
        action.click_element(element.login_button());

        // code for validating pop up//
    }

    @When("user searches for a product  Gucci Guilty Absolute Pour Homme")
    public void user_searches_for_a_product_gucci_guilty_absolute_pour_homme() {

    }

    @When("user selects a product")
    public void user_selects_a_product() {

    }

    @Then("user should navigate to product page")
    public void user_should_navigate_to_product_page() {

    }


}