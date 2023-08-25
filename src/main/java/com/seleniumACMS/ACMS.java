package com.seleniumACMS;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACMS {

    private static final long MIN_MOBILE_NUMBER = 6000000000L; // Minimum mobile number value (starting from 6)
    private static final long MAX_MOBILE_NUMBER = 9999999999L; // Maximum mobile number value
	private static CharSequence uniqueMobileNumber;
    public static void main(String[] args) {

        String uniquePackageName = generateUniquePackageName();

		String uniqueIds = "AM" + System.currentTimeMillis();

        System.out.println("Code By Mr Suraj Dev Rajak");


		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("OnnetSystems", "Selenium Testing Of Our ACMS Product ");
		
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Duration duration = Duration.ofSeconds(200);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

        try {
            driver.get("http://143.110.248.51:5500/login");

            driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys("onnet@gmail.com");
            driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys("Onnet@1234");
            driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div/div/form/div[2]/button[2]"))
                    .click();

            Thread.sleep(2000);

            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/dashboard"));

            driver.navigate().to("http://143.110.248.51:5500/admin");

            WebDriverWait wait1 = new WebDriverWait(driver, duration);
            wait1.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin"));

            Thread.sleep(2000);

            driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/a/button")).click();

            driver.navigate().to("http://143.110.248.51:5500/admin/create");
            WebDriverWait wait2 = new WebDriverWait(driver, duration);
           wait2.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin/create"));

            // Generate unique mobile number, email ID, and admin name
            CharSequence uniqueMobileNumber = generateUniqueMobileNumber();
            String uniqueEmailId = generateUniqueEmailId();
            String uniqueAdminName = generateUniqueAdminName();

            driver.findElement(By.cssSelector("input[formcontrolname=\"adminName\"]")).sendKeys(uniqueAdminName);
            driver.findElement(By.cssSelector("input[formcontrolname=\"email\"]")).sendKeys(uniqueEmailId);
            driver.findElement(By.cssSelector("input[formcontrolname=\"mobileNumber\"]")).sendKeys(uniqueMobileNumber);
            driver.findElement(By.cssSelector("input[formcontrolname=\"adminPassword\"]")).sendKeys("Strong@22344");
            driver.findElement(By.cssSelector("input[formcontrolname=\"cPassword\"]")).sendKeys("Strong@22344");

            
            WebElement dropdown = driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-admin-create/div/div/div/div/form/div/div[2]/div[7]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
			dropdown.click();
			WebElement option = driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-admin-create/div/div/div/div/form/div/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"));
			option.click();
			test1.pass("Filling All The deatils To create New Admin ");
			
					
			driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-admin-create/div/div/div/div/form/div/div[3]/button[2]/img"))
					.click();
			test1.pass("Clicking Save Button to save all the Details");
            
			
		
            /**
//			 * 
//			 * @author SurajDevRajak
//			 *
//			 */ // Adding Filter
			 // Wait for the filter button to be clickable and click it
	        WebDriverWait waitqs = new WebDriverWait(driver, duration);
	        WebElement filterButtonqs = waitqs.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/button")));
	        filterButtonqs.click();
            Thread.sleep(2000);

	        // Wait for the dropdown to be clickable and click it
	        By dropdownLocatorqsa = By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/select");
	        WebElement dropdownqsa = waitqs.until(ExpectedConditions.elementToBeClickable(dropdownLocatorqsa));
	        dropdownqsa.click();
            Thread.sleep(2000);

	        // Find and click on the "Active" option in the dropdown
            By dropdownLocatoroil = By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/select");
            WebElement dropdownElementoil = driver.findElement(dropdownLocatoroil);
            Select dropdownSelectoil = new Select(dropdownElementoil);
            dropdownSelectoil.selectByVisibleText("Active");
            Thread.sleep(2000);

            
	        // Click on the input element (you might want to replace this with appropriate actions)
	        driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/div/button[2]")).click();
	        
            Thread.sleep(2000);

	        //clear Filter
	        
	        driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/span"))
					.click();
	        
            Thread.sleep(2000);

	        
	        
//			/**
//			 * 
//			 * @author SurajDevRajak
//			 *
//			 */ // Adding Search Functionality
//
			String searchKeyword = "9010133880";
			WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-admin-list > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For Mobile no or any type As I passed as String");
			searchInput.sendKeys(searchKeyword);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInput.sendKeys(Keys.ENTER);
			searchInput.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions = new Actions(driver);
			actions.sendKeys(searchInput, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/admin");
			WebDriverWait wait5 = new WebDriverWait(driver, duration);
			wait5.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin"));
			test1.pass("Navigating to Admin Page");
			
			
			
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			   // pagination 
            WebDriverWait waitlv = new WebDriverWait(driver, duration);
            WebElement dropdownlv = waitlv.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[2]/div[1]/select")));

            // Select "5" from the dropdown
            Select selecting = new Select(dropdownlv);
            selecting.selectByVisibleText("5");
			
			
			
			 WebElement nextPageButton00 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
		        nextPageButton00.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton00 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[2]/div[2]/button[2]/img"));
		        previousPageButton00.click();
		        
		        
		        
		        WebElement nextPageButton01 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[2]/div[2]/button[4]/img"));
		        nextPageButton01.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton01 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[2]/div[2]/button[1]/img"));
		        previousPageButton01.click();
			
//			/**
//			 * 
//			 * @author SurajDevRajak
//			 *
//			 */ // Adding Action Functionality
//
			By toggleElementLocator = By.xpath(
					"/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/img");
			By enableOptionLocator = By.xpath(
					"/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/div/ul/li[2]");
			By disableOptionLocator = By.xpath(
					"/html/body/app-root/app-core/app-admin-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/div/ul/li[2]");
			test1.pass("Added Action Functionality to Enable or Disable The Admin  ");
			boolean isEnabled = true; // Set the initial state

			// Perform the toggle operation in a loop
			for (int i = 0; i < 5; i++) { // Repeat the toggle operation 5 times (adjust the loop count as needed)
				// Click the toggle element
				WebDriverWait wait10 = new WebDriverWait(driver, duration);
				wait10.until(ExpectedConditions.elementToBeClickable(toggleElementLocator)).click();

				// Wait for the options to appear
				WebDriverWait waitOptions = new WebDriverWait(driver, duration);
				waitOptions.until(ExpectedConditions.visibilityOfElementLocated(enableOptionLocator));

				// Check the current state and perform the corresponding action
				if (isEnabled) {
					// If it's enabled, click the disable option
					WebDriverWait waitDisable = new WebDriverWait(driver, duration);
					waitDisable.until(ExpectedConditions.elementToBeClickable(disableOptionLocator)).click();
				} else {
					// If it's disabled, click the enable option
					WebDriverWait waitEnable = new WebDriverWait(driver, duration);
					waitEnable.until(ExpectedConditions.elementToBeClickable(enableOptionLocator)).click();
				}

				// Update the state
				isEnabled = !isEnabled;

				// Add waiting time between each toggle operation
				try {
					Thread.sleep(1000); // Wait for 2 seconds (adjust the duration as needed)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			/**
//			 * 
//			 * @author SurajDevRajak
//			 *
//			 */ // Adding Edit Functionality
//
			driver.navigate().to("http://143.110.248.51:5500/admin/6492e39f71022e05c5ab674a");
			WebDriverWait wait15 = new WebDriverWait(driver, duration);
			wait15.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin/6492e39f71022e05c5ab674a"));
			
			test1.pass("Navigating to Edit Admin Page  ");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Testing is completed For Admin module");
			test1.log(Status.INFO, "Starting Subscribers Module Test Cases");
			
	
			
			
			/**
			 * 
			 * @author SurajDevRajak
			 *
			 */ 
			
			
			
//			
//			// SBSCRIBERS MODULE
////
//			// Navigating To Subscriber Module
//			
			driver.navigate().to("http://143.110.248.51:5500/subscribers");
			WebDriverWait wait20 = new WebDriverWait(driver, duration);
			wait20.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscribers"));
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Navigating to subscribers Page");
			
			
			
			// Adding Edit Functionality
						driver.findElement(
								By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[9]/img"))
								.click();
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
						
						driver.findElement(
								By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[9]/div/ul/li"))
								.click();
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
						driver.findElement(
								By.xpath("/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[3]/div/button"))
								.click();
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
//			
//			
//			
//			
//			
//			
////			/**
////			 * 
////			 * @author SurajDevRajak
////			 *
////			 */ // Creating New Subscribers
//
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[2]/a[4]/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Clicking to add new subscriber button");
			driver.findElement(By.cssSelector("input[formcontrolname=\"firstName\"]")).sendKeys("testing");
			driver.findElement(By.cssSelector("input[formcontrolname=\"lastName\"]")).sendKeys("Dj");
         driver.findElement(By.cssSelector("input[formcontrolname=\"mobileNumber\"]")).sendKeys(uniqueMobileNumber);
			driver.findElement(By.cssSelector("input[formcontrolname=\"email\"]")).sendKeys("testing@gmail.com");
			driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[2]/div[5]/select/option[1]"))
					.click();
			driver.findElement(By.cssSelector("input[formcontrolname=\"dob\"]")).sendKeys("2023-05-22");
			driver.findElement(By.cssSelector("input[formcontrolname=\"state\"]")).sendKeys("Delhi");
			driver.findElement(By.cssSelector("input[formcontrolname=\"franchiseId\"]")).sendKeys("RP00");
			// Click on the dropdown to open it
			WebElement dropdown22 = driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[2]/div[9]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
			dropdown22.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			// Select an option from the dropdown
			WebElement option22 = driver.findElement(By.xpath(
					"/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[2]/div[9]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"));
			option22.click();
			
			
			
//			try {
//			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
//			} catch (InterruptedException e) {
//			    e.printStackTrace();
//			}
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[3]/div/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
	//		 After clicking the proceed button
			driver.findElement(By
					.xpath("/html/body/app-root/app-core/app-user-add/div/div/div/div/div/div/div[2]/div[9]/button[2]"))
					.click();

			// Wait for the alert to be present
			WebDriverWait wait56 = new WebDriverWait(driver, duration);
			wait56.until(ExpectedConditions.alertIsPresent());
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Get the alert text (optional)
			String alertText = alert.getText();
			System.out.println("Alert Text: " + alertText);

			// Accept the alert (click OK)
			alert.accept();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Filling All The deatils To create New Subscribers ");
			test1.pass("Clicking Save Button to save all the Details");
			test1.pass("New Subscriber Created");
//            
//            
//			
//			
////          BulkUpload Feature
//
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[2]/a[3]/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[2]/a[2]/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.cssSelector("input[formcontrolname=\"franchiseId\"]")).sendKeys("RP00");
			// Locate the file input element
			WebElement fileInput = driver.findElement(By.id("fileInput"));
			System.out.println(fileInput);
			// Ensure the file input is visible and clickable
//			if (fileInput.isDisplayed()) {
//				fileInput.click();
//			} else {
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", fileInput);
//			}
          System.out.println("gcvhgjkl");
			// Provide the file path to upload

			fileInput.sendKeys("C:\\Users\\Admin\\Desktop\\DDDD\\BulkSubscribersInfo.xlsx");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-bulk-upload/div/div/div[3]/div/div[2]/div[3]/button/img")).click();

			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
           test1.pass("Bulkupload Done Successfully");
			
			// ********************************** BULK UPLOAD******************************

			driver.navigate().to("http://143.110.248.51:5500/subscribers");
//
//
//			 
//			
//			// Adding Filter
// 
//			
//			
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[1]/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			WebDriverWait wait41 = new WebDriverWait(driver, duration);
			By dropdownLocator41 = By
					.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[1]/div/div/select");
			By optionLocator41 = By
					.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[1]/div/div/select");
			wait41.until(ExpectedConditions.elementToBeClickable(dropdownLocator41)).click();
			wait41.until(ExpectedConditions.elementToBeClickable(optionLocator41)).click();
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[1]/div/div/div/button[2]"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Going To Filter page and selecting to All and clearing filter");

			driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[2]/div[1]/span"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
////
////			/**
////			 * 
////			 * @author SurajDevRajak
////			 *
////			 */ // Adding Search Functionality
//
			String searchKeyword40 = "7778964187";
			WebElement searchInput40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-user-list > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For Mobile no or any type  passed as String");
			searchInput40.sendKeys(searchKeyword40);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInput40.sendKeys(Keys.ENTER);
			searchInput40.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions40 = new Actions(driver);
			actions40.sendKeys(searchInput40, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			
			
			driver.navigate().to("http://143.110.248.51:5500/subscribers");
			WebDriverWait wait50 = new WebDriverWait(driver, duration);
			wait50.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscribers"));
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Navigating to Subscriber Page");

			
			
			
			   // pagination 
            WebDriverWait waitlvi = new WebDriverWait(driver, duration);
            WebElement dropdownlvi = waitlvi.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[2]/div[1]/select")));

            // Select "5" from the dropdown
            Select selectingi = new Select(dropdownlvi);
            selectingi.selectByVisibleText("5");
			
			
			
			 WebElement nextPageButton00i = driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[2]/div[2]/button[4]/img"));
		        nextPageButton00i.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton00i = driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[2]/div[2]/button[1]/img"));
		        previousPageButton00i.click();
			

			WebElement nextPageButtons = driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
	        nextPageButtons.click();
	       
	        
	        try {
			    Thread.sleep(1000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
	        
	        WebElement previousPageButtons = driver.findElement(By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[2]/div[2]/button[2]/img"));
	        previousPageButtons.click();

			
			
			
			
			// Adding Edit Functionality
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[9]/img"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-user-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[9]/div/ul/li"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-user-add/div/div/div/div/form/div/div[3]/div/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		
			test1.log(Status.INFO, "Starting Admin Groups Module Test Cases");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/a"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/ul/a[3]/li"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			// Search Admin Group
			
			String searchKeyword400 = "admin143";
			WebElement searchInput400 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-list-group > div > div > div.filters__search > div.search__table > input")));
			
			test1.pass("Clicking To Search button and searching For Mobile no or any type  passed as String");
			searchInput400.sendKeys(searchKeyword400);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			searchInput400.sendKeys(Keys.ENTER);
			searchInput400.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions400 = new Actions(driver);
			actions400.sendKeys(searchInput400, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			
			searchInput400.sendKeys(Keys.ENTER);
			searchInput400.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//					
			driver.navigate().to("http://143.110.248.51:5500/admin-groups");
			WebDriverWait wait501 = new WebDriverWait(driver, duration);
			wait501.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin-groups"));
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Navigating to admin-groups Page");		
		
			

	        
	        
			// Adding new adminGroups 
			
			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-group/div/div/div[2]/a/button"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			test1.pass("Clicking to add new admingroup button");
			driver.findElement(By.cssSelector("input[formcontrolname=\"adminGroupName\"]")).sendKeys("MAA");
			driver.findElement(By.cssSelector("textarea[formcontrolname='adminGroupDescription']"))
		    .sendKeys("Hello World");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-create-group/div/div/div/div/form/div[2]/div[4]/button[2]"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			   // pagination 
            WebDriverWait waitlvin = new WebDriverWait(driver, duration);
            WebElement dropdownlvin = waitlvin.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "/html/body/app-root/app-core/app-list-group/div/div/div[4]/div[2]/div[1]/select")));

            // Select "5" from the dropdown
            Select selectingin = new Select(dropdownlvin);
            selectingin.selectByVisibleText("5");
			
			
			
			 WebElement nextPageButton00in = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-group/div/div/div[4]/div[2]/div[2]/button[3]/img"));
		        nextPageButton00in.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton00in = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-group/div/div/div[4]/div[2]/div[2]/button[2]/img"));
		        previousPageButton00in.click();
			
			
		        WebElement nextPageButton00ine = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-group/div/div/div[4]/div[2]/div[2]/button[4]/img"));
		        nextPageButton00ine.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton00ine = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-group/div/div/div[4]/div[2]/div[2]/button[1]/img"));
		        previousPageButton00ine.click();
			
			
			
			
			
			
			// Action Edit And Delete AdminGroups
			
			driver.navigate().to("http://143.110.248.51:5500/admin-groups/6495c9d127e3085baf30586f");
			WebDriverWait wait153 = new WebDriverWait(driver, duration);
			wait153.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/admin-groups/6495c9d127e3085baf30586f"));
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-create-group/div/div/div/div/form/div[2]/div[4]/button[2]/img"))
					.click();
			test1.pass("Navigating to Edit Admin Page  ");
			
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
//			
			   // Generate unique managerName
	        String uniqueManagerName = "Testing_" + UUID.randomUUID().toString().substring(0, 8);

	        // Generate unique mailId
	        String uniqueMailId = "Surajdev" + new Random().nextInt(1000) + "@gmail.com";

	        // Generate unique mobileNumber
	        String uniqueMobileNumbersf = "9444" + String.format("%06d", new Random().nextInt(1000000));
			
			
			//Starting to  AccountManager is 
			
			test1.pass("Starting To Test Account Manager");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/a"))
					.click();
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/ul/a[4]/li"))
					.click();
//			
//			
//			
			//Creating New AccountManager
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[2]/a/button"))
					.click();
			driver.findElement(By.cssSelector("input[formcontrolname=\"managerName\"]")).sendKeys(uniqueManagerName);
	        driver.findElement(By.cssSelector("input[formcontrolname=\"mailId\"]")).sendKeys(uniqueMailId);
	        driver.findElement(By.cssSelector("input[formcontrolname=\"mobileNumber\"]")).sendKeys(uniqueMobileNumbersf);
				
		driver.findElement(
				By.xpath("/html/body/app-root/app-core/app-account-manager-create/div/div/div/div/form/div/div[3]/button[2]"))
				.click();

		
		
		
		
		// Action And Delete
		
		driver.findElement(
				By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/img"))
				.click();
		
		 WebElement deleteElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/div/ul/li[3]/img"));
	        deleteElement.click();
		 // Wait for the alert to be present
        WebDriverWait waitrhsgs = new WebDriverWait(driver, duration);
        waitrhsgs.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert4u4 = driver.switchTo().alert();

        // Accept the alert (clicking the OK button)
        alert4u4.accept();
		
		
		// Edit
		
		driver.navigate().to("http://143.110.248.51:5500/manager/edit-manager/52");
		WebDriverWait waitlistsgg = new WebDriverWait(driver, duration);
		waitlistsgg.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/manager/edit-manager/52"));
		driver.findElement(
				By.xpath("/html/body/app-root/app-core/app-account-manager-create/div/div/div/div/form/div/div[3]/button[2]"))
				.click();
		test1.pass("Navigating to Edit Admin Page  ");
		
		try {
		    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		test1.pass("Testing is completed For Admin module");
		test1.log(Status.INFO, "Starting Subscribers Module Test Cases");
		
		
		
		
		
		// Enable Disable AccountManager
		
		
		By toggleElementLocator1 = By.xpath(
				"/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/img");
		
		By enableOptionLocator1 = By.xpath(
				"/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/div/ul/li[2]");
		By disableOptionLocator1 = By.xpath(
				"/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[1]/table/tbody/tr[2]/td[5]/div/ul/li[2]");
		test1.pass("Added Action Functionality to Enable or Disable The Admin  ");
		boolean isEnabled1 = true; // Set the initial state

		// Perform the toggle operation in a loop
		for (int i = 0; i < 5; i++) { // Repeat the toggle operation 5 times (adjust the loop count as needed)
			// Click the toggle element
			WebDriverWait wait10000 = new WebDriverWait(driver, duration);
			wait10000.until(ExpectedConditions.elementToBeClickable(toggleElementLocator1)).click();

			// Wait for the options to appear
			WebDriverWait waitOptions148 = new WebDriverWait(driver, duration);
			waitOptions148.until(ExpectedConditions.visibilityOfElementLocated(enableOptionLocator1));

			// Check the current state and perform the corresponding action
			if (isEnabled1) {
				// If it's enabled, click the disable option
				WebDriverWait waitDisable1 = new WebDriverWait(driver, duration);
				waitDisable1.until(ExpectedConditions.elementToBeClickable(disableOptionLocator1)).click();
			} else {
				// If it's disabled, click the enable option
				WebDriverWait waitEnable1 = new WebDriverWait(driver, duration);
				waitEnable1.until(ExpectedConditions.elementToBeClickable(enableOptionLocator1)).click();
			}

			// Update the state
			isEnabled1 = !isEnabled1;

			// Add waiting time between each toggle operation
			try {
				Thread.sleep(1000); // Wait for 2 seconds (adjust the duration as needed)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		//			// Adding Filter
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
						driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[2]/div/button")).click();

						WebDriverWait wait144 = new WebDriverWait(driver, duration);
						By dropdownLocator144 = By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[2]/div/div/div/select");
						By optionLocator144 = By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[2]/div/div/div/select");

						WebElement dropdownElement144 = wait144.until(ExpectedConditions.elementToBeClickable(dropdownLocator144));
						dropdownElement144.click();

						WebElement optionElement144 = wait144.until(ExpectedConditions.elementToBeClickable(optionLocator144));
						optionElement144.click();

						driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[2]/div/div/div/div/button[2]")).click();

						try {
						    Thread.sleep(2000); // 2 seconds = 2000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}

						test1.pass("Going To Filter page and selecting All as Status");

						

						
						/**
						 * 
						 * @author SurajDevRajak
						 *
						 */ // Adding Search Functionality

						String searchKeyword143 = "7878909099";
						WebElement searchInput143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
								"body > app-root > app-core > app-account-manager-list > div > div > div.filters__search > div.search__table > input")));
						test1.pass("Clicking To Search button and searching For Mobile no or any type As I passed as String");
						searchInput143.sendKeys(searchKeyword143);
					
						searchInput143.sendKeys(Keys.ENTER);
						searchInput143.clear();						
						Actions actions143 = new Actions(driver);
						actions143.sendKeys(searchInput143, Keys.ENTER).perform();
						test1.pass("After searching, the search field is cleared");
						driver.navigate().to("http://143.110.248.51:5500/manager");
						WebDriverWait wait143 = new WebDriverWait(driver, duration);
						wait143.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/manager"));
						test1.pass("Navigating to Admin Page");
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
				
				
						   // pagination 
			            WebDriverWait waitlving = new WebDriverWait(driver, duration);
			            WebElement dropdownlving = waitlving.until(ExpectedConditions.elementToBeClickable(By.xpath(
			                    "/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[2]/div[1]/select")));

			            // Select "5" from the dropdown
			            Select selectinging = new Select(dropdownlving);
			            selectinging.selectByVisibleText("5");
						
						
						
						 WebElement nextPageButton00ing = driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[2]/div[2]/button[4]/img"));
					        nextPageButton00ing.click();
					       
					        
					        try {
							    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
							} catch (InterruptedException e) {
							    e.printStackTrace();
							}
					        
					        WebElement previousPageButton00ingd = driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[2]/div[2]/button[1]/img"));
					        previousPageButton00ingd.click();	

			         			
						
						
						
						
						
						//////
				
						WebElement nextPageButtons2 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
				        nextPageButtons2.click();
				       
				        
				        try {
						    Thread.sleep(1000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
				        
				        WebElement previousPageButtons2 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-account-manager-list/div/div/div[4]/div[2]/div[2]/button[2]/img"));
				        previousPageButtons2.click();
						
				

				
				
						
			test1.pass("Starting To Test CONTENT Module  PROVIDERS ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"))
					.click();
			
			driver.navigate().to("http://143.110.248.51:5500/ott-onboarding");
			WebDriverWait wait1434jh = new WebDriverWait(driver, duration);
			wait1434jh.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/ott-onboarding"));
			test1.pass("Navigating to Admin Page");
//			
//			
//			// creating new provider
//			
//			test1.pass("creating new provider ");
//			driver.findElement(
//					By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/a/button/img"))
//					.click();
//			
//			WebElement dropdownElementope = driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-onboarding/div/div/div/div/form/div/table/tbody/tr[1]/td[2]/select"));
//
//			Select dropdownope = new Select(dropdownElementope);
//			dropdownope.selectByVisibleText("Sony Liv");
//
//			
//			
//			WebElement dropdownElementoper = driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-onboarding/div/div/div/div/form/div/table/tbody/tr[2]/td[2]/select"));
//
//			Select dropdownoper = new Select(dropdownElementoper);
//			dropdownoper.selectByVisibleText("Tier 1");
//			
//			
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"concurrentViews\"]")).sendKeys("1");
//
//			
//			
//			
//			WebElement dropdownElementoperat = driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-onboarding/div/div/div/div/form/div/table/tbody/tr[4]/td[2]/select"));
//
//			Select dropdownoperat = new Select(dropdownElementoperat);
//			dropdownoperat.selectByVisibleText("Coupon based");
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"offeredPrice\"]")).sendKeys("1");
//
//			driver.findElement(By.cssSelector("input[formcontrolname=\"enduserPrice\"]")).sendKeys("1");
//
//			
//			
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"validFrom\"]")).sendKeys("2023-17-6");
//			driver.findElement(By.cssSelector("input[formcontrolname=\"validTo\"]")).sendKeys("2023-12-6");
//
//			driver.findElement(By.cssSelector("input[formcontrolname=\"providerEmail\"]")).sendKeys("suraj@gmail.com");
//
//			driver.findElement(By.cssSelector("input[formcontrolname=\"providerPhone\"]")).sendKeys("9110133887");
//
//			driver.findElement(
//					By.xpath("/html/body/app-root/app-core/app-partner-onboarding/div/div/div/div/form/div/div[3]/button[2]"))
//					.click();
//			
//			
			
			
			
			   // Adding Filter
//          
          driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/button"))
          .click();

  // Wait for 2 seconds (Optional delay, consider using explicit waits instead)
          Thread.sleep(2000);

  // Select "Tier" from the first dropdown
  By dropdownLocatoroilys = By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/div/div/select[1]");
  WebElement dropdownElementoilys = driver.findElement(dropdownLocatoroilys);
  Select dropdownSelectoilys = new Select(dropdownElementoilys);
  dropdownSelectoilys.selectByVisibleText("Tier 1");

  Thread.sleep(2000);
  
  // Select "Coupon based" from the second dropdown
  By optionLocatoro1 = By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/div/div/select[2]");
  WebElement optionElemento1 = driver.findElement(optionLocatoro1);
  Select optionSelecto1 = new Select(optionElemento1);
  optionSelecto1.selectByVisibleText("Coupon based");

  Thread.sleep(2000);
  
  // Select "3 months" from the third dropdown
  By optionLocatoro2 = By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/div/div/select[3]");
  WebElement optionElemento2 = driver.findElement(optionLocatoro2);
  Select optionSelecto2 = new Select(optionElemento2);
  optionSelecto2.selectByVisibleText("Active");

  Thread.sleep(2000);
  
  // Click on the button to apply the filter (you might want to adjust the locator according to your specific case)
  driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/div/div/div/button[2]"))
          .click();

  // Wait for 2 seconds (Optional delay, consider using explicit waits instead)
  Thread.sleep(2000);
  
  //clear all filter
  driver.findElement(By.xpath("/html/body/app-root/app-core/app-partner-dashboard/div/div/div[2]/div[1]/div/span"))
  .click();        
          
  Thread.sleep(2000);        
        
	test1.pass("Filter has applied Successfully in packages");
			
			
			
			
			
			
//			
//			// search Functionality
//			
			String searchKeywordjanu1 = "Hotstar";
			WebElement searchInputjanu1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-partner-dashboard > div > div > div.content__box--inner > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputjanu1.sendKeys(searchKeywordjanu1);
			
			searchInputjanu1.sendKeys(Keys.ENTER);
			searchInputjanu1.clear();
			
			Actions actionsjanu1 = new Actions(driver);
			actionsjanu1.sendKeys(searchInputjanu1, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/ott-onboarding");
			WebDriverWait waitjanu12 = new WebDriverWait(driver, duration);
			waitjanu12.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/ott-onboarding"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
		
			test1.pass("Starting To Test CONTENT ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/packages");
			WebDriverWait wait14346 = new WebDriverWait(driver, duration);
			wait14346.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/packages"));
			test1.pass("Navigating to Admin Page");
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-pack-list/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
			// adding new packages

			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-pack-list/div/div/div[2]/div[2]/a[2]/button"))
					.click();
			
			 driver.findElement(By.cssSelector("input[formcontrolname=\"packageName\"]")).sendKeys(uniquePackageName);
			 driver.findElement(
						By.xpath("/html/body/app-root/app-core/app-pack-add/div/div/div/form/div[2]/div[3]/select"))
						.click();
			 driver.findElement(
						By.xpath("/html/body/app-root/app-core/app-pack-add/div/div/div/form/div[2]/div[4]/div/div/div[2]/ul/li[1]/div/img"))
						.click();
			  // Find the checkboxes for "Duration 12 months", "MRP 20", and "FranchisePrice 5"
			 WebElement numberInput = driver.findElement(By.cssSelector("input[type='number']"));

		        // Input the desired value
		        String valueToInput = "2";
		        numberInput.sendKeys(valueToInput);
		        
		        // Find the input field of type "number"
		        WebElement numberInput23 = driver.findElement(By.cssSelector("#price__table > tbody > tr > td:nth-child(2) > input[type=number]"));

		        // Clear the existing value (if any)
	//	        numberInput23.clear();

		        // Input the desired value
		        String valueToInput23 = "2";
		        numberInput23.sendKeys(valueToInput23);

		        // Find the input field of type "number"
		        WebElement numberInput234 = driver.findElement(By.cssSelector("#price__table > tbody > tr > td:nth-child(3) > input"));

		        // Clear the existing value (if any)
		//        numberInput234.clear();

		        // Input the desired value
		        String valueToInput234 = "5";
		        numberInput234.sendKeys(valueToInput234);
		        
		        
		        // Find the input field of type "number"
		        WebElement numberInput234g = driver.findElement(By.cssSelector("#price__table > tbody > tr > td:nth-child(4) > input"));

		        // Clear the existing value (if any)
		//        numberInput234.clear();

		        // Input the desired value
		        String valueToInput234g = "1";
		        numberInput234g.sendKeys(valueToInput234g);

		        
			 driver.findElement(
						By.xpath("/html/body/app-root/app-core/app-pack-add/div/div/div/form/div[2]/div[6]/button[2]"))
						.click();
		   
			 
			 
			 driver.navigate().to("http://143.110.248.51:5500/packages");
				WebDriverWait wait14346000 = new WebDriverWait(driver, duration);
				wait14346000.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/packages"));
				test1.pass("Navigating to Admin Page");
			
				
			
			
			
			
			// search packages
			
			String searchKeywordjanu11 = "TestingPackOnnet";
			WebElement searchInputjanu11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-pack-list > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputjanu11.sendKeys(searchKeywordjanu11);
			
			searchInputjanu11.sendKeys(Keys.ENTER);
			searchInputjanu11.clear();
			
			Actions actionsjanu11 = new Actions(driver);
			actionsjanu11.sendKeys(searchInputjanu11, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/packages");
			WebDriverWait waitjanu13 = new WebDriverWait(driver, duration);
			waitjanu13.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/packages"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			

			 WebElement nextPageButton1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-pack-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
		        nextPageButton1.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-pack-list/div/div/div[4]/div[2]/div[2]/button[2]/img"));
		        previousPageButton1.click();
			
			
		        
		//Enable Disable pacakges        
		        
		        By toggleElementLocator1boi = By.xpath(
						"/html/body/app-root/app-core/app-pack-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[10]/img");
				
				By enableOptionLocator1boi = By.xpath(
						"/html/body/app-root/app-core/app-pack-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[10]/div/ul/li[2]/img");
				By disableOptionLocator1boi = By.xpath(
						"/html/body/app-root/app-core/app-pack-list/div/div/div[4]/div[1]/table[1]/tbody/tr[1]/td[10]/div/ul/li[2]/img");
				test1.pass("Added Action Functionality to Enable or Disable The Admin  ");
				boolean isEnabled1boi = true; // Set the initial state

				// Perform the toggle operation in a loop
				for (int i = 0; i < 5; i++) { // Repeat the toggle operation 5 times (adjust the loop count as needed)
					// Click the toggle element
					WebDriverWait wait10000boi = new WebDriverWait(driver, duration);
					wait10000boi.until(ExpectedConditions.elementToBeClickable(toggleElementLocator1boi)).click();

					// Wait for the options to appear
					WebDriverWait waitOptions148boi = new WebDriverWait(driver, duration);
					waitOptions148boi.until(ExpectedConditions.visibilityOfElementLocated(enableOptionLocator1boi));

					// Check the current state and perform the corresponding action
					if (isEnabled1boi) {
						// If it's enabled, click the disable option
						WebDriverWait waitDisable1boi = new WebDriverWait(driver, duration);
						waitDisable1boi.until(ExpectedConditions.elementToBeClickable(disableOptionLocator1boi)).click();
					} else {
						// If it's disabled, click the enable option
						WebDriverWait waitEnable1boi = new WebDriverWait(driver, duration);
						waitEnable1boi.until(ExpectedConditions.elementToBeClickable(enableOptionLocator1boi)).click();
					}

					// Update the state
					isEnabled1boi = !isEnabled1boi;

					// Add waiting time between each toggle operation
					try {
						Thread.sleep(1000); // Wait for 2 seconds (adjust the duration as needed)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				
				
				
				
				
//		     
//		        
//			
//		        
//		        
			test1.pass("Starting To Test CONTENT ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/channels");
			WebDriverWait wait14341 = new WebDriverWait(driver, duration);
			wait14341.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/channels"));
			test1.pass("Navigating to Admin Page");		
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/a[3]/button"))
					.click();
			
			

			
			
	        
	        
			
//			//Adding new channels
//			
////			
//			driver.findElement(
//					By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/a[4]/button"))
//					.click();
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelName\"]")).sendKeys("suraj");
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelNumber\"]")).sendKeys("12");
//			driver.findElement(By.cssSelector("textarea[formcontrolname=\"channelShortDescription\"]")).sendKeys("this channel is for testing please dont delete it");
//
//			driver.findElement(By.cssSelector("textarea[formcontrolname=\"channelLongDescription\"]")).sendKeys("Hello I am Testsing");
//			 // Assuming you have the absolute path of the image file
//          String imagePath = "C:\\Users\\Admin\\Pictures\\Screenshots\\testingnotification.png";
//
//          // Find the file input element using the XPath
//          WebElement fileInput = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-add/div/div/div/div/form/div/div[2]/div[5]/input"));
//
//          // Use the sendKeys() method to set the file path of the image
//          fileInput.sendKeys(imagePath);
//
//          Thread.sleep(2000);
//			
//          
//          String imagePath99 = "C:\\Users\\Admin\\Pictures\\Screenshots\\testingnotification.png";
//
//          // Find the file input element using the XPath
//          WebElement fileInput99 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-add/div/div/div/div/form/div/div[2]/div[6]/input"));
//
//          // Use the sendKeys() method to set the file path of the image
//          fileInput99.sendKeys(imagePath99);
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelPlayUrl\"]")).sendKeys("test");
//			
//			WebElement inputElement = driver.findElement(By.cssSelector("input.ng-valid"));
//			String dataToInput = "Your data goes here";
//			inputElement.sendKeys(dataToInput);
//			inputElement.submit();
//
//		        WebElement inputElementgo = driver.findElement(By.cssSelector("input.ng-pristine.ng-valid.ng-touched"));
//
//		        // Input data into the input element
//		        inputElementgo.sendKeys("www.dj.com");
//			
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelName\"]")).sendKeys("test");
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelName\"]")).sendKeys("test");
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelLanguage\"]")).sendKeys("Hindi");
//			driver.findElement(By.cssSelector("input[formcontrolname=\"channelGenre\"]")).sendKeys("Action");
//
//			 // Find the dropdown element
//	        WebElement dropdownElementhh = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-add/div/div/div/div/form/div/div[2]/div[12]/ng-multiselect-dropdown/div/div[1]/span"));
//
//	        // Create a Select object for the dropdown element
//	        Select select125 = new Select(dropdownElementhh);
//
//	        // Select the option by visible text
//	        select125.selectByVisibleText("News");
//          
//	        driver.findElement(
//					By.xpath("/html/body/app-root/app-core/app-channel-add/div/div/div/div/form/div/div[3]/button[2]"))
//					.click();
	        
          
			

			
			
			
					
			//search Functionality
			
			String searchKeywordjanu113 = "9XM";
			WebElement searchInputjanu113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-channel-list > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputjanu113.sendKeys(searchKeywordjanu113);
			
			searchInputjanu113.sendKeys(Keys.ENTER);
			searchInputjanu113.clear();
			
			Actions actionsjanu113 = new Actions(driver);
			actionsjanu113.sendKeys(searchInputjanu113, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/channels");
			WebDriverWait waitjanu130 = new WebDriverWait(driver, duration);
			waitjanu130.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/channels"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}

			 WebElement nextPageButton2 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
		        nextPageButton2.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton2 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[4]/div[2]/div[2]/button[2]"));
		        previousPageButton2.click();
			
			
			
//			test1.pass("Starting To Test CONTENT ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/categories");
			WebDriverWait wait143411 = new WebDriverWait(driver, duration);
			wait143411.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/categories"));
			test1.pass("Navigating to Admin Page");	
			
			
			
			
			//Adding new categories
			
			test1.pass("Starting To Test CONTENT ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-category/div/div/div[2]/a/button"))
					.click();
			
			driver.findElement(By.cssSelector("input[formcontrolname=\"categoryName\"]")).sendKeys("Action");	
			
			driver.findElement(By.cssSelector("textarea[formcontrolname=\"categoryDescription\"]")).sendKeys("Action  fdddd dddd");							
			test1.pass("Starting To Test CONTENT ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-create-category/div/div/div/div/form/div/div[3]/button[2]"))
					.click();
			
		
			
			//searching categories
			
			String searchKeywordjanu10 = "Devotional";
			WebElement searchInputjanu10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-list-category > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputjanu10.sendKeys(searchKeywordjanu10);
			
			searchInputjanu10.sendKeys(Keys.ENTER);
			searchInputjanu10.clear();
			
			Actions actionsjanu10 = new Actions(driver);
			actionsjanu10.sendKeys(searchInputjanu10, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/categories");
			WebDriverWait waitjanu121 = new WebDriverWait(driver, duration);
			waitjanu121.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/categories"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			WebElement nextPageButton3 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-category/div/div/div[4]/div[2]/div[2]/button[3]/img"));
	        nextPageButton3.click();
	       
	        
	        try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
	        
	        WebElement previousPageButton3 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-category/div/div/div[4]/div[2]/div[2]/button[2]/img"));
	        previousPageButton3.click();
		
			

//**********************************************************COUPON MODULE************************************************************************
			
									
			test1.pass("Starting To Test COUPON ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"))
					.click();
			
			driver.navigate().to("http://143.110.248.51:5500/coupon-management/list-coupon");
			WebDriverWait wait1446 = new WebDriverWait(driver, duration);
			wait1446.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupon-management/list-coupon"));
			test1.pass("Navigating to COUPON Page");
			
			test1.pass("Downloading Sample for Coupon Providers ");
			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-coupon-based-providers/div/div/div/div[1]/div/a[1]/button"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-coupon-based-providers/div/div/div/div[1]/div/a[2]/button"))
					.click();
			test1.pass("Downloading Report for Coupon Providers ");
		
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-coupon-based-providers/div/div/div/div[3]/div[1]/table[1]/tbody/tr[1]/td[9]/button"))
					.click();
			test1.pass("Downloading Report for Coupon Providers ");
			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-create-coupon-based-providers/div/div/div/div/form/div/div[3]/button[2]"))
					.click();
			
			
			
			test1.pass("Downloading Report for Coupon Providers ");
			
			
			
			

			test1.pass("Starting To Test COUPON ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/coupon-management/user-history");
			WebDriverWait wait1496 = new WebDriverWait(driver, duration);
			wait1496.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupon-management/user-history"));
			test1.pass("Navigating to Admin Page");	
			
				driver.findElement(
			By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[2]/a/button"))
			.click();
				// Adding Filter
				
				
				try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
				driver.findElement(By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[1]/button")).click();

				WebDriverWait wait14463 = new WebDriverWait(driver, duration);
				By dropdownLocator144434 = By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[1]/div/div/select[1]");
				By optionLocator144456 = By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[1]/div/div/select[2]");
				By optionLocator144454 = By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[1]/div/div/app-date-picker/input");
				
				WebElement dropdownElement14456 = wait14463.until(ExpectedConditions.elementToBeClickable(dropdownLocator144434));
				dropdownElement14456.click();

				WebElement optionElement14454 = wait14463.until(ExpectedConditions.elementToBeClickable(optionLocator144456));
				optionElement14454.click();
				WebElement optionElement144543 = wait14463.until(ExpectedConditions.elementToBeClickable(optionLocator144454));
				optionElement144543.click();
				
				
				//Clear All Filters
				driver.findElement(By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[2]/div[1]/span")).click();

				

				test1.pass("Going To Filter page and selecting All as Status");

				driver.navigate().to("http://143.110.248.51:5500/coupon-management/user-history");
				WebDriverWait wait1438 = new WebDriverWait(driver, duration);
				wait1438.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupon-management/user-history"));
				test1.pass("Navigating to Admin Page");

				
				/**
				 * 
				 * @author SurajDevRajak
				 *
				 */ // Adding Search Functionality

				
				
				String searchKeyword1403 = "9876512333";
				WebElement searchInput14333 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
						"body > app-root > app-core > app-subscriber-history > div > div > div.filters__search > div.search__table > input")));
				test1.pass("Clicking To Search button and searching For Mobile no or any type As I passed as String");
				searchInput14333.sendKeys(searchKeyword1403);
				try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
				searchInput14333.sendKeys(Keys.ENTER);
				searchInput14333.clear();
				try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
				Actions actions1490 = new Actions(driver);
				actions1490.sendKeys(searchInput14333, Keys.ENTER).perform();
				test1.pass("After searching, the search field is cleared");
				driver.navigate().to("http://143.110.248.51:5500/coupon-management/user-history");
				WebDriverWait wait14388 = new WebDriverWait(driver, duration);
				wait14388.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupon-management/user-history"));
				test1.pass("Navigating to Admin Page");
				try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}

				
				WebElement nextPageButton4 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[4]/div[2]/div[2]/button[3]/img"));
		        nextPageButton4.click();
		       
		        
		        try {
				    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		        
		        WebElement previousPageButton4 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-subscriber-history/div/div/div[4]/div[2]/div[2]/button[2]/img"));
		        previousPageButton4.click();
				
		try {
		    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
			
			test1.pass("Starting To Test COUPON ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/coupon-management/reissue");
			WebDriverWait wait1096 = new WebDriverWait(driver, duration);
			wait1096.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupon-management/reissue"));
			test1.pass("Navigating to Admin Page");	
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-reissue-coupons/div/div/div/div[3]/div/table/tbody/tr[2]/td[3]/button"))
					.click();
			test1.pass(" Coupon reissue ");
			
		
			
			
			test1.pass("Starting To Test Franchise  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[5]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding");
			
			
			
			
			
			
			
			driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding/create");
			WebDriverWait wait10966os = new WebDriverWait(driver, duration);
			wait10966os.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-onboarding/create"));
			

	        // Find the input element using the CSS selector
	        WebElement inputElement = driver.findElement(By.cssSelector("input[formcontrolname=\"franchiseId\"]"));

	        // Input the uniqueId into the input element
	        inputElement.sendKeys(uniqueIds);
	        
			driver.findElement(By.cssSelector("input[formcontrolname=\"name\"]")).sendKeys("testing");
			driver.findElement(By.cssSelector("input[formcontrolname=\"phone\"]")).sendKeys("9110133887");
			driver.findElement(By.cssSelector("input[formcontrolname=\"email\"]")).sendKeys("testing@gmail.com");
			driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys("testing");
			driver.findElement(By.cssSelector("input[formcontrolname=\"confirmPassword\"]")).sendKeys("testing");
			driver.findElement(By.cssSelector("input[formcontrolname=\"location\"]")).sendKeys("peenya");
			  // Find the dropdown element
	        WebElement dropdownElementde = driver.findElement(By.cssSelector("select[formcontrolname=\"accountManagerId\"]"));

	        // Create a Select object from the dropdown element
	        Select dropdownSelectddk = new Select(dropdownElementde);

	        // Select "Ajay" from the dropdown
	        dropdownSelectddk.selectByVisibleText("Ajay");
			
	      
			driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding");
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
//need bulk upload
			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[2]/a[3]/button"))
					.click();
			
			
			
			
			String searchKeyword140398 = "6361106628";
			WebElement searchInput1433398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-franchise-list > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For Mobile no or any type As I passed as String");
			searchInput1433398.sendKeys(searchKeyword140398);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInput1433398.sendKeys(Keys.ENTER);
			searchInput1433398.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions149098 = new Actions(driver);
			actions149098.sendKeys(searchInput1433398, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding");
			WebDriverWait wait1438898 = new WebDriverWait(driver, duration);
			wait1438898.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-onboarding"));
			test1.pass("Navigating to Admin Page");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			// Adding Filter
			
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[1]/button"))
					.click();
			
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			WebDriverWait wait4u4 = new WebDriverWait(driver, duration);
			By dropdownLocator4u4 = By
					.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[1]/div/div/select");
			By optionLocator4u4 = By
					.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[1]/div/div/select");
			wait4u4.until(ExpectedConditions.elementToBeClickable(dropdownLocator4u4)).click();
			wait4u4.until(ExpectedConditions.elementToBeClickable(optionLocator4u4)).click();
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[2]/div[1]/div/div/div/button[2]"))
					.click();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Going To Filter page and selecting to All as Status");
			
			
			
			
//						
			
						WebElement nextPageButtonhg = driver.findElement(By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[2]/div[2]/button[3]/img"));
				        nextPageButtonhg.click();
//				       
//				        
				        try {
						    Thread.sleep(1000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}

						
				        WebElement previousPageButtonhg = driver.findElement(By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[2]/div[2]/button[2]/img"));
				        previousPageButtonhg.click();
						
						
				        try {
						    Thread.sleep(1000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
				        
				        
				        
				      //Edit  
				        
				        driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding/Akshit");
						WebDriverWait wait143889S = new WebDriverWait(driver, duration);
						
						wait143889S.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-onboarding/Akshit"));
						
						
						 driver.findElement(By.xpath("/html/body/app-root/app-core/app-add-franchise/div/div/div/div/form/div/div[3]/button"))
							.click();	
						  try {
							    Thread.sleep(1000); // 60 seconds = 60,000 milliseconds
							} catch (InterruptedException e) {
							    e.printStackTrace();
							}
						 
						 
						//Action 
						
 
				        
				      //Enable Disable pacakges        
//				        
				        By toggleElementLocator1bgan = By.xpath(
								"/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[1]/table[1]/tbody/tr[2]/td[9]/img");
						
						By enableOptionLocator1bgan = By.xpath(
								"/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[1]/table[1]/tbody/tr[2]/td[9]/div/ul/li[2]");
						By disableOptionLocator1bgan = By.xpath(
								"/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[1]/table[1]/tbody/tr[2]/td[9]/div/ul/li[2]");
						test1.pass("Added Action Functionality to Enable or Disable The Admin  ");
						boolean isEnabled1bgan = true; // Set the initial state
		
						// Perform the toggle operation in a loop
						for (int i = 0; i < 5; i++) { // Repeat the toggle operation 5 times (adjust the loop count as needed)
							// Click the toggle element
							WebDriverWait wait10000bgan = new WebDriverWait(driver, duration);
							wait10000bgan.until(ExpectedConditions.elementToBeClickable(toggleElementLocator1bgan)).click();
		
							// Wait for the options to appear
							WebDriverWait waitOptions148bgan = new WebDriverWait(driver, duration);
							waitOptions148bgan.until(ExpectedConditions.visibilityOfElementLocated(enableOptionLocator1bgan));
		
							// Check the current state and perform the corresponding action
							if (isEnabled1bgan) {
								// If it's enabled, click the disable option
								WebDriverWait waitDisable1bgan = new WebDriverWait(driver, duration);
								waitDisable1bgan.until(ExpectedConditions.elementToBeClickable(disableOptionLocator1bgan)).click();
							} else {
								// If it's disabled, click the enable option
								WebDriverWait waitEnable1bgan = new WebDriverWait(driver, duration);
								waitEnable1bgan.until(ExpectedConditions.elementToBeClickable(enableOptionLocator1bgan)).click();
							}
		
							// Update the state
							isEnabled1bgan = !isEnabled1bgan;
		
							// Add waiting time between each toggle operation
							try {
								Thread.sleep(1000); // Wait for 2 seconds (adjust the duration as needed)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
				        
				   //DELETE FRANCHISE ONBOARDING
						
						
//						 
//			            driver.findElement(
//								By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[1]/table[1]/tbody/tr[2]/td[9]/img"))
//								.click();
//			            WebElement deleteElement23O = driver.findElement(By.xpath("/html/body/app-root/app-core/app-franchise-list/div/div/div[4]/div[1]/table[1]/tbody/tr[2]/td[9]/div/ul/li[3]/img"));
//			            deleteElement23O.click();			
//						
//			         // Wait for the alert to be present
//			          WebDriverWait waitrhsgs63 = new WebDriverWait(driver, duration);
//			          waitrhsgs63.until(ExpectedConditions.alertIsPresent());
//			  
//			          // Switch to the alert
//			          Alert alert63 = driver.switchTo().alert();
//			  
//			          // Accept the alert (clicking the OK button)
//			          alert63.accept();
						
			          
			          
			   //Franchise login   
			          driver.navigate().to("http://143.110.248.51:4500/dashboard/dashboard/999Test/7532dfc6-7d88-4f1a-8737-0eca0b71622e/onnet");
						WebDriverWait wait143889SM = new WebDriverWait(driver, duration);
						
						wait143889SM.until(ExpectedConditions.urlToBe("http://143.110.248.51:4500/dashboard/dashboard/999Test/7532dfc6-7d88-4f1a-8737-0eca0b71622e/onnet"));
						try {
						    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
						} catch (InterruptedException e) {
						    e.printStackTrace();
						}
			          
			          driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding");
						WebDriverWait wait143889SD = new WebDriverWait(driver, duration);
						
						wait143889SD.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-onboarding"));
			          
						 driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding/redeem/a5");
							WebDriverWait wait143889SDM = new WebDriverWait(driver, duration);
							
							wait143889SDM.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-onboarding/redeem/a5"));
						
							
							driver.navigate().back();
							
							driver.navigate().to("http://143.110.248.51:5500/franchise-onboarding/recharge/9999999999");
							WebDriverWait wait143889SDQ = new WebDriverWait(driver, duration);
							driver.navigate().back();


			
			test1.pass("Starting To Test Franchise  ");
			
			driver.navigate().to("http://143.110.248.51:5500/franchise-mapping");
			WebDriverWait wait10966o = new WebDriverWait(driver, duration);
			wait10966o.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-mapping"));
			test1.pass("Navigating to Admin Page");	
			
			
			
			
			
			
			
				
			
			test1.pass("Starting To Test Franchise  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[5]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/franchise-menus");
			WebDriverWait wait109660 = new WebDriverWait(driver, duration);
			wait109660.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/franchise-menus"));
			test1.pass("Navigating to Admin Page");	
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-franchise-menu/div/div/div[2]/div/table/tbody/tr[2]/td[3]/button"))
					.click();
			
			
			
			
			
			// Wait for the alert to be present
			WebDriverWait wait567 = new WebDriverWait(driver, duration);
			wait567.until(ExpectedConditions.alertIsPresent());
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			// Switch to the alert
			Alert alert123 = driver.switchTo().alert();

			// Get the alert text (optional)
			String alertText12 = alert123.getText();
			System.out.println("Alert Text: " + alertText12);

			// Accept the alert (click OK)
			alert123.accept();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Filling All The deatils To create New Subscribers ");
			test1.pass("Clicking Save Button to save all the Details");
			test1.pass("New Subscriber Created");
			
			
			
			
			test1.pass("Starting To Test Franchise  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/payment/pending-requests");
			WebDriverWait wait109664 = new WebDriverWait(driver, duration);
			wait109664.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/pending-requests"));
			test1.pass("Navigating to Admin Page");	
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[4]/div[1]/table/tbody/tr[2]/td[7]/img")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[4]/div[1]/table/tbody/tr[2]/td[7]/div/ul/a[1]/li")).click();
//			driver.navigate().back();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/payment/pending-requests");
			WebDriverWait wait1664 = new WebDriverWait(driver, duration);
			wait1664.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/pending-requests"));
			test1.pass(" pending-requests ");
			
			//Adding Search Functionality in pending requests
			
			
			String searchKeyword140334 = "Franchise002";
			WebElement searchInput1333 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-pending-requests > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInput1333.sendKeys(searchKeyword140334);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInput1333.sendKeys(Keys.ENTER);
			searchInput1333.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions14908 = new Actions(driver);
			actions14908.sendKeys(searchInput1333, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/payment/pending-requests");
			WebDriverWait wait143881 = new WebDriverWait(driver, duration);
			wait143881.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/pending-requests"));
			test1.pass("Navigating to Admin Page");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}

			// Adding Filter
			
			

			driver.findElement(By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[2]/div/button")).click();

			WebDriverWait wait1448787 = new WebDriverWait(driver, duration);
			By dropdownLocator14487871 = By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[2]/div/div/div/select");
			By optionLocator1448787 = By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[2]/div/div/div/app-date-picker/input");
			
			WebElement dropdownElement14487871 = wait1448787.until(ExpectedConditions.elementToBeClickable(dropdownLocator14487871));
			dropdownElement14487871.click();

			WebElement optionElement14441 = wait1448787.until(ExpectedConditions.elementToBeClickable(optionLocator1448787));
			optionElement14441.click();
			
			
			//Clear All Filters

			driver.findElement(By.xpath("/html/body/app-root/app-core/app-pending-requests/div/div/div[2]/div/span")).click();


			test1.pass("Going To Filter page and selecting All as Status");

			driver.navigate().to("http://143.110.248.51:5500/payment/pending-requests");
			WebDriverWait wait143833 = new WebDriverWait(driver, duration);
			wait143833.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/pending-requests"));
			test1.pass("Navigating to Admin Page");

			
			
			
			//Starting Wallet setting
			
			test1.pass("Starting To Test Franchise  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/payment/wallet-settings");
			WebDriverWait wait1096641 = new WebDriverWait(driver, duration);
			wait1096641.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/wallet-settings"));
			test1.pass("Navigating to Admin Page");	
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-wallet-settings/div/div/div/form/div[2]/button[2]")).click();
			
			// Wait for the alert to be present
			WebDriverWait wait5679 = new WebDriverWait(driver, duration);
			wait5679.until(ExpectedConditions.alertIsPresent());
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			// Switch to the alert
			Alert alert1239 = driver.switchTo().alert();

			// Get the alert text (optional)
			String alertText120 = alert1239.getText();
			System.out.println("Alert Text: " + alertText120);

			// Accept the alert (click OK)
			alert1239.accept();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			test1.pass("Filling All The deatils To create New Subscribers ");
			test1.pass("Clicking Save Button to save all the Details");
			test1.pass("New Subscriber Created");
//			driver.findElement(
//					By.xpath(""))
//					.click();
			
			test1.pass("Starting To Test Franchise  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/payment/franchise-balance");
			WebDriverWait wait10966410 = new WebDriverWait(driver, duration);
			wait10966410.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/franchise-balance"));
			test1.pass("Navigating to Admin Page");		
			
			
			
			
			
			
			test1.pass("Starting To Test Payment Logs  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"))
					.click();
			driver.navigate().to("http://143.110.248.51:5500/payment/payment-logs");
			WebDriverWait wait109664100 = new WebDriverWait(driver, duration);
			wait109664100.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/payment-logs"));
			test1.pass("Navigating to Payment Logs Page");	
			
		//Adding Search Functionality in pending requests
			
			
			String searchKeyword14033411 = "prasad";
			WebElement searchInput133311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-payment-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInput133311.sendKeys(searchKeyword14033411);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInput133311.sendKeys(Keys.ENTER);
			searchInput133311.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actions149080 = new Actions(driver);
			actions149080.sendKeys(searchInput133311, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/payment/payment-logs");
			WebDriverWait wait1438810 = new WebDriverWait(driver, duration);
			wait1438810.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/payment-logs"));
			test1.pass("Navigating to Admin Page");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//			
//			// Adding Filter
//			
//			
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-payment-logs/div/div/div[2]/div/div/button")).click();

			WebDriverWait waitj = new WebDriverWait(driver, duration);
			By dropdownLocatorj144 = By.xpath("/html/body/app-root/app-core/app-payment-logs/div/div/div[2]/div/div/div/div/select[1]");
			By optionLocatorj144 = By.xpath("/html/body/app-root/app-core/app-payment-logs/div/div/div[2]/div/div/div/div/select[2]");
			By optionLocatorj1444 = By.xpath("/html/body/app-root/app-core/app-payment-logs/div/div/div[2]/div/div/div/div/app-date-picker/input");
			
			WebElement dropdownElementj144 = waitj.until(ExpectedConditions.elementToBeClickable(dropdownLocatorj144));
			dropdownElementj144.click();

			WebElement optionElementj0144 = waitj.until(ExpectedConditions.elementToBeClickable(optionLocatorj144));
			optionElementj0144.click();
			WebElement optionElementj1444 = waitj.until(ExpectedConditions.elementToBeClickable(optionLocatorj1444));
			optionElementj1444.click();
			
			
			//Clear All Filters
			driver.findElement(By.xpath("/html/body/app-root/app-core/app-payment-logs/div/div/div[2]/div/div/span")).click();

			

			test1.pass("Going To Filter page and selecting All as Status");

			driver.navigate().to("http://143.110.248.51:5500/payment/payment-logs");
			WebDriverWait wait1j = new WebDriverWait(driver, duration);
			wait1j.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/payment/payment-logs"));
			test1.pass("Navigating to Admin Page");
						
			
//			***LOGS PENDING CODE
			
			test1.pass("Starting To Test Package Activity Logs  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/activity-logs");
			WebDriverWait wait1jd = new WebDriverWait(driver, duration);
			wait1jd.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/activity-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-activity-logs-view/div/div/div/div/div/div/div[2]/div[1]/a"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-package-creation-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordk = "TestOnnet";
			WebElement searchInputk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-package-creation-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputk.sendKeys(searchKeywordk);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputk.sendKeys(Keys.ENTER);
			searchInputk.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionsk80 = new Actions(driver);
			actionsk80.sendKeys(searchInputk, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/activity-logs/package-creation");
			WebDriverWait waitmk = new WebDriverWait(driver, duration);
			waitmk.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/activity-logs/package-creation"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			//Provider Onboarding Logs
			
			
			
			driver.navigate().to("http://143.110.248.51:5500/activity-logs");
			WebDriverWait wait12jd = new WebDriverWait(driver, duration);
			wait12jd.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/activity-logs"));
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-activity-logs-view/div/div/div/div/div/div/div[2]/div[2]/a"))
					.click();
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-provider-onboarding-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordkd = "OnnetTest";
			WebElement searchInputkd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-provider-onboarding-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkd.sendKeys(searchKeywordkd);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkd.sendKeys(Keys.ENTER);
			searchInputkd.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskd80 = new Actions(driver);
			actionskd80.sendKeys(searchInputkd, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/activity-logs/provider-onboarding");
			WebDriverWait waitmkd = new WebDriverWait(driver, duration);
			waitmkd.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/activity-logs/provider-onboarding"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
	//Starting Coupon Logs 
			
			test1.pass("Starting To Test Package Coupon Logs  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs");
			WebDriverWait wait1jde = new WebDriverWait(driver, duration);
			wait1jde.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupons-logs-view/div/div/div/div/div/div/div[2]/div[1]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupon-issue/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordkdhj = "Hotstar";
			WebElement searchInputkdhj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-coupon-issue > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdhj.sendKeys(searchKeywordkdhj);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdhj.sendKeys(Keys.ENTER);
			searchInputkdhj.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskd800 = new Actions(driver);
			actionskd800.sendKeys(searchInputkdhj, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs/coupons-issue");
			WebDriverWait waitmkdhj = new WebDriverWait(driver, duration);
			waitmkdhj.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs/coupons-issue"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			//Coupon Reissue  Logs
			
			
			test1.pass("Starting To Test Package Coupon Logs  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs");
			WebDriverWait wait1jdev = new WebDriverWait(driver, duration);
			wait1jdev.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupons-logs-view/div/div/div/div/div/div/div[2]/div[2]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupon-reissue/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordkdev = "8132453674";
			WebElement searchInputkdev = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-coupon-reissue > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdev.sendKeys(searchKeywordkdev);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdev.sendKeys(Keys.ENTER);
			searchInputkdev.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdev800 = new Actions(driver);
			actionskdev800.sendKeys(searchInputkdev, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs/coupons-reissue");
			WebDriverWait waitmkdev = new WebDriverWait(driver, duration);
			waitmkdev.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs/coupons-reissue"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			
			
//Coupon Upload Logs
			
			
			test1.pass("Starting To Test Upload Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs");
			WebDriverWait wait1jdevi = new WebDriverWait(driver, duration);
			wait1jdevi.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupons-logs-view/div/div/div/div/div/div/div[2]/div[3]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupon-upload/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordkdevi = "Shemaroo Me";
			WebElement searchInputkdevi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-coupon-upload > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevi.sendKeys(searchKeywordkdevi);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevi.sendKeys(Keys.ENTER);
			searchInputkdevi.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdevi800 = new Actions(driver);
			actionskdevi800.sendKeys(searchInputkdevi, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs/coupons-upload");
			WebDriverWait waitmkdevi = new WebDriverWait(driver, duration);
			waitmkdevi.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs/coupons-upload"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
//Coupon coupons-status Logs
			
			
			test1.pass("Starting To Test Upload Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs");
			WebDriverWait wait1jdevis = new WebDriverWait(driver, duration);
			wait1jdevis.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupons-logs-view/div/div/div/div/div/div/div[2]/div[4]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-coupon-status/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordkdevil = "Epicon";
			WebElement searchInputkdevil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-coupon-status > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevil.sendKeys(searchKeywordkdevil);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevil.sendKeys(Keys.ENTER);
			searchInputkdevil.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdevis800 = new Actions(driver);
			actionskdevis800.sendKeys(searchInputkdevil, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/coupons-logs/coupons-status");
			WebDriverWait waitmkdevis1 = new WebDriverWait(driver, duration);
			waitmkdevis1.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/coupons-logs/coupons-status"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			
			//Subscriber  prefernce-generation  Logs
			
			test1.pass("Starting To Test Upload Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdevis1 = new WebDriverWait(driver, duration);
			wait1jdevis1.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[1]/a"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-preference-generation-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordopi = "CHETHAN";
			WebElement searchInputkdevil0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-preference-generation-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevil0.sendKeys(searchKeywordopi);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevil0.sendKeys(Keys.ENTER);
			searchInputkdevil0.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss800 = new Actions(driver);
			actionskdeviss800.sendKeys(searchInputkdevil0, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/prefernce-generation");
			WebDriverWait waitmkdevis11 = new WebDriverWait(driver, duration);
			waitmkdevis11.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/prefernce-generation"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			//Subscriber  Profile  Logs
			
			test1.pass("Starting To Test Profile Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdevis11 = new WebDriverWait(driver, duration);
			wait1jdevis11.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[2]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-profile-creation-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordoki = "chethan";
			WebElement searchInputkdevil01 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-profile-creation-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevil01.sendKeys(searchKeywordoki);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevil01.sendKeys(Keys.ENTER);
			searchInputkdevil01.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss00 = new Actions(driver);
			actionskdeviss00.sendKeys(searchInputkdevil01, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/profile-creation");
			WebDriverWait waitmkdevis111 = new WebDriverWait(driver, duration);
			waitmkdevis111.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/profile-creation"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//			
//			
//			
////Subscriber  Subscriber Onboarding Logs
//			
			test1.pass("Starting To Test Subscriber Onboarding Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdevis111 = new WebDriverWait(driver, duration);
			wait1jdevis111.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[3]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-onboarding-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokid = "Nagaraju";
			WebElement searchInputkdevil011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-subscriber-onboarding-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevil011.sendKeys(searchKeywordokid);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevil011.sendKeys(Keys.ENTER);
			searchInputkdevil011.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss001 = new Actions(driver);
			actionskdeviss001.sendKeys(searchInputkdevil011, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/subscriber-onboarding");
			WebDriverWait waitmkdevis1111 = new WebDriverWait(driver, duration);
			waitmkdevis1111.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/subscriber-onboarding"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			
//Subscriber  Subscription By Package ID Logs
			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdevis1111 = new WebDriverWait(driver, duration);
			wait1jdevis1111.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[4]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscription-package-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokidi = "Nagaraju";
			WebElement searchInputkdevin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-subscription-package-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevin.sendKeys(searchKeywordokidi);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevin.sendKeys(Keys.ENTER);
			searchInputkdevin.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss0012 = new Actions(driver);
			actionskdeviss0012.sendKeys(searchInputkdevin, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/subscription-package");
			WebDriverWait waitmkdevis11110 = new WebDriverWait(driver, duration);
			waitmkdevis11110.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/subscription-package"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//			
//			
//			
////Subscriber  Subscription By Provider ID Logs
//			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdeviskl = new WebDriverWait(driver, duration);
			wait1jdeviskl.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[5]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscription-provider-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokidil = "vijaya";
			WebElement searchInputkdevinf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-subscription-provider-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevinf.sendKeys(searchKeywordokidil);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevinf.sendKeys(Keys.ENTER);
			searchInputkdevinf.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss00121 = new Actions(driver);
			actionskdeviss00121.sendKeys(searchInputkdevinf, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/subscription-provider");
			WebDriverWait waitmkdevils11110 = new WebDriverWait(driver, duration);
			waitmkdevils11110.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/subscription-provider"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//				
//			
//	
//			
//			
////Subscriber    Watch Logs
//			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdeviskls = new WebDriverWait(driver, duration);
			wait1jdeviskls.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[6]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-watch-log/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokidil311 = "Chethan";
			WebElement searchInputkdevinf0sdf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-watch-log > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevinf0sdf.sendKeys(searchKeywordokidil311);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevinf0sdf.sendKeys(Keys.ENTER);
			searchInputkdevinf0sdf.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss01201fg = new Actions(driver);
			actionskdeviss01201fg.sendKeys(searchInputkdevinf0sdf, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/watch-log");
			WebDriverWait waitmkdevils1111ddf = new WebDriverWait(driver, duration);
			waitmkdevils1111ddf.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/watch-log"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
//Subscriber    Watch Logs
			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs");
			WebDriverWait wait1jdevisklsfdfdd = new WebDriverWait(driver, duration);
			wait1jdevisklsfdfdd.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscriber-logs-view/div/div/div/div/div/div/div[2]/div[7]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-bulk-uploadlogs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokidil31144 = "Ajay";
			WebElement searchInputkdevinf0sdfgg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-bulk-uploadlogs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevinf0sdfgg.sendKeys(searchKeywordokidil31144);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevinf0sdfgg.sendKeys(Keys.ENTER);
			searchInputkdevinf0sdfgg.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss01201fgff = new Actions(driver);
			actionskdeviss01201fgff.sendKeys(searchInputkdevinf0sdfgg, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/subscriber-logs/subscriber-bulk-upload-logs");
			WebDriverWait waitmkdevils1111ddfff = new WebDriverWait(driver, duration);
			waitmkdevils1111ddfff.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/subscriber-logs/subscriber-bulk-upload-logs"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			

			
			
			
//Subscriber    wallet-logs
			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs");
			WebDriverWait wait1jdevisklsfdfdid = new WebDriverWait(driver, duration);
			wait1jdevisklsfdfdid.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-wallet-logs-view/div/div/div/div/div/div/div[2]/div[1]/a/div"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-wallet-history/div/div/div[2]/div[2]/a[1]/button"))
					.click();
			
			
//Adding Search Functionality in pending requests
			
			
			String searchKeywordokidil3dfd = "PioneerOnline";
			WebElement searchInputkdevinf0sdfging = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-wallet-history > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevinf0sdfging.sendKeys(searchKeywordokidil3dfd);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevinf0sdfging.sendKeys(Keys.ENTER);
			searchInputkdevinf0sdfging.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdeviss01201fgffing = new Actions(driver);
			actionskdeviss01201fgffing.sendKeys(searchInputkdevinf0sdfging, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs/wallet-history");
			WebDriverWait waitmkdevils1111ddisf = new WebDriverWait(driver, duration);
			waitmkdevils1111ddisf.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs/wallet-history"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
//Subscriber    Wallet Recharge logs
			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs");
			WebDriverWait wait1jdevisklsfdfdids = new WebDriverWait(driver, duration);
			wait1jdevisklsfdfdids.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-wallet-logs-view/div/div/div/div/div/div/div[2]/div[2]/a"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-wallet-recharge/div/div/div[2]/div[2]/a[1]/button"))
					.click();
//			
//			
////Adding Search Functionality in pending requests
//			
//			
			String searchKeywordjan = "prasad";
			WebElement searchInputkdevilal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-wallet-recharge > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputkdevilal.sendKeys(searchKeywordjan);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputkdevilal.sendKeys(Keys.ENTER);
			searchInputkdevilal.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionskdevilll = new Actions(driver);
			actionskdevilll.sendKeys(searchInputkdevilal, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs/wallet-recharge");
			WebDriverWait waitmkdevilal = new WebDriverWait(driver, duration);
			waitmkdevilal.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs/wallet-recharge"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
		
			
			
//Subscriber   Package Subscription logs
			
			test1.pass("Starting To Test Subscription By Package ID Logs   ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[7]/a"))
					.click();
			test1.pass("Navigating to Package Activity Logs  Page");	
			
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs");
			WebDriverWait waitjanu = new WebDriverWait(driver, duration);
			waitjanu.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs"));
			test1.pass("Navigating to  Package Activity Logs ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-wallet-logs-view/div/div/div/div/div/div/div[2]/div[3]"))
					.click();
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-subscription-logs/div/div/div[2]/div[2]/a[1]/button"))
					.click();
//			
//			
////Adding Search Functionality in pending requests
//			
//			
			String searchKeywordjanu = "Manasa";
			WebElement searchInputjanu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-subscription-logs > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputjanu.sendKeys(searchKeywordjanu);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputjanu.sendKeys(Keys.ENTER);
			searchInputjanu.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionsjanu = new Actions(driver);
			actionsjanu.sendKeys(searchInputjanu, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/wallet-logs/wallet-subscription");
			WebDriverWait waitjanu1 = new WebDriverWait(driver, duration);
			waitjanu1.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/wallet-logs/wallet-subscription"));
			test1.pass("Navigating to package-creation");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			
			
			
			
			
			
			
		
			
			
			
			
			
			//Starting Notifications
			
			test1.pass("Starting To Test Notifications  ");
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[8]/a"))
					.click();
			test1.pass("Navigating to Payment Logs Page");	
			
			
			//Creating new Notification
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-mail/div/div/div[2]/a/button/img"))
					.click();
			
			 // Find the dropdown element
	        WebElement dropdownElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mail/div/div/div/div/form/div/div[2]/div[1]/select"));

	        // Create a Select object for the dropdown element
	        Select select = new Select(dropdownElement);

	        // Select the option by visible text
	        select.selectByVisibleText("Mobile number");
			driver.findElement(By.cssSelector("input[formcontrolname=\"mobileNumber\"]")).sendKeys("8105369495");
            driver.findElement(By.cssSelector("input[formcontrolname=\"notificationHeader\"]")).sendKeys("Testing");
         // Assuming you have the absolute path of the image file
            String imagePathlol = "C:\\Users\\Admin\\Pictures\\Screenshots\\testingnotification.png";

            // Find the file input element using the XPath
            WebElement fileInputsd = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mail/div/div/div/div/form/div/div[2]/div[4]/input"));

            // Use the sendKeys() method to set the file path of the image
            fileInputsd.sendKeys(imagePathlol);


            Thread.sleep(2000);
			
            
			driver.findElement(By.cssSelector("textarea[formcontrolname=\"notificationBody\"]")).sendKeys("Hello I am Testing");

            
            
            driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-create-mail/div/div/div/div/form/div/div[3]/button[2]"))
					.click();
            
            	
			
			
//Adding Search Functionality in Notification
			
			
			String searchKeywordsdgui = "9110133887";
			WebElement searchInputsdgui = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > app-root > app-core > app-list-mail > div > div > div.filters__search > div.search__table > input")));
			test1.pass("Clicking To Search button and searching For name or any type As I passed as String");
			searchInputsdgui.sendKeys(searchKeywordsdgui);
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			searchInputsdgui.sendKeys(Keys.ENTER);
			searchInputsdgui.clear();
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			Actions actionssdio = new Actions(driver);
			actionssdio.sendKeys(searchInputsdgui, Keys.ENTER).perform();
			test1.pass("After searching, the search field is cleared");
			driver.navigate().to("http://143.110.248.51:5500/notifications");
			WebDriverWait waitmqu = new WebDriverWait(driver, duration);
			waitmqu.until(ExpectedConditions.urlToBe("http://143.110.248.51:5500/notifications"));
			test1.pass("Navigating to Admin Page");
			try {
			    Thread.sleep(2000); // 60 seconds = 60,000 milliseconds
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
//			
//			
//		
			
			
//          //delete Notification
//          
          
          driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-list-mail/div/div/div[4]/div[1]/table/tbody/tr[1]/td[7]/img"))
					.click();
          WebElement deleteElement23uj = driver.findElement(By.xpath("/html/body/app-root/app-core/app-list-mail/div/div/div[4]/div[1]/table/tbody/tr[1]/td[7]/div/ul/li/img"));
          deleteElement23uj.click();
          
          // Wait for the alert to be present
          WebDriverWait waitrhsgshi = new WebDriverWait(driver, duration);
          waitrhsgshi.until(ExpectedConditions.alertIsPresent());
  
          // Switch to the alert
          Alert alertm2 = driver.switchTo().alert();
  
          // Accept the alert (clicking the OK button)
          alertm2.accept(); 
         
			
			
			
			
//
//			//Staring UI Builder
//			
//			test1.pass("Starting To Test UI Builder  ");
//			driver.findElement(
//					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[9]/a"))
//					.click();
//			test1.pass("Navigating to  UI Builder Page");
			
			
			driver.findElement(
					By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[10]"))
					.click();
			
			WebElement logoutElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[10]/ul/a[2]/li"));
	        logoutElement.click();
			
			
			
            // Rest of the code...

//			 Testing Completed With All Test Cases

				test1.pass("Test completed");
				extent.flush();
			} catch (Exception e) {
	            test1.fail("Test failed due to an exception: " + e.getMessage());
//	        } finally {
//	            // Close the browser
//	           
//	                driver.quit();
			}
		}
			
    
    
			
			
			
/////////////////////////////////////////////////////
    private static CharSequence generateUniqueMobileNumber() {
        Set<String> usedMobileNumbers = new HashSet<>();

        while (true) {
            long randomMobileNumber = new Random().nextLong(MAX_MOBILE_NUMBER - MIN_MOBILE_NUMBER) + MIN_MOBILE_NUMBER;
            String mobileNumber = String.valueOf(randomMobileNumber);

            if (mobileNumber.charAt(0) >= '6' && mobileNumber.charAt(0) <= '9' &&
                    !usedMobileNumbers.contains(mobileNumber)) {
                usedMobileNumbers.add(mobileNumber);
                return mobileNumber;
            }
        }
    }


    private static String generateUniqueEmailId() {
        Set<String> usedEmailIds = new HashSet<>();

        while (true) {
            String emailId = getRandomString(10) + "@gmail.com";

            if (!usedEmailIds.contains(emailId)) {
                usedEmailIds.add(emailId);
                return emailId;
            }
        }
    }

    private static String generateUniqueAdminName() {
        Set<String> usedAdminNames = new HashSet<>();

        while (true) {
            String adminName = getRandomString(10);

            if (!usedAdminNames.contains(adminName)) {
                usedAdminNames.add(adminName);
                return adminName;
            }
        }
    }

   
    
    
    private static String getRandomString(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(randomIndex));
        }

        return sb.toString();
    }
    
    
    
    private static String generateUniquePackageName() {
        Set<String> usedPackageNames = new HashSet<>();

        while (true) {
            String packageName = getRandomString(10);

            if (!usedPackageNames.contains(packageName)) {
                usedPackageNames.add(packageName);
                return packageName;
            }
        }
    }
}
