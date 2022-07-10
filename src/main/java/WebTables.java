import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> tableRows = driver.findElementsByTagName("tr");
        System.out.println(tableRows.size());

        List<WebElement> tableCols = driver.findElementsByXPath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[1]/th");
        System.out.println(tableCols.size());

        System.out.println(driver.findElementByXPath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[6]/td[3]").getText());
    }
}
