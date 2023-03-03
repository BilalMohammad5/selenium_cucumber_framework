package step_definitions;

import config.BaseClass;
import config.Helper;
import config.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Listeners(listernerConfig.Listeners.class)
public class product_search extends BaseClass {

    //loading test data from properties file
    Properties prop = new Properties();

    String expectedTitle = "Perfumes On Sale and more at Golden Scent";
    String product_page_title;
    String baseurl = "goldenscent.com/en/";
    //WebDriver driver = initDriver();
    PageObject element = new PageObject(driver); // Creating Page Object reference
    Helper action = new Helper(driver); // Creating helper class Object reference

    public product_search() throws SQLException, IOException, ClassNotFoundException {
    }

    //step definitions for features
    @Given("^user launches golden_scent$")
    public void user_launches_golden_scent() {
        product_page_title = driver.getTitle();
    }

    @Then("^user should be able to see golden_scent home page$")
    public void user_should_be_able_to_see_golden_scent_home_page() {

        Assert.assertEquals(product_page_title, expectedTitle);
        System.out.println("user is on golden scent home page");

    }

    @When("^user searches for product ([^\"]*)$")
    public void user_searches_for_product(String product_name) {
        action.click_element(element.search_bar());
        System.out.println(product_name);
    }


}