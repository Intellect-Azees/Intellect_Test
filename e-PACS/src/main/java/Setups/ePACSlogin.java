package Setups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Logs.ePACSLog;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

@Listeners(ePACSLog.class)
public class ePACSlogin {
	 @FindBy(id = "UserName")
     public WebElement userNameInput;

	 @FindBy(id = "Password")
	 public WebElement passwordInput;
	
	 @FindBy(id = "imgcapt")
	 public WebElement captchaLabel;
	
	 @FindBy(id = "ValidateCaptcha")
	 public WebElement captchaInput;
	
	 @FindBy(id = "btnView")
	 public WebElement loginButton;
	
	 @FindBy(xpath = "//a[text()='Sign Out']")
	 public WebElement signOutLink;


	 public static WebDriver driver;
	 public HandelCaptcha handelCaptcha;
	 public WebDriverWait wait;
	 String captchaSrc;
	 public Robot robot;

    @BeforeClass
    public void launchBrowser() 
    {
    	try
    	{
	        System.setProperty("webdriver.chrome.driver", "D:\\My Files\\selenium\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	
	        // Initialize the WebDriver once
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.manage().window().maximize();
	        driver.get("http://183.82.113.243:7133/");
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	}
    	catch(Exception ex)
    	{
    		
    	}
    }
    @BeforeMethod
    public void login() 
    {
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(userNameInput)).sendKeys("91202715002001");
            passwordInput.sendKeys("Root@123");
            wait.until(ExpectedConditions.visibilityOf(captchaLabel));
            captchaSrc = captchaLabel.getAttribute("src");
            HandelCaptcha handelCaptcha = new HandelCaptcha(captchaSrc);
            handelCaptcha.captcha();
            Thread.sleep(5000);
            captchaInput.clear();
            captchaInput.sendKeys(handelCaptcha.text);
            Thread.sleep(5000);
            robot=new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            loginButton.click();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Test
    public void performLoginTest() 
    {
    	
    }
    @AfterMethod
    public void logout() 
    {
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(signOutLink)).click();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            Assert.assertFalse(false);
        	throw new RuntimeException("can not find the singOutButton");
        }
    }
    @AfterClass
    public void closeBrowser() {
    	if (driver != null) 
        {
            driver.quit();
        }
        else
        {
        	Assert.assertFalse(false);
        	throw new RuntimeException("can not this.driver is null");
        }
    }
}
