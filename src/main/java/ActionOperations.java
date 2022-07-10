import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionOperations {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Actions
//        Mouse Hover
//        Right Click
//        Double Click
//        Drag and Drop

        driver.get("https://phptravels.com/demo/");

//        Mouse Hover
        Actions act = new Actions(driver);
        WebElement company = driver.findElementByXPath("/html/body/header/div/nav/div[3]/span");
        WebElement blog = driver.findElementByXPath("/html/body/header/div/nav/div[3]/div/a[1]");

        act.moveToElement(company).moveToElement(blog).click().build().perform();

//                Right Click

        WebElement homeBtn = driver.findElementByXPath("/html/body/header/nav/div/ul[1]/li[2]/a");
        act.contextClick(homeBtn).build().perform();
//DouleClick
        act.doubleClick(homeBtn).build().perform();

        //        Drag and Drop
//        To drag and drop, all you need is a source element and a target element
        WebElement sourceElement = driver.findElementById("italy");
        WebElement targetElement = driver.findElementById("country");

        act.dragAndDrop(sourceElement,targetElement);

//        Scrolling
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Approach 1: Scroll to a certain point(specified by number of pixels)
        js.executeScript("window.scrollBy(0,4000)","");

        //Approach 2: Scroll till you find a certain element
        WebElement flag = driver.findElementByXPath("xks//so");
        js.executeScript("arguments[0].scrollIntoView();",flag);

//        Approach 3: Scroll to the end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");



    }
}
