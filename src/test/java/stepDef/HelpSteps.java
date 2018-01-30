package stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelpSteps {
            public static void checkElement(String element, WebDriver driver) throws InterruptedException {
                Thread.sleep(1000);
                WebElement elem = driver.findElement(By.xpath("//self::node()[text()='"+element+"']"));
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(elem));
                elem.isDisplayed();
                Assert.assertTrue(elem.getText().equalsIgnoreCase(element));
            }
            public static void checkElementByText(String element, WebDriver driver) throws InterruptedException {
            Thread.sleep(1000);
            WebElement elem = driver.findElement(By.xpath("//self::node()[contains(text(),'"+element+"')]"));
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(elem));
            elem.isDisplayed();
            }


            public static void enterData (String id, String placeholder, String data, WebDriver driver){
                WebElement element = driver.findElement(By.xpath("//input[@id = '"+id+"'][@placeholder = '"+placeholder+"']"));
                element.clear();
                element.sendKeys(data);
            }
            public static void pushButton(String button, WebDriver driver){
                WebElement element = driver.findElement(By.xpath("//self::node()[text()='"+button+"']"));
                element.isDisplayed();
                element.click();
            }
            public static void checkLogo(String element, WebDriver driver){
                WebElement elem = driver.findElement(By.xpath("//self::node()[@title='"+element+"']"));
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(elem));
                elem.isDisplayed();
            }
             public static boolean checkPresentOfElements(String element, WebDriver driver) throws InterruptedException {
                 Thread.sleep(1000);
                 List<WebElement> elements = driver.findElements(By.xpath("//self::node()[text()='" + element + "']"));
                 if (elements.size() >= 1) {
                     return true;
                 } else return false;
             }

}
