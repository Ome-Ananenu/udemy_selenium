import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElementByXPath("//*[@id=\"HTML9\"]/div[1]/button").click();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        driver.switchTo().alert().accept(); //This command closes the pop up by clicking the OK button
        driver.switchTo().alert().dismiss(); //This command closes the pop up by clicking the Cancel button

//        Working with multiple frames
        driver.switchTo().frame(0);
        driver.switchTo().frame("countries");
        driver.switchTo().frame("input");

        driver.switchTo().defaultContent(); //This will take you back to the default page
    }
}
