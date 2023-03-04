package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject extends BaseClass {
    private String i;
    //Landing page Elements
    By view_account_button = By.xpath("//div[@data-testid='accountButton']");
    By email_id = By.xpath("//div[@class='relative']/label[.='E-mail address *']/../input");
    By pwd =  By.xpath("//div[@class='relative']/label[.='Password *']/../input");
    By search_bar = By.xpath("//div[@class='search-bar']/input");
    By login_button = By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')] ");
    By logged_in_popup =  By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')]");
    By view_all_products = By.xpath("//div[@class='view-all']//span");
    By add_button = By.xpath("//div[@class='product-card']/div[2]/div/button");
    By add_to_cart_1 = By.xpath("//div[@class='add-to-cart-popup']/div/div[2]/div[2]");
    By close_pop_up = By.xpath("//button[@class='ab-close-button']");

    By rating_element = By.xpath("//div[@class='rating-content']/span/img");
    By rating_by_number = By.xpath("//span[@class='avg-rating']");




    By description = By.xpath("//div[@class='currentRow']/div[3]/input");
    By descriptionHeader = By.xpath("//div[@class='currentRow']/div[3]");
    By userMenu = By.xpath("//div[@id='activeUserMenu']/div/img");
    By logout = By.xpath("//span[contains(text(),'Log Out')]");

    By save = By.id("saveButton");
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

    public WebElement rating_element() {

        return driver.findElement(rating_element);

    }

    public WebElement rating_by_number() {

        return driver.findElement(rating_by_number);

    }
}
