package com.TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSeleniumFlow() throws InterruptedException {
        // Generate random values for name, mobile, landline, and email
        String randomName = generateRandomString(8);
        String randomMobile = generateRandomNumber(10);
        String randomLandline = generateRandomNumber(10);
        String randomEmail = generateRandomString(8) + "@gmail.com";

        // Your test steps here
        driver.get("http://206.189.140.49:5000/login");
        driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys("mso@onnet.com");
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys("1111");
        driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div/div[2]/form/div/div[3]/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div/div[2]/form/div/div[4]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/app-top-nav/div/div/ul/li[1]/div/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/app-top-nav/div/div/ul/li[1]/div/div/ul/li[1]")).click();

        // Assert your test conditions here
    }

    // Method to generate a random string of specified length
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }

    // Method to generate a random number of specified length
    public static String generateRandomNumber(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            stringBuilder.append(digit);
        }
        return stringBuilder.toString();
    }
}
