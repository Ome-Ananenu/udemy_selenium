import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.findElementByXPath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a").click();

        driver.findElementByXPath("/html/body/section/div/div");
    }
}
