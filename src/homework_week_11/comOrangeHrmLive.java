package homework_week_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Project-2 - Project Name: com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class comOrangeHrmLive {
    public static void main(String[] args) {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";

        // Launching the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        //We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
       // System.out.println("Page title is : " + driver.getTitle());

        // Print the current url
        String URL = driver.getCurrentUrl();
        System.out.println("Current URL is : " + URL);
        //System.out.println("Current URL is: " + driver.getCurrentUrl());

        //Print the page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source is : " + pageSource);
        //System.out.println("Page source is: " + driver.getPageSource());

        // Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //Find the password field elements and Type the password into password field in one line
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Close the browser
        driver.close();
    }
}
