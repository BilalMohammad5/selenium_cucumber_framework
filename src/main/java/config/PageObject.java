package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject extends BaseClass {
    private String i;
    //Landing page Elements
    By view_account_button = By.xpath("//div[@data-testid='accountButton']");
    By email_id = By.xpath("//div[@class='relative']/label[.='E-mail address *']/../input");
    By pwd = By.xpath("//div[@class='relative']/label[.='Password *']/../input");
    By search_bar = By.xpath("//div[@class='search-bar']/input");
    By login_button = By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')] ");
    By logged_in_popup = By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')]");
    By view_all_products = By.xpath("//div[@class='view-all']//span");
    By add_button = By.xpath("//div[@class='product-card']/div[2]/div/button");
    By add_to_cart_1 = By.xpath("//div[@class='add-to-cart-popup']/div/div[2]/div[2]");
    By close_pop_up = By.xpath("//button[@class='ab-close-button']");
    By product_added_to_cart = By.xpath("//div[@class='notifications fixed']/span/div/div[@class='message p20']");
    By rating_by_number = By.xpath("//span[@class='avg-rating']");
    By product_amount = By.xpath("//div[@class='price-content']/div/span[2]");
    By free_shipping = By.xpath("//div[@class='product-status']/span");
    //div[@class='product-list-container product-list-container-0']/ul/li/div/a/div[3]/div/div/font/font
    By similar_products = By.xpath("//div[@class='product-list-container product-list-container-0']/ul/li/div/a/div[3]/div/div/font/font");
    By log_out = By.xpath("//div[@data-testid='accountButton'] /div/div[2]/a");

    public PageObject(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;  // assigning driver instance from Launch class to local instance
    }

    //returning elements
    public WebElement view_account_button() {

        return driver.findElement(view_account_button);

    }

    public WebElement login_button() {

        return driver.findElement(login_button);

    }

    public WebElement email_id() {

        return driver.findElement(email_id);

    }

    public WebElement pwd() {

        return driver.findElement(pwd);

    }

    public WebElement search_bar() {

        return driver.findElement(search_bar);

    }

    public WebElement add_button() {

        return driver.findElement(add_button);

    }

    public WebElement add_to_cart_1() {

        return driver.findElement(add_to_cart_1);

    }

    public WebElement close_pop_up() {

        return driver.findElement(close_pop_up);

    }


    public WebElement rating_by_number() {

        return driver.findElement(rating_by_number);

    }

    public WebElement product_amount() {

        return driver.findElement(product_amount);

    }
    public WebElement free_shipping() {

        return driver.findElement(free_shipping);

    }
    public WebElement similar_products() {

        return driver.findElement(similar_products);

    }
    public WebElement product_added_to_cart() {

        return driver.findElement(product_added_to_cart);

    }
    public WebElement log_out() {

        return driver.findElement(log_out);

    }
}
