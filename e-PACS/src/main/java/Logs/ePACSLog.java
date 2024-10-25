package Logs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import Setups.ePACSlogin;

public class ePACSLog implements ITestListener {

    //private String screenshotDir = "screenshots/";
    @Override
    public void onTestFailure(ITestResult result) {
    	String methodName = result.getMethod().getMethodName();
    	System.out.println("Test is failed :"+methodName);
        WebDriver driver = null;
        try
        {
            driver = ePACSlogin.driver;
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
         
        }
        if (driver != null) 
        {
            String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            String screenshotPath = "data:image/png;base64," + screenshotBase64;

            Reporter.log("<a href='" + screenshotPath + "'><img src='" + screenshotPath + "' width='800' height='500'/></a>");
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished for context: " + context.getName());
    }

    // Unused methods
    @Override
    public void onTestSkipped(ITestResult result)
    { 
    	
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    { 
    	
    }
    @Override
    public void onStart(ITestContext context) 
    {
    	
    }
}
