package stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Header;
import pages.LoginPage;
import pages.Mainpage;
import pages.ModalWindowSearchTable;

import java.util.concurrent.TimeUnit;

public class InitialSteps {
    public static ChromeDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static Mainpage mainpage;
    public static Header header;
    public static Actions actions;
    public static TableBook tableBook;
    public static ModalWindowSearchTable modalWindowSearchTable;

    @Before
    public void getStart() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\driver\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            //options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            loginPage = new LoginPage(driver);
            mainpage = new Mainpage(driver);
            header = new Header(driver);
            actions = new Actions(driver);
            driver.manage().timeouts().pageLoadTimeout( 3, TimeUnit.SECONDS);
            tableBook = new TableBook(driver);
            modalWindowSearchTable = new ModalWindowSearchTable(driver);



    }

    public static WebDriverWait getWait(WebDriver driver, int time){
        if (wait==null){
            wait = new WebDriverWait(driver,time);
        }return wait;
    }
   // @After
    public void closeBrowser() throws Throwable {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        driver=null;
    }
}