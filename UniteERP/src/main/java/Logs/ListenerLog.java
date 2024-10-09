package Logs;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Login.UniteLogin;

public class ListenerLog extends UniteLogin implements ITestListener 
{
    @Override
    public void onStart(ITestContext context)
    {
    	 String suiteName = context.getSuite().getName();
    	 System.out.println("Starting test suite: " + suiteName);
    }

    @Override
    public void onFinish(ITestContext context) 
    {
    	 System.out.println("Test suite finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result)
    {
    	String methodName = result.getMethod().getMethodName();
        System.out.println("Executing test method: " + methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) 
    {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Test method " + methodName + " succeeded");
        long executionTime = result.getEndMillis() - result.getStartMillis();
        System.out.println("Execution time: " + executionTime + "ms");
        Object[] parameters = result.getParameters();
        if (parameters.length > 0) 
        {
            System.out.println("Test parameters:");
            for (Object param : parameters)
            {
                System.out.println(param.toString());
            }
        }
    }
    public void onTestSkip(ITestResult result)
    {
    	String mathodName=result.getName();
    	System.out.println("Skipped Method :"+mathodName);
    }

    @Override
    public void onTestFailure(ITestResult result) 
    {

    	String methodName = result.getMethod().getMethodName();
    	System.out.println("Test is failed :"+methodName);
        WebDriver driver = null;
        try
        {
            driver = UniteLogin.driver;
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
}

