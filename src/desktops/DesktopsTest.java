package desktops;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsTest extends TopMenuTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        List<WebElement> beforeElements = driver.findElements(By.xpath("//a[contains(text(),'Apple Cinema 30')]"));
        for (WebElement product : beforeElements) {
            System.out.println(product.getText());
        }

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        System.out.println("-----------------------------");

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> afterElements = driver.findElements(By.xpath("//a[contains(text(),'Sony VAIO')]"));
        for (WebElement product1 : afterElements) {
            System.out.println(product1.getText());
            }
        }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        verifyText("HP LP3065",By.xpath("//h1[contains(text(),'HP LP3065')]"));

        //2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-option225']"),"2022-11-30");

        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyText("Success: You have added HP LP3065 to your shopping cart!\n" +
                "×",By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.10 Click on link “shopping cart” display into success message
        Thread.sleep(5000);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.11 Verify the text "Shopping Cart"
        verifyText("Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));

        //2.12 Verify the Product name "HP LP3065"
        Thread.sleep(3000);
        verifyText("HP LP3065",By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        //2.13 Verify the Delivery Date "2022-11-30"
        verifyText("Delivery Date:2022-11-30",By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));

        //2.14 Verify the Model "Product21"
        verifyText("Product 21",By.xpath("//td[contains(text(),'Product 21')]"));

        //2.15 Verify the Todat "$122.00"
        verifyText("$122.00",By.xpath("//tbody/tr[1]/td[6]"));

    }

    @After
    public void tearDown() {
//        closeBrowser();
    }

}
