import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest_OrangeHRM {
    /*
1)Launch browser
2)Open URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login"
3)Provide valid ESS username(Admin)
4)Provide valid password(admin123)
5)Click on login
Capture title of the homepage:
Verify Title of the homepage
Close browser
*/

    public static void main(String[] args){
        System.out.println("Hello world");
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.findElementById("txtUsername").sendKeys("Admin");
//        driver.quit();
        driver.findElementById("txtPassword").sendKeys("admin123");
        driver.findElementById("btnLogin").click();


//Select the dropdown
WebElement dropdown = driver.findElementByXPath("//*[@id=\"RESULT_RadioButton-9\"]");
        Select sltDropDown = new Select(dropdown);


//       Find how many options are present in the dropdown
        sltDropDown.getOptions().size();
//Extract all the options and print them
        List<WebElement> options = sltDropDown.getOptions();

        for (WebElement option:options) {
            System.out.println(option.getText());
        }
//        How to select options from the dropdown
        sltDropDown.selectByVisibleText("Morning");
        sltDropDown.selectByIndex(1);
        sltDropDown.selectByValue("fff");


//        Radio Buttons: You can check the status of radio buttons or select an option
//        Conditional Commands(Returns true or false)
//        isDisplayed() : Can be used to check if an element on the web page is displayed
//        isEnabled() : Can be used to check if an element on the web page is enabled
//        isSelected() : This can only be used to check if a checkbox or radio button is selected



//Navigation Commands
//        navigate().to(URL) ---> Same as driver.get()
//        navigate.back()
//        navigate.forward()
//        navigate.refresh()

//        Browser commands
//        close() -> close currently open browser(one browser)
//        quit() -> close multiple browsers
//        Links


//   Wait Commands
//        Thread.sleep runs only once. It is not advisable to use as it causes performance issues
//        Thread.sleep(milli seconds)
//        Implicit wait will run/apply for your entire code
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// Explicit Wait
//        WebDriverWait myWait = new WebDriverWait(driver,10000);
//        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("userName")));

//        Counting Links(Find out total links present in a webpage)
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElementsByTagName("a");
        links.size();

//        To read all the links
        for (WebElement link: links) {
            System.out.println(link.getText());
        }


        driver.findElementByLinkText("Software Testing Tutorials").click();
driver.findElementByPartialLinkText("Software Testing").click();



        String actual_page_title = driver.getTitle();
        String expected_page_title = "OrangeHRM";

        if(actual_page_title.equals(expected_page_title)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }

    }

}
