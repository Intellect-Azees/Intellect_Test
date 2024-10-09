package Login;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.Captcha;

public class UniteLogin {

    public static WebDriver driver;
    public String captchaImagePath;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//img[@id='imgcapt']")
    public WebElement captchaLabel;

    @FindBy(xpath = "//input[@id='ValidateCaptcha']")
    public WebElement captchaInput;

    @FindBy(xpath = "//button[@id='btnView']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[@class='dropdown-toggle']/../../li[2]/a/span)[2]")
    public WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Sign Out']")
    public WebElement signOutLink;

    @Parameters({"browser"})
    @BeforeClass
    public boolean launchBrowser(String browser) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\My Files\\selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            if (driver != null) {
                System.out.println("WebDriver initialized successfully");
                driver.get("http://10.0.0.72:7133/");
                driver.manage().window().maximize();
                PageFactory.initElements(driver, this);
                Thread.sleep(3000);
            } else {
                throw new Exception("WebDriver initialization failed for Chrome.");
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @BeforeMethod
    public boolean login() {
        String pacsID = "91190403069001";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            this.userNameInput.sendKeys(pacsID);
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            this.passwordInput.sendKeys("Root@123");
            wait.until(ExpectedConditions.visibilityOf(captchaLabel));
            captchaImagePath = captchaLabel.getAttribute("src");
           // System.out.println("Captcha Image Path: " + captchaImagePath);

            Captcha cap = new Captcha();
            cap.storeCaptcha();
            String captchaText = cap.convertCaptchaToText();
            System.out.println("Extracted Captcha Text: " + captchaText);
            this.captchaInput.sendKeys(captchaText);

            this.loginButton.click();
            wait.until(ExpectedConditions.urlContains("http://10.0.0.72:7133/WorkFlow/Index"));  // Replace with the actual URL
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @AfterMethod
    public boolean logout() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(userDropdown));
            this.userDropdown.click();

            wait.until(ExpectedConditions.visibilityOf(signOutLink));
            this.signOutLink.click();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @AfterClass
    public boolean closeBrowser() {
        try {
            driver.quit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
