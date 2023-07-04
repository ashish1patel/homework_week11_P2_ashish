package myaccounts;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccountsTest extends TopMenuTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        driver.findElement(By.xpath("//span[contains(text(),'"+ option +"')]")).click();

        //This method should click on the options whatever name is passed as parameter.
        //clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
//        List<WebElement> topMenuNames = driver.findElements(By.xpath("//span[@class='caret']"));
//        for (WebElement names : topMenuNames) {
//            if (names.getText().equals("Register")) {
//                names.click();
//                break;
//
//            }
//        }

    }
    @Test
    public void  verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on My Account Link.
        selectMyAccountOptions("My Account");

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register” selectMyAccountOptions("Register");
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Register']"));

        //1.3 Verify the text “Register Account”.
        verifyText("Register Account",By.xpath("//h1[normalize-space()='Register Account']"));
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link.
        selectMyAccountOptions("My Account");

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        //2.3 Verify the text “Returning Customer”.
        verifyText("Returning Customer",By.xpath("//h2[normalize-space()='Returning Customer']"));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        selectMyAccountOptions("My Account");
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Register']"));

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"prime");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"testng");

        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"prime1237@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"01234567899");

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"prime123");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"prime123");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//input[@id='input-confirm']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        verifyText("Your Account Has Been Created!",By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        selectMyAccountOptions("My Account");

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        //3.16 Verify the text “Account Logout”
        verifyText("Account Logout",By.xpath("//h1[normalize-space()='Account Logout']"));

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        selectMyAccountOptions("My Account");

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"prime1237@gmail.com");

        //4.4 Enter Last Name
       // sendTextToElement(By.xpath(""),"testing");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"prime123");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        verifyText("My Account",By.xpath("//h2[normalize-space()='My Account']"));

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverOnElementAndClick(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));

        //4.10 Verify the text “Account Logout”
        verifyText("Account Logout",By.xpath("//h1[normalize-space()='Account Logout']"));

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
