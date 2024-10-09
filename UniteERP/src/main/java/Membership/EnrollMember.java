package Membership;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Login.UniteLogin;
import Utilities.Test_Data;



public class EnrollMember extends UniteLogin
{
	String page="EnrollMember";
	public Test_Data obj =new Test_Data();
	String SevenDigitAdmissionNum;
	/*
	 * TC-1 :-Enrolling a member that having no nominee and guardian
	 */
	@Test
	public void enrollMember() throws Exception 
	{

			  Robot r= new Robot();
			  driver.findElement(By.xpath("//p[text()='Membership ']")).click();
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
		      Thread.sleep(2000);
		       Select customertype = new Select (driver.findElement(By.id("CustomerType")));
		      customertype.selectByVisibleText(obj.dataUtility(page, 0, 1));
		      Thread.sleep(1000);
		      driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 1, 1));
		      Thread.sleep(1000);
		      driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 2, 1));
		      Thread.sleep(1000);
		      driver.findElement(By.id("GeneralDetailsDTO_Age")).sendKeys(obj.dataUtility(page, 3, 1));
		      Thread.sleep(1000);
		      Select Gender = new Select (driver.findElement(By.id("GeneralDetailsDTO_Gender")));
		      Gender.selectByVisibleText(obj.dataUtility(page, 4, 1));
		      Thread.sleep(2000);
		      Select MaritalStatus = new Select (driver.findElement(By.id("GeneralDetailsDTO_MaritalStatus")));
		      MaritalStatus.selectByVisibleText(obj.dataUtility(page, 5, 1));
		      Thread.sleep(2000);
		      Select Bloodgroup = new Select (driver.findElement(By.id("GeneralDetailsDTO_BloodGroup")));
		      Bloodgroup.selectByVisibleText(obj.dataUtility(page, 6, 1));
		      Thread.sleep(2000);
		      driver.findElement(By.id("GeneralDetailsDTO_FatherName")).sendKeys(obj.dataUtility(page, 7, 1));
		      Thread.sleep(1000);
		      Select Religion = new Select (driver.findElement(By.id("GeneralDetailsDTO_Community")));
		      Religion.selectByVisibleText(obj.dataUtility(page,8 , 1));
		      Thread.sleep(2000);
		      Select Caste = new Select (driver.findElement(By.id("GeneralDetailsDTO_Caste")));
		      Caste.selectByVisibleText(obj.dataUtility(page, 9, 1));
		      Thread.sleep(3000);
		      driver.findElement(By.id("RefAdmissionNo")).sendKeys(obj.dataUtility(page, 10, 1));
		      String refAdmit=driver.findElement(By.id("RefAdmissionNo")).getAttribute("value");
		      int num=Integer.parseInt(refAdmit);
		      System.out.println(num);
		      r.keyPress(KeyEvent.VK_TAB);
		      r.keyRelease(KeyEvent.VK_TAB);
		      Thread.sleep(2000);
		      
		      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			     try
			     {
			    	 if(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
			         {
			    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))); 
			    
			     
					     while(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
					     {	
					    	 Thread.sleep(2000);
					    	 driver.findElement(By.xpath("//button[text()='OK']")).click();
					    	
					    	 num++;
					    	 String data=Integer.toString(num);
					    	 Thread.sleep(2000);
					    	 driver.findElement(By.id("RefAdmissionNo")).sendKeys(data,Keys.TAB,Keys.TAB);
					    	 Thread.sleep(4000);
					     }
			         }
			    	 else if(!driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed()){
			    		 driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).click();
			    		 Thread.sleep(1000);
				 	     driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).sendKeys(obj.dataUtility(page, 12, 1));
				 	     Thread.sleep(4000);
			    	 }
			     }
			     catch(Exception ex)
			     {
			    	 ex.printStackTrace();
			     }

			    Thread.sleep(4000);
			    r.keyPress(KeyEvent.VK_PAGE_DOWN);
			    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			    Thread.sleep(3000);
			     
			    r.keyPress(KeyEvent.VK_PAGE_DOWN);
			    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			    Thread.sleep(3000);
			     
//		      	driver.findElement(By.id("AadhaarCardNo")).sendKeys(obj.dataUtility(page, 11, 1));
			    Thread.sleep(3000);
		      
			    r.keyPress(KeyEvent.VK_TAB);
			    r.keyRelease(KeyEvent.VK_TAB);
			    Thread.sleep(2000);
		      
			    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
			    Thread.sleep(2000);
			    driver.findElement(By.id("AddressDTO_CommunicationHouseNo")).sendKeys(obj.dataUtility(page, 13	, 1));
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//*[@id=\"addressdiv\"]/div[4]/span[2]/input"))
			    .sendKeys(obj.dataUtility(page, 14, 1));
			    Thread.sleep(5000);
		     
			    r.keyPress(KeyEvent.VK_TAB);
			    r.keyRelease(KeyEvent.VK_TAB);
			    Thread.sleep(2000);
		    
			    driver.findElement(By.id("AddressDTO_MobileNo")).sendKeys(obj.dataUtility(page, 15, 1));
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();
			    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
			    Thread.sleep(3000);
			    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
			    Thread.sleep(3000);
			    driver.findElement(By.id("btnfinish")).click();
			    Thread.sleep(3000);
			    //SAVE POPUP----------
			    String newAdmissionNo=driver.findElement(By.xpath("(//div[contains(text(),'Generated Admission No.-')])[1]")).getText();     
			    String SevenDigitAdmissionNum = newAdmissionNo.substring(newAdmissionNo.length() - 7);
			    Thread.sleep(5000);
			    System.out.println("SevenDigitAdmissionNum :"+SevenDigitAdmissionNum);
			    obj.updateData("GenaralData", 0, 1, SevenDigitAdmissionNum);
			    driver.findElement(By.xpath("//button[@id='btnsuccessmessageok']")).click();
			    Thread.sleep(2000);
			    //CLOSE TASK POPUP---------
			    driver.findElement(By.xpath("(//button[text()='×'])[1]")).click();
			    Thread.sleep(3000);
			    //DASHBOARD--------------------
			    driver.findElement(By.xpath("//a[@class='logo-a']")).click();
			    Thread.sleep(3000);
		
	}
//	/*
//	 * TC-2 : Enrolling a member which haveing nominee and that nominee is PACS member
//	 */
//	@Test
//	public void enrollMemberWithnominee() throws Exception 
//	{
//		Robot r= new Robot();
//		driver.findElement(By.xpath("//p[text()='Membership ']")).click();
//		Thread.sleep(5000);
//	    driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
//	    Thread.sleep(2000);
//	    Select customertype = new Select (driver.findElement(By.id("CustomerType")));
//	    customertype.selectByVisibleText(obj.dataUtility(page, 0, 1));
//	    Thread.sleep(1000);
//	    driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 1, 1));
//	    Thread.sleep(1000);
//	    driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 2, 1));
//	    Thread.sleep(1000);
//	    driver.findElement(By.id("GeneralDetailsDTO_Age")).sendKeys(obj.dataUtility(page, 3, 1));
//	    Thread.sleep(1000);
//	    Select Gender = new Select (driver.findElement(By.id("GeneralDetailsDTO_Gender")));
//	    Gender.selectByVisibleText(obj.dataUtility(page, 4, 1));
//	    Thread.sleep(2000);
//	    Select MaritalStatus = new Select (driver.findElement(By.id("GeneralDetailsDTO_MaritalStatus")));
//	    MaritalStatus.selectByVisibleText(obj.dataUtility(page, 5, 1));
//	    Thread.sleep(2000);
//	    Select Bloodgroup = new Select (driver.findElement(By.id("GeneralDetailsDTO_BloodGroup")));
//	    Bloodgroup.selectByVisibleText(obj.dataUtility(page, 6, 1));
//	    Thread.sleep(2000);
//	    driver.findElement(By.id("GeneralDetailsDTO_FatherName")).sendKeys(obj.dataUtility(page, 7, 1));
//	    Thread.sleep(1000);
//	    Select Religion = new Select (driver.findElement(By.id("GeneralDetailsDTO_Community")));
//	    Religion.selectByVisibleText(obj.dataUtility(page,8 , 1));
//	    Thread.sleep(2000);
//	    Select Caste = new Select (driver.findElement(By.id("GeneralDetailsDTO_Caste")));
//	    Caste.selectByVisibleText(obj.dataUtility(page, 9, 1));
//	    Thread.sleep(3000);
//	    driver.findElement(By.id("RefAdmissionNo")).sendKeys(obj.dataUtility(page, 10, 1));
//	    String refAdmit=driver.findElement(By.id("RefAdmissionNo")).getAttribute("value");
//	    int num=Integer.parseInt(refAdmit);
//	    System.out.println(num);
//	    r.keyPress(KeyEvent.VK_TAB);
//	    r.keyRelease(KeyEvent.VK_TAB);
//	    Thread.sleep(2000);
//      
//	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//	    try
//	    {
//	    	 if(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
//	         {
//	    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))); 
//	    
//	     
//			     while(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
//			     {	
//			    	 Thread.sleep(2000);
//			    	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//			    	
//			    	 num++;
//			    	 String data=Integer.toString(num);
//			    	 Thread.sleep(2000);
//			    	 driver.findElement(By.id("RefAdmissionNo")).sendKeys(data,Keys.TAB,Keys.TAB);
//			    	 Thread.sleep(4000);
//			     }
//	         }
//	    	 else if(!driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed()){
//	    		 driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).click();
//	    		 Thread.sleep(1000);
//		 	     driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).sendKeys(obj.dataUtility(page, 12, 1));
//		 	     Thread.sleep(4000);
//	    	 }
//	    }
//	    catch(Exception ex)
//	    {
//	     ex.printStackTrace();
//	    }
//
//	    Thread.sleep(4000);
//	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//	    Thread.sleep(3000);
//	     
//	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//	    Thread.sleep(3000);
//	     
////		driver.findElement(By.id("AadhaarCardNo")).sendKeys(obj.dataUtility(page, 11, 1));
//	    Thread.sleep(3000);
//      
//	    r.keyPress(KeyEvent.VK_TAB);
//	    r.keyRelease(KeyEvent.VK_TAB);
//	    Thread.sleep(2000);
//      
//	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//	    Thread.sleep(2000);
//	    driver.findElement(By.id("AddressDTO_CommunicationHouseNo")).sendKeys(obj.dataUtility(page, 13	, 1));
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"addressdiv\"]/div[4]/span[2]/input"))
//	    .sendKeys(obj.dataUtility(page, 14, 1));
//	    Thread.sleep(5000);
//     
//	    r.keyPress(KeyEvent.VK_TAB);
//	    r.keyRelease(KeyEvent.VK_TAB);
//	    Thread.sleep(2000);
//    
//	    driver.findElement(By.id("AddressDTO_MobileNo")).sendKeys(obj.dataUtility(page, 15, 1));
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();
//	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//	    Thread.sleep(3000);
//	    //Nominee Details----
//	    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_AdmissionNo']"))
//	    .sendKeys(obj.dataUtility("GenaralData", 2, 1));
//	    Thread.sleep(5000);
//	    
//	    r.keyPress(KeyEvent.VK_TAB);
//	    r.keyRelease(KeyEvent.VK_TAB);
//	    Thread.sleep(2000);
//	    
//	    Select nomRelation =new Select(driver.findElement(By.xpath("//select[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Relation']")));
//	    nomRelation.selectByVisibleText(obj.dataUtility(page, 23, 1));
//	    Thread.sleep(3000);
//	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//	    Thread.sleep(3000);
//	    driver.findElement(By.id("btnfinish")).click();
//	    Thread.sleep(3000);
//	    //Save Popup----
//	    String newAdmissionNo=driver.findElement(By.xpath("(//div[contains(text(),'Generated Admission No.-')])[1]")).getText();     
//	    String SevenDigitAdmissionNum = newAdmissionNo.substring(newAdmissionNo.length() - 7);
//	    Thread.sleep(5000);
//	    System.out.println("SevenDigitAdmissionNum :"+SevenDigitAdmissionNum);
//	    obj.updateData("GenaralData", 0, 1, SevenDigitAdmissionNum);
//	    driver.findElement(By.xpath("//button[@id='btnsuccessmessageok']")).click();
//	    Thread.sleep(2000);
//	    //CLOSE TASK POPUP---------
//	    driver.findElement(By.xpath("(//button[text()='×'])[1]")).click();
//	    Thread.sleep(3000);
//	    //DASHBOARD--------------------
//	    driver.findElement(By.xpath("//a[@class='logo-a']")).click();
//	    Thread.sleep(3000);
//		  
//	}
//	/*
//	 * TC-3 Enrolling A member haveing nominee as non-member 
//	 */
//	@Test
//	public void enrollMemberNomineNonMember() throws Exception
//	{
//			Robot r= new Robot();
//			driver.findElement(By.xpath("//p[text()='Membership ']")).click();
//			Thread.sleep(5000);
//		    driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
//		    Thread.sleep(2000);
//		    Select customertype = new Select (driver.findElement(By.id("CustomerType")));
//		    customertype.selectByVisibleText(obj.dataUtility(page, 0, 1));
//		    Thread.sleep(1000);
//		    driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 1, 1));
//		    Thread.sleep(1000);
//		    driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 2, 1));
//		    Thread.sleep(1000);
//		    driver.findElement(By.id("GeneralDetailsDTO_Age")).sendKeys(obj.dataUtility(page, 3, 1));
//		    Thread.sleep(1000);
//		    Select Gender = new Select (driver.findElement(By.id("GeneralDetailsDTO_Gender")));
//		    Gender.selectByVisibleText(obj.dataUtility(page, 4, 1));
//		    Thread.sleep(2000);
//		    Select MaritalStatus = new Select (driver.findElement(By.id("GeneralDetailsDTO_MaritalStatus")));
//		    MaritalStatus.selectByVisibleText(obj.dataUtility(page, 5, 1));
//		    Thread.sleep(2000);
//		    Select Bloodgroup = new Select (driver.findElement(By.id("GeneralDetailsDTO_BloodGroup")));
//		    Bloodgroup.selectByVisibleText(obj.dataUtility(page, 6, 1));
//		    Thread.sleep(2000);
//		    driver.findElement(By.id("GeneralDetailsDTO_FatherName")).sendKeys(obj.dataUtility(page, 7, 1));
//		    Thread.sleep(1000);
//		    Select Religion = new Select (driver.findElement(By.id("GeneralDetailsDTO_Community")));
//		    Religion.selectByVisibleText(obj.dataUtility(page,8 , 1));
//		    Thread.sleep(2000);
//		    Select Caste = new Select (driver.findElement(By.id("GeneralDetailsDTO_Caste")));
//		    Caste.selectByVisibleText(obj.dataUtility(page, 9, 1));
//		    Thread.sleep(3000);
//		    driver.findElement(By.id("RefAdmissionNo")).sendKeys(obj.dataUtility(page, 10, 1));
//		    String refAdmit=driver.findElement(By.id("RefAdmissionNo")).getAttribute("value");
//		    int num=Integer.parseInt(refAdmit);
//		    System.out.println(num);
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//	      
//		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		    try
//		    {
//		    	 if(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
//		         {
//		    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))); 
//		    
//		     
//				     while(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
//				     {	
//				    	 Thread.sleep(2000);
//				    	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//				    	
//				    	 num++;
//				    	 String data=Integer.toString(num);
//				    	 Thread.sleep(2000);
//				    	 driver.findElement(By.id("RefAdmissionNo")).sendKeys(data,Keys.TAB,Keys.TAB);
//				    	 Thread.sleep(4000);
//				     }
//		         }
//		    	 else if(!driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed()){
//		    		 driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).click();
//		    		 Thread.sleep(1000);
//			 	     driver.findElement(By.xpath("//label[text()='Ledger Folio No.']")).sendKeys(obj.dataUtility(page, 12, 1));
//			 	     Thread.sleep(4000);
//		    	 }
//		    }
//		    catch(Exception ex)
//		    {
//		     ex.printStackTrace();
//		    }
//
//		    Thread.sleep(4000);
//		    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		    Thread.sleep(3000);
//		     
//		    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		    Thread.sleep(3000);
//		     
////		    driver.findElement(By.id("AadhaarCardNo")).sendKeys(obj.dataUtility(page, 11, 1));
//		    Thread.sleep(3000);
//	      
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//	      
//		    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//		    Thread.sleep(2000);
//		    driver.findElement(By.id("AddressDTO_CommunicationHouseNo")).sendKeys(obj.dataUtility(page, 13	, 1));
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//*[@id=\"addressdiv\"]/div[4]/span[2]/input"))
//		    .sendKeys(obj.dataUtility(page, 14, 1));
//		    Thread.sleep(5000);
//	     
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//	    
//		    driver.findElement(By.id("AddressDTO_MobileNo")).sendKeys(obj.dataUtility(page, 15, 1));
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();
//		    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//		    Thread.sleep(3000);
//		    //Nominee Details----
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_SurName']"))
//		    .sendKeys(obj.dataUtility(page, 17, 1));
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Name']"))
//		    .sendKeys(obj.dataUtility(page, 18, 1));
//		    Thread.sleep(2000);
//		    
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//		    
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Age']")).clear();
//		    Thread.sleep(1000);
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Age']"))
//		    .sendKeys(obj.dataUtility(page, 19, 1));
//		    Thread.sleep(1000);
//		    String nomineeAge=driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Age']")).getAttribute("value");
//		    int getNomAge=Integer.parseInt(nomineeAge);
//		    Select nomGender =new Select(driver.findElement(By.xpath("//select[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Gender']")));
//		    nomGender.selectByVisibleText(obj.dataUtility(page, 20, 1));
//		    Thread.sleep(2000);
//		    Select nomMrStatus=new Select(driver.findElement(By.xpath("//select[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_MaritalStatus']")));
//		    nomMrStatus.selectByVisibleText(obj.dataUtility(page, 21, 1));
//		    Thread.sleep(1000);
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_FatherName']"))
//		    .sendKeys(obj.dataUtility(page, 22, 1));
//		    Thread.sleep(1000);
//		    Select nomRelation =new Select(driver.findElement(By.xpath("//select[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_Relation']")));
//		    nomRelation.selectByVisibleText(obj.dataUtility(page, 23, 1));
//		    Thread.sleep(3000);
//		    driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomAddressDTO_CommunicationHouseNo']"))
//		    .sendKeys(obj.dataUtility(page, 24, 1));
//		    Thread.sleep(2000);
//		    
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//		    
//		    r.keyPress(KeyEvent.VK_TAB);
//		    r.keyRelease(KeyEvent.VK_TAB);
//		    Thread.sleep(2000);
//		    
//		    r.keyPress(KeyEvent.VK_DOWN);
//		    r.keyRelease(KeyEvent.VK_DOWN);
//		    Thread.sleep(2000);
//		    
//		    r.keyPress(KeyEvent.VK_DOWN);
//		    r.keyRelease(KeyEvent.VK_DOWN);
//		    Thread.sleep(2000);
//		    
////		    driver.findElement(By.xpath("//*[@id=\"addressdiv\"]/div[4]/span[2]/input")).sendKeys(obj.dataUtility(page, 25, 1));
////		    Thread.sleep(2000);
//		    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//		    Thread.sleep(3000);
//		    if(getNomAge<18)
//		    {
//		    	driver.findElement(By.xpath("//input[@id='GuardianDetailsDTO_GuarGeneralDetailsDTO_AdmissionNo']")).sendKeys(obj.dataUtility(page, 26, 1));
//		    	Thread.sleep(2000);
//		    	
//		    	r.keyPress(KeyEvent.VK_TAB);
//			    r.keyRelease(KeyEvent.VK_TAB);
//			    Thread.sleep(2000);
//			    
//			    Select gurRel=new Select(driver.findElement(By.xpath("//select[@id='GuardianDetailsDTO_GuarGeneralDetailsDTO_Relation']")));
//			    gurRel.selectByVisibleText(obj.dataUtility(page, 28, 1));
//			    Thread.sleep(2000);
//		    	
//		    }
//		    driver.findElement(By.id("btnfinish")).click();
//		    Thread.sleep(3000);
//		    //Save Popup----
//		    String newAdmissionNo=driver.findElement(By.xpath("(//div[contains(text(),'Generated Admission No.-')])[1]")).getText();     
//		    String SevenDigitAdmissionNum = newAdmissionNo.substring(newAdmissionNo.length() - 7);
//		    Thread.sleep(5000);
//		    System.out.println("SevenDigitAdmissionNum :"+SevenDigitAdmissionNum);
//		    obj.updateData("GenaralData", 0, 1, SevenDigitAdmissionNum);
//		    driver.findElement(By.xpath("//button[@id='btnsuccessmessageok']")).click();
//		    Thread.sleep(2000);
//		    //CLOSE TASK POPUP---------
//		    driver.findElement(By.xpath("(//button[text()='×'])[1]")).click();
//		    Thread.sleep(3000);
//		    //DASHBOARD--------------------
//		    driver.findElement(By.xpath("//a[@class='logo-a']")).click();
//		    Thread.sleep(3000);
//	}
//	/*
//	 * Verify the age of the member
//	 */
//	@Test
//	public void ageValidation() throws Exception
//	{
//	 Robot r=new Robot();
//	 driver.findElement(By.xpath("//p[text()='Membership ']")).click();
//	 Thread.sleep(3000);
//	 driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//u[text()='View Parameters']")).click();
//	 Thread.sleep(2000);
//	 String getminAge=driver.findElement(By.xpath("//td[text()='Minimum Age For Member']/../td[2]")).getText();
//	 System.out.println(getminAge);
//	 int minAge=Integer.parseInt(getminAge);
//	 minAge=minAge-1;
//	 String putMinAge=Integer.toString(minAge);
//	 String getMaxAge= driver.findElement(By.xpath("//td[text()='Maximum Age For Member']/../td[2]")).getText();
//	 int maxAge=Integer.parseInt(getMaxAge);
//	 maxAge=maxAge+1;
//	 String putMaxAge=Integer.toString(maxAge);
//	 Thread.sleep(5000);
//	 driver.findElement(By.xpath("//button[@id='btncloseloanparameters']")).click();
//	 Thread.sleep(4000);
//     Select customertype = new Select (driver.findElement(By.id("CustomerType")));
//     customertype.selectByVisibleText(obj.dataUtility(page, 0, 1));
//     Thread.sleep(1000);
//     driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 1, 1));
//     Thread.sleep(2000);
//     driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 2, 1));
//     Thread.sleep(2000);
//     WebElement age=driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']"));
//	 age.sendKeys(Keys.BACK_SPACE,putMinAge);
//	 Thread.sleep(5000);
//	 r.keyPress(KeyEvent.VK_TAB);
//	 r.keyRelease(KeyEvent.VK_TAB);
//	 Thread.sleep(2000);
//	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
//	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Member Age Should Be Between 18 and 99')]"))));
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).clear();
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).sendKeys(putMaxAge);
//	 Thread.sleep(5000);
//	 r.keyPress(KeyEvent.VK_TAB);
//	 r.keyRelease(KeyEvent.VK_TAB);
//	 Thread.sleep(2000);
//	 WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(3));
//	 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Member Age Should Be Between 18 and 99')]"))));
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).clear();
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).sendKeys(getminAge);
//	 Thread.sleep(2000);
//	 r.keyPress(KeyEvent.VK_TAB);
//	 r.keyRelease(KeyEvent.VK_TAB);
//	 Thread.sleep(2000);
//	 if(driver.findElement(By.xpath("//h2[contains(text(),'Member Age Should Be Between 18 and 99')]")).isDisplayed())
//	 {
//		 throw new RuntimeException("Invalid Popup has been displayed");
//	 }
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).clear();
//	 driver.findElement(By.xpath("//input[@id='GeneralDetailsDTO_Age']")).sendKeys(getMaxAge);
//	 Thread.sleep(2000);
//	 r.keyPress(KeyEvent.VK_TAB);
//	 r.keyRelease(KeyEvent.VK_TAB);
//	 Thread.sleep(2000);
//	 if(driver.findElement(By.xpath("//h2[contains(text(),'Member Age Should Be Between 18 and 99')]")).isDisplayed())
//	 {
//		 throw new RuntimeException("Invalid Popup has been displayed");
//	 }
//	
//	}
//	/*
//	 * Without entering data it just click in the next button
//	 */
//	@Test
//	public void justClickNext() throws Exception
//	{
//		driver.findElement(By.xpath("//p[text()='Membership ']")).click();
//	    Thread.sleep(5000);
//	    driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
//	    Thread.sleep(2000);
//		Robot r=new Robot();
//		
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(4000);
//		
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(4000);
//		
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(4000);
//	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//	    Thread.sleep(4000);
//	    
//	    WebElement nextErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Customer Type) ']"));   
//	    Assert.assertEquals( nextErrormsg.getText(),"* Marked Fields Are Mandatory General Details (Customer Type)");
//	    driver.findElement(By.xpath("//button[text()='OK']")).click();
//	    Thread.sleep(2000);
//	}
//	@Test
//	public void refresh()throws Exception
//	{
//	  driver.findElement(By.xpath("//p[text()='Membership ']")).click();
//      Thread.sleep(5000);
//      driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
//      Thread.sleep(2000);
//      Select customertype = new Select (driver.findElement(By.id("CustomerType")));
//      customertype.selectByVisibleText(obj.dataUtility(page, 0, 1));
//      Thread.sleep(1000);
//      driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 1, 1));
//      driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 2, 1));
//      driver.findElement(By.id("GeneralDetailsDTO_Age")).sendKeys(obj.dataUtility(page, 3, 1));
//      Select Gender = new Select (driver.findElement(By.id("GeneralDetailsDTO_Gender")));
//      Gender.selectByVisibleText(obj.dataUtility(page, 4, 1));
//      Thread.sleep(2000);
//      Select MaritalStatus = new Select (driver.findElement(By.id("GeneralDetailsDTO_MaritalStatus")));
//      MaritalStatus.selectByVisibleText(obj.dataUtility(page, 5, 1));
//      Thread.sleep(2000);
//      Select Bloodgroup = new Select (driver.findElement(By.id("GeneralDetailsDTO_BloodGroup")));
//      Bloodgroup.selectByVisibleText(obj.dataUtility(page, 6, 1));
//      Thread.sleep(2000);
//      driver.findElement(By.id("GeneralDetailsDTO_FatherName")).sendKeys(obj.dataUtility(page, 7, 1));
//      Thread.sleep(1000);
//      Select Religion = new Select (driver.findElement(By.id("GeneralDetailsDTO_Community")));
//      Religion.selectByVisibleText(obj.dataUtility(page, 8, 1));
//      Thread.sleep(2000);
//      Select Caste = new Select (driver.findElement(By.id("GeneralDetailsDTO_Caste")));
//      Caste.selectByVisibleText(obj.dataUtility(page, 9, 1));
//      Thread.sleep(6000);
//      driver.findElement(By.id("RefAdmissionNo")).sendKeys(obj.dataUtility(page, 10, 1));
//      String refAdmit=driver.findElement(By.id("RefAdmissionNo")).getAttribute("value");
//      int num=Integer.parseInt(refAdmit);
//      Robot r=new Robot();
//      r.keyPress(KeyEvent.VK_TAB);
//      r.keyRelease(KeyEvent.VK_TAB);
//      Thread.sleep(2000);
//      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
//	     try
//	     {
//	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))); 
//	     
//	     while(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
//	     {	
//	    	 Thread.sleep(2000);
//	    	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//	    	
//	    	 num++;
//	    	 String data=Integer.toString(num);
//	    	 Thread.sleep(2000);
//	    	 driver.findElement(By.id("RefAdmissionNo")).sendKeys(data,Keys.TAB);
//	    	 Thread.sleep(4000);
//	     }
//	     }
//	     catch(Exception ex)
//	     {
//	    	 
//	     }
//	  driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//      Thread.sleep(4000);
//      Navigation n=driver.navigate();
//      n.refresh();
//		
//      r.keyPress(KeyEvent.VK_TAB);
//      r.keyRelease(KeyEvent.VK_TAB);
//      Thread.sleep(4000);
//		
//      r.keyPress(KeyEvent.VK_TAB);
//      r.keyRelease(KeyEvent.VK_TAB);
//      Thread.sleep(4000);
//		
//      r.keyPress(KeyEvent.VK_PAGE_DOWN);
//      r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//      Thread.sleep(4000);
//	  driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//	    
//	  WebElement nextErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Customer Type) ']"));   
//	  Assert.assertEquals("* Marked Fields Are Mandatory General Details (Customer Type)", nextErrormsg.getText());
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//button[text()='OK']")).click();
//	  Thread.sleep(2000);
//	}
//    /*
//     * Verify the Enroll member screen with valid and in valid data and also verify the popup messages 
//     */
//	
////	public void enrollMemberNegitive() throws Exception
////	{
////		driver.findElement(By.xpath("//p[text()='Membership ']")).click();
////	    Thread.sleep(2000);
////	    driver.findElement(By.xpath("//li[@id='10001']//a[contains(text(),'Enroll Member')]")).click();
////	    Thread.sleep(2000);
////		Robot r=new Robot();
////		
////		r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_PAGE_DOWN);
////		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
////		Thread.sleep(2000);
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    WebElement nextErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Customer Type) ']"));   
////	    Assert.assertEquals( nextErrormsg.getText(),"* Marked Fields Are Mandatory General Details (Customer Type)");
////	    if(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
////	    {
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    	r.keyPress(KeyEvent.VK_PAGE_UP);
////			r.keyRelease(KeyEvent.VK_PAGE_UP);
////			Thread.sleep(2000);
////	    }
////	    
////		
////		Select customertype = new Select (driver.findElement(By.id("CustomerType")));
////	    customertype.selectByVisibleText("Member");
////	    Thread.sleep(1000);
////	    
////	    r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_PAGE_DOWN);
////		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
////		Thread.sleep(2000);
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    
////	    WebElement surnameErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Surname) ']"));   
////	    Assert.assertEquals( surnameErrormsg.getText(),"* Marked Fields Are Mandatory General Details (Surname)");
////	    if(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
////	    {
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    	r.keyPress(KeyEvent.VK_PAGE_UP);
////			r.keyRelease(KeyEvent.VK_PAGE_UP);
////			Thread.sleep(2000);
////	    }
////	    
//////		    //AdmissionDate----------
//////		    Calendar cal=Calendar.getInstance();
//////			cal.add(Calendar.DAY_OF_MONTH,1);
//////			Date d=cal.getTime();
//////			SimpleDateFormat sdf=new SimpleDateFormat("01/06/2023");
//////			String modified_date=sdf.format(d);
//////			driver.findElement(By.xpath("//input[@id='AdmissionDate']")).sendKeys(modified_date);
//////			Thread.sleep(2000);
//////			
//////			r.keyPress(KeyEvent.VK_TAB);
//////			r.keyRelease(KeyEvent.VK_TAB);
//////			Thread.sleep(2000);
//////			
//////			r.keyPress(KeyEvent.VK_TAB);
//////			r.keyRelease(KeyEvent.VK_TAB);
//////			Thread.sleep(2000);
//////			
//////			r.keyPress(KeyEvent.VK_PAGE_DOWN);
//////			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//////			Thread.sleep(2000);
//////		    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//////		    
//////		    WebElement admitionDate=driver.findElement(By.xpath("/html/body/div[18]/h2"));
//////		    if(admitionDate.isDisplayed())
//////		    {
//////		    	Assert.assertEquals(admitionDate.getText(), "Admission Date Cannot Be Greater Than Today Or Date You Entered During Your Login");
//////		    	driver.findElement(By.xpath("//button[text()='OK']")).click();
//////		    	Thread.sleep(2000);
//////		    }
//////		    
////	    
////	    driver.findElement(By.id("GeneralDetailsDTO_SurName")).sendKeys(obj.dataUtility(page, 0, 1));
////	    Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_PAGE_DOWN);
////		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
////		Thread.sleep(2000);
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    
////	    WebElement nameMessage=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Name) ']"));
////	    if (nameMessage.isDisplayed())
////	    {
////	    	Assert.assertEquals(nameMessage.getText(), "* Marked Fields Are Mandatory General Details (Name)");
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    }
////	    
////	    driver.findElement(By.id("GeneralDetailsDTO_Name")).sendKeys(obj.dataUtility(page, 1, 1));
////		
////		r.keyPress(KeyEvent.VK_PAGE_DOWN);
////		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
////		Thread.sleep(2000);
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    WebElement ageMsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Date of Birth) ']"));
////	    if(ageMsg.isDisplayed())
////	    {
////	    	Assert.assertEquals(ageMsg.getText(), "* Marked Fields Are Mandatory General Details (Date of Birth)");
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    }
////	    
////	    WebElement age=driver.findElement(By.xpath("(//input[@value='0'])[3]"));
////	    age.sendKeys(Keys.BACK_SPACE,obj.dataUtility(page, 2, 2));
////	    String s=age.getAttribute("value");
////	    r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////	    
//////		    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
//////		    Thread.sleep(3000);
////	    int value = Integer.parseInt(s);
////	    if (value >= 85 || value <= 19) 
////	    {
////	    	WebElement genderMsg1=driver.findElement(By.xpath("//h2[text()='Member Age Should Be Between 18 and 85']"));
////	    	if(genderMsg1.isDisplayed());
////		    {
////		    	Assert.assertEquals(genderMsg1.getText(), "Member Age Should Be Between 18 and 85");
////		    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////		    	Thread.sleep(2000);
////		    	driver.findElement(By.xpath("(//input[@value='0'])[3]")).sendKeys(Keys.BACK_SPACE,obj.dataUtility(page, 2, 1));
////		    	
////		    	r.keyPress(KeyEvent.VK_TAB);
////				r.keyRelease(KeyEvent.VK_TAB);
////				Thread.sleep(2000);
////		    }
////	    }
////	   
////		
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    Thread.sleep(3000);
////	    WebElement genderMsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Gender) ']"));
////	    
////	    if(genderMsg.isDisplayed())
////	    {
////	    	Assert.assertEquals(genderMsg.getText(), "* Marked Fields Are Mandatory General Details (Gender)");
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    }
////	    
////	    Thread.sleep(2000);
////	    Select Gender = new Select (driver.findElement(By.id("GeneralDetailsDTO_Gender")));
////	    Gender.selectByVisibleText(obj.dataUtility(page, 3, 1));
////	    Thread.sleep(2000);
////	    
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    Thread.sleep(3000);
////	    
////	    
////	    WebElement MaritalErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Marital Status) ']"));   
////	   
////	    if(MaritalErrormsg.isDisplayed())
////	    {
////	    	Assert.assertEquals( MaritalErrormsg.getText(),"* Marked Fields Are Mandatory General Details (Marital Status)");
////	    	Thread.sleep(2000);
////	    	driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    }
////	    Select MaritalStatus = new Select (driver.findElement(By.id("GeneralDetailsDTO_MaritalStatus")));
////	    MaritalStatus.selectByVisibleText(obj.dataUtility(page, 4, 1));
////	    Thread.sleep(2000);
////	  
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    Thread.sleep(3000);
////	    
////	    WebElement FathernameErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Father Name) ']"));   
////		if(FathernameErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(FathernameErrormsg.getText(), "* Marked Fields Are Mandatory General Details (Father Name)");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////		}
////		driver.findElement(By.id("GeneralDetailsDTO_FatherName")).sendKeys(obj.dataUtility(page, 5, 1));
////	    Thread.sleep(1000);
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    Thread.sleep(3000);
////	    WebElement ReligionErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Religion) ']"));   
////		if(ReligionErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(ReligionErrormsg.getText(), "* Marked Fields Are Mandatory General Details (Religion)");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////		}
////		Select Religion = new Select (driver.findElement(By.id("GeneralDetailsDTO_Community")));
////	    Religion.selectByVisibleText("Hindu");
////	    Thread.sleep(2000);
////	    
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    
////	    WebElement CategoryErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Caste Category) ']"));   
////		if(CategoryErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(CategoryErrormsg.getText(), "* Marked Fields Are Mandatory General Details (Caste Category)");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////		}
////		Select Caste = new Select (driver.findElement(By.xpath("//select[@id='GeneralDetailsDTO_Caste']")));
////	    Caste.selectByVisibleText("General");
////	    Thread.sleep(2000);
////	     
////	    driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    
////	    WebElement SocietyAdmissionNoErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory General Details (Society Admission No) ']"));   
////		if(SocietyAdmissionNoErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(SocietyAdmissionNoErrormsg.getText(), "* Marked Fields Are Mandatory General Details (Society Admission No)");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////	    	
////		}
////		driver.findElement(By.id("RefAdmissionNo")).sendKeys(obj.dataUtility(page, 6, 1),Keys.TAB);
////	      String refAdmit=driver.findElement(By.id("RefAdmissionNo")).getAttribute("value");
////	      int num=Integer.parseInt(refAdmit);
////	      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
////		     try
////		     {
////		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))); 
////		     
////		     while(driver.findElement(By.xpath("//button[text()='OK']")).isDisplayed())
////		     {	
////		    	 Thread.sleep(2000);
////		    	 driver.findElement(By.xpath("//button[text()='OK']")).click();
////		    	
////		    	 num++;
////		    	 String data=Integer.toString(num);
////		    	 Thread.sleep(2000);
////		    	 driver.findElement(By.id("RefAdmissionNo")).sendKeys(data,Keys.TAB);
////		    	 Thread.sleep(4000);
////		     }
////		     }
////		     catch(Exception ex)
////		     {
////		    	 
////		     }
////		
////		
////		Thread.sleep(2000);
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		WebElement houseno=driver.findElement(By.xpath("//input[@id='AddressDTO_CommunicationHouseNo']"));
////		if(houseno.isDisplayed())
////		{
////			Assert.assertEquals(houseno.isDisplayed(), true);
////			driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////			Thread.sleep(2000);
////			WebElement housenoErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory']"));   
////			if(housenoErrormsg.isDisplayed())
////			{
////				Assert.assertEquals(housenoErrormsg.getText(), "* Marked Fields Are Mandatory");
////				Thread.sleep(2000);
////				driver.findElement(By.xpath("//button[text()='OK']")).click();
////		    	Thread.sleep(2000);
////			}
////			
////		}
////		houseno.sendKeys(obj.dataUtility(page, 9, 1));
////		Thread.sleep(2000);
////		
////		r.keyPress(KeyEvent.VK_TAB);
////		r.keyRelease(KeyEvent.VK_TAB);
////		Thread.sleep(2000);
////		
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		
////		WebElement villageErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory']"));   
////		if(villageErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(villageErrormsg.getText(), "* Marked Fields Are Mandatory");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////		}
////		driver.findElement(By.xpath("//*[@id=\"addressdiv\"]/div[4]/span[2]/input"))
////	    .sendKeys(obj.dataUtility(page, 10,1));
////		Thread.sleep(2000);
////		
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		
////		WebElement checkboxErrormsg=driver.findElement(By.xpath("//h2[text()='* Marked Fields Are Mandatory']"));   
////		if(checkboxErrormsg.isDisplayed())
////		{
////			Assert.assertEquals(checkboxErrormsg.getText(), "* Marked Fields Are Mandatory");
////			Thread.sleep(2000);
////			driver.findElement(By.xpath("//button[text()='OK']")).click();
////	    	Thread.sleep(2000);
////		}
////		driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();
////		Thread.sleep(3000);
////		
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		WebElement nomeneepage=driver.findElement(By.xpath("//input[@id='NomineDetailsMasterDTO_NomGeneralDetailsDTO_AdmissionNo']"));
////		if(nomeneepage.isDisplayed())
////		{
////			Assert.assertEquals(nomeneepage.isDisplayed(), true);
////			
////		}
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		
////		WebElement guardianpage=driver.findElement(By.xpath("(//div[@class='col-sm-12'])[15]"));
////		if(guardianpage.isDisplayed())
////		{
////			Assert.assertEquals(guardianpage.isDisplayed(), true);
////			Thread.sleep(2000);
////		}
////		driver.findElement(By.id("btnfinish")).sendKeys(Keys.ENTER);
////	    Thread.sleep(3000);
////	    
////	    WebElement success=driver.findElement(By.xpath("(//div[@class='modal-body'])[7]"));
////	    if(success.isDisplayed())
////	    {
////	    	Assert.assertEquals(success.isDisplayed(), true);
////	    	driver.findElement(By.xpath("(//div[@class='modal-body'])[7]/../div[4]/button")).click();
////	    }
////		
////	}
////	
////	
}