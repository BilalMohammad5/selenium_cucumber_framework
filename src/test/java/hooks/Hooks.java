package hooks;

import config.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;

public class Hooks extends BaseClass {


    @BeforeAll
    public static void before_all() throws SQLException, IOException, ClassNotFoundException {
        WebDriver driver = initDriver();   //Initiating web_driver instance
        driver.manage().window().maximize();
        System.out.println("maximising window");

    }
    @Before("@smoke")
    public static void before(Scenario sc) {
        System.out.println("Scenario"+ sc.getName()+"execution started");
    }

    @After
    public static void after(Scenario sc) throws IOException {
        System.out.println("Scenario"+ sc.getName()+"execution status is"+sc.getStatus());

        if(sc.getStatus().toString().toLowerCase().equals("Passed")){
            screenshot(sc.getName() ,driver);
        }

    }
    @AfterAll
    public static void after_all() {
        driver.quit();
        System.out.println("web_driver closed");

    }
}
