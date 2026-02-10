package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerclass implements ITestListener {
	ExtentSparkReporter sparkreporter;
	ExtentReports exreporter;
	ExtentTest test;
	String reportname;
	 public void onStart(ITestContext context) {
		 String Timestamp= new SimpleDateFormat("dd-MM-yy-HH-mm-ss").format(new Date());
		 reportname= "Reportname"+Timestamp+".html";
			sparkreporter= new ExtentSparkReporter(".\\target\\"+reportname);
			exreporter = new ExtentReports();
			sparkreporter.config().setDocumentTitle(reportname+"document");
			sparkreporter.config().setTheme(Theme.DARK);
			exreporter.attachReporter(sparkreporter);
			exreporter.setSystemInfo("OS", "Window");		
		  }
	 public void onTestSuccess(ITestResult result) {
		 test = exreporter.createTest(result.getName());
		 test.log(Status.PASS, "passed");
		    
		  }
	 public void onFinish(ITestContext context) {
		 exreporter.flush();
		 try {
			Desktop.getDesktop().browse(new File("target/"+reportname).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
	

}
