package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject extends BaseClass {

    //Landing page Elements

    By search_bar = By.xpath("//div[@class='search-bar']/input");
    By password = By.id("txtPassword");
    By login = By.id("submit");
    By txaProfile = By.xpath("//*[@id='currentModule']/div[2]/div/a/span[2]");
    By inserButton = By.id("insertButton");
    By profileName = By.xpath("//div[@class='currentRow']/div[2]/input");
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
    public WebElement search_bar() {

        return driver.findElement(search_bar);

    }
    public WebElement password() {

        return driver.findElement(password);

    }
    public WebElement login() {

        return driver.findElement(login);

    }
    public WebElement taxProfile() {

        return driver.findElement(txaProfile);

    }
    public WebElement inserButton() {

        return driver.findElement(inserButton);

    }
    public WebElement profileName() {

        return driver.findElement(profileName);

    }
    public WebElement description() {

        return driver.findElement(description);

    }
    public WebElement save() {

        return driver.findElement(save);

    }
    public WebElement descriptionHeader() {

        return driver.findElement(descriptionHeader);

    }
    public WebElement userMenu() {

        return driver.findElement(userMenu);

    }
    public WebElement logout() {

        return driver.findElement(logout);

    }


}
