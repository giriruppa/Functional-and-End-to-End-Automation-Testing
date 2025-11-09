package shineautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShineJobsAutomation {

    public static void main(String[] args) throws InterruptedException {
        // ✅ Set ChromeDriver path (change it to your path!)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruppa giridhar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ✅ Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            //------------------- STEP 1: Open Shine.com ------------------//
            driver.get("https://www.shine.com/");
            System.out.println("✅ Page loaded successfully");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 2: Click Login ------------------//
            WebElement loginBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[2]/div[1]/div/button"));
            loginBtn.click();
            System.out.println("✅ Login button clicked");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 3: Enter Email & Password ------------------//
            WebElement emailField = driver.findElement(By.id("id_email_login"));
            WebElement passwordField = driver.findElement(By.id("id_password"));

            emailField.sendKeys("ruppagiri116@gmail.com");  // Enter email
            passwordField.sendKeys("password");          // Enter password
            System.out.println("✅ Email & Password entered");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 4: Click Submit ------------------//
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.cls_base_1_pw_login_btn")
            ));
            submitBtn.click();
            System.out.println("✅ Login Successful!");
            Thread.sleep(1500); // wait 1.5 seconds after login

            //------------------- STEP 5: Click Job Search ------------------//
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("id_searchBase_new")
            ));
            searchBox.click();
            System.out.println("✅ Clicked on Job Search");
            Thread.sleep(1500); // wait 1.5 seconds

            //------------------- STEP 6: Enter Job Title ------------------//
            Actions actions = new Actions(driver);
            actions.sendKeys("Software Tester").perform();

            WebElement jobTitleBox = driver.findElement(By.id("id_q"));
            jobTitleBox.clear();
            jobTitleBox.sendKeys("Software Tester");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 7: Enter Location ------------------//
            WebElement locationBox = driver.findElement(By.id("id_loc"));
            locationBox.clear();
            locationBox.sendKeys("Hyderabad");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 8: Enter Experience ------------------//
            WebElement expBox = driver.findElement(By.id("searchBar_experience"));
            expBox.clear();
            expBox.sendKeys("2");
            Thread.sleep(1000); // wait 1 seconds

            //------------------- STEP 9: Click Search ------------------//
            WebElement searchBtn = driver.findElement(By.id("id_new_search_submit_button"));
            searchBtn.click();
            System.out.println("✅ Job search executed!");
            Thread.sleep(1500); // wait 1 seconds for results to load

            //------------------- STEP 10: Click First Apply ------------------//
 
            // Click Apply button inside first job card
            WebElement applyBtn = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
            applyBtn.click();

            System.out.println("🎯 First job application clicked!");
            Thread.sleep(2000); // wait 3 seconds after clicking Apply

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
        	Thread.sleep(3000);   // wait  for 3 seconds 
            driver.quit();
            System.out.println("✅ Browser closed");
        }
    }
}
