package extentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent {
 static	ExtentReports extent;
	
	public  static ExtentReports generateReports() {
		
		// spark reporter --  customization 
		// exten reporter --  implement customization
		
		
		System.out.println("report generation initiated");
		String path = System.getProperty("user.dir")+"//reports/result.html";
		ExtentSparkReporter  repo = new ExtentSparkReporter(path);
		
		
		
		extent = new ExtentReports();
		extent.attachReporter(repo);
		
		return extent;
		
	}
	

}
