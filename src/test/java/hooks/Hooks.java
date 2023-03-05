package hooks;

import config.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks extends BaseClass {
    static WebDriver driver;

    static {
        try {
            driver = initDriver();   //Initiating web_driver instance
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }


    @BeforeAll
    public static void before_all() {

        driver.manage().window().maximize();
        System.out.println("Maximising browser window");

    }
    @Before("@smoke")
    public static void before(Scenario sc) {
        System.out.println("Scenario"+ "\t"+sc.getName()+"execution started");
    }

    @After
    public static void after(Scenario sc) throws IOException {

        System.out.println("Scenario"+"\t"+"execution status is"+sc.getStatus());

        if(sc.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot,"image/png","attach screenshot");
        }

    }
    @AfterAll
    public static void after_all() {
        driver.quit();
        System.out.println("web_driver closed");

    }
}
