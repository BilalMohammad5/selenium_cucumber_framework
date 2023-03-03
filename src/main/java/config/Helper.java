package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper extends BaseClass{
    public Helper(WebDriver driver) {
        this.driver = driver;  // assigning driver instance from config to  local instance
    }

    public void click_element(WebElement ele){


        if(ele.isEnabled()){
            ele.click();
            System.out.println("element clicked");
        }
        else{
            System.out.println("element not enabled ");
        }
    }

}
