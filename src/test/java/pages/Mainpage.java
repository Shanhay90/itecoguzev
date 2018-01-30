package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.swing.*;

public class Mainpage {
    public Mainpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    // Панель таблицы

    @FindBy(xpath = "//table[@class = 'ui-pg-table navtable']")
    private WebElement tableSearchPanel;

    public void clickButtonInTableSearchPanel(String title, WebDriver driver) throws InterruptedException {
        WebElement button = tableSearchPanel.findElement(By.xpath("//td[@title = '" + title+ "']"));
        Actions action = new Actions(driver);
        //action.moveToElement(button).build().perform();
            Thread.sleep(1000);
            button.click();
    }
    public void enterDataInActive (String name, String value, WebDriver driver) throws InterruptedException {
        WebElement input = driver.findElement(By.xpath("//*[contains(text(), '"+name+"')]/../following-sibling::*[1]//input"));
        Thread.sleep(2000);
        input.click();
        input.clear();
        input.sendKeys(value);
        System.out.print(value);

    }

}
