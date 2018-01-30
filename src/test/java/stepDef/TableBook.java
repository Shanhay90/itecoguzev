package stepDef;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Header;

public class TableBook {

    public TableBook(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public static void checkTableElement(String element, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement elem = driver.findElement(By.xpath("(//self::node()[text()='" + element + "'])[2]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(elem));
        elem.isDisplayed();
        Assert.assertEquals(elem.getText(), element);
    }

    public void tableColumnSearch(String column, String title, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        String columnName=null;
        switch (column){
            case "Краткое наименование":
                columnName = "dictionarylistgrid_shortName";
                break;
            case "Полное наименование справочника":
                columnName = "dictionarylistgrid_fullName";
                break;
            case "Код справочника":
                columnName = "dictionarylistgrid_dicCode";
                break;
        }
        WebElement rowInTable = driver.findElement(By.xpath("//td[@aria-describedby ='"+columnName+"'][@title = '"+title+"']"));
        if (columnName.equals("dictionarylistgrid_shortName")){
            rowInTable.findElement(By.xpath("//a[text()='"+title+"']")).click();
        }
    }



}