package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject extends BaseClass {

    //Landing page Elements
    By view_account_button = By.xpath("//div[@data-testid='accountButton']");
    By email_id = By.xpath("//div[@class='relative']/label[.='E-mail address *']/../input");
    By pwd =  By.xpath("//div[@class='relative']/label[.='Password *']/../input");
    By search_bar = By.xpath("//div[@class='search-bar']/input");
    By login_button = By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')]");
    By logged_in_popup =  By.xpath("//div[@class='modal-content']//button[contains(text(),'Log in to your account')]");


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
}
