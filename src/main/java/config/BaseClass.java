package config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	public static WebDriver driver;

	// fetching test par ameters from mysql database

	public static WebDriver initDriver() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {

		String browser = "chrome";
		String base_url = "https://www.goldenscent.com/en/";

		if (browser.toLowerCase().equals("chrome")) {
			// System.out.println("Test initiated using chrome browser");

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(base_url);

		}

		if (browser.toLowerCase().equals("IE")) {
			System.out.println("Test initiated using IE  browser");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			driver = new EdgeDriver();
			driver.get(base_url);

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void screenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // taking screenshot with help of driver
		File source = ts.getScreenshotAs(OutputType.FILE); // saving screenshot to a File
		String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png"; //creating aPNG filewith dynamic methodname and webdriverinstance

		FileUtils.copyFile(source, new File(destinationFile)); // Transferring PNG file from source to Destination
																// location in project folder
		System.out.println("Error screenshot attached with " + testCaseName);
	}

}