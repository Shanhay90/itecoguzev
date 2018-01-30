package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDef.InitialSteps;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Header {
    public Header (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    /* Кнопка "Настройки" */
    @FindBy(xpath = "//li[@id = 'tuningMenu']")
        private WebElement buttonSetings;

    public void buttonSetingsclick() throws InterruptedException {
        Thread.sleep(1000);
        buttonSetings.click();
    }

    public void selectPointOfButtonSetingsList(String text) throws InterruptedException {
        WebElement point = buttonSetings.findElement(By.xpath("//li/a[contains(.,'"+text+"')]"));
        Thread.sleep(500);
        point.click();
    }

    @FindBy(xpath = "//self::node()[text()='Права  Все']/../*[1]")
    private WebElement buttonForExit;

    public void buttonForExitclick(){
        buttonForExit.click();
    }
    @FindBy(xpath = "//li[@id = 'collectMenu']")
    private WebElement collectMenu;

    public void buttonCollectClick() throws InterruptedException {
        Thread.sleep(1000);
        collectMenu.click();
    }



}
