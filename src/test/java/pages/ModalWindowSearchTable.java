package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalWindowSearchTable {
    public ModalWindowSearchTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }




    @FindBy(xpath = "//td/input[@role = 'textbox'][@class = 'input-elm']")
    private WebElement fieldInput;;

    public void inputDate(String value, WebDriver driver){
        fieldInput.clear();
        fieldInput.sendKeys(value);
    }
    public void choseOptions (String options, WebDriver driver){
        WebElement select = driver.findElement(By.xpath("//*[contains(text(),'"+options+"')]/.."));
        select.click();
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//option[text()='"+options+"']"))));
        element.click();
    }


}
