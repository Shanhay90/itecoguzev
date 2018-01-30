package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.Mainpage;

import java.util.List;

public class AuthenticationValidData {
    ChromeDriver driver;
    WebDriverWait wait;

    @Дано("^открыт браузер$")
    public void открыт_браузер() throws Throwable {
        driver = InitialSteps.driver;
    }
    @Дано("^открыта ссылка \"([^\"]*)\"$")
    public void открыта_сcskrf(String ref) throws Throwable {
        driver.get(ref);
    }
    @Когда("^открыта форма \"([^\"]*)\"$")
    @Если("^открыта страница с сообщением \"([^\"]*)\"$")
    @Тогда("^открыта страница авторизации с формой \"([^\"]*)\"$")
    @И("^открыта страница с формой \"([^\"]*)\"$")
    public void открыта_страница_с_формой(String elem) throws Throwable {
        Thread.sleep(500);
        HelpSteps.checkElement(elem, driver);
    }
    @Когда("^пользователь вводит в поле Логин \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_Логин(String arg1) throws Throwable {
        WebElement login = driver.findElement(By.xpath("//input[@id = 'username'][@name = 'j_username']"));
        login.clear();
        login.sendKeys(arg1);
    }
    @Когда("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_Пароль(String field, String arg1) throws Throwable {
        String type=null;
        if (field.contains("Пароль"))type="password";
        else
        if (field.contains("Имя пользователя"))type="username";
        WebElement password = driver.findElement(By.xpath("//input[@id = '"+type+"'][@placeholder = '"+field+"']"));
        password.clear();
        password.sendKeys(arg1);
    }

    @Тогда("^пользователь выбирает строку организации с названием \"([^\"]*)\"$")
    public void пользователь_выбирает_организацию(String arg1) throws Throwable {
        Thread.sleep(1000);
        WebElement orgForm = driver.findElement(By.xpath("//div[@class = 'modal-content ng-scope']"));
        WebElement row = orgForm.findElement(By.xpath("//td[contains(text(), '"+arg1+"')]/../self::node()[1]"));
        row.click();
        Thread.sleep(1000);
    }

    //@Когда("^И пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку(String arg2) throws Throwable {
        HelpSteps.pushButton(arg2, driver);
    }

    @Тогда("^пользователь нажимает \"([^\"]*)\" \"([^\"]*)\"$")
    public void пользователь_нажимает(String arg1, String arg2) throws Throwable {
        if (arg1.contains("кнопка"))arg1 = "button";
        else if(arg1.contains("ссылка"))arg1 = "a";
        if (arg2.contains("Права  Все"))arg1="span";
        driver.findElement(By.xpath("//"+arg1+"[contains(.,'"+arg2+"')]")).click();
    }

    @Тогда("^появляется страница с логотипом \"([^\"]*)\"$")
    public void появляется_страница_с_логотипом(String arg1) throws Throwable {
        HelpSteps.checkLogo(arg1, driver);
    }




    @Тогда("^пользователь нажимает на ссылку \"([^\"]*)\" в столбце \"([^\"]*)\"$")
        public void пользователь_нажимает_на_ссылку_в_столбце(String arg1, String arg2) throws Throwable {
        InitialSteps.tableBook.tableColumnSearch(arg2,arg1,driver);

    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void и_пользователь_нажимает_кнопку_в_верхней_панели_таблицы(String arg1) throws Throwable {
            InitialSteps.mainpage.clickButtonInTableSearchPanel(arg1, driver);
    }


    @Когда("^пользователь нажимает кнопку c выпадающем списком Настройки$")
    public void пользователь_нажимает_Настройки() throws Throwable {
        InitialSteps.header.buttonSetingsclick();
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт(String arg1) throws Throwable {
        InitialSteps.header.selectPointOfButtonSetingsList(arg1);
    }

    @Когда("^открыта страница с таблицей \"([^\"]*)\"$")
    public void открыта_страница_с_таблицей(String elem) throws Throwable {
        InitialSteps.tableBook.checkTableElement(elem, driver);
    }

    @Когда("^пользователь заполняет поля \"Имя пользователя\" и \"Пароль\" значениями$")
    public void пользователь_заполняет_поля_и_пароль_значениями(DataTable arg2) throws Throwable {
        List<String> list = arg2.asList(String.class);
        HelpSteps.enterData("username", "Имя пользователя", list.get(0), InitialSteps.driver);
        HelpSteps.enterData("password", "Пароль", list.get(1), InitialSteps.driver);
    }

    @Тогда("^пользователь выбирает выпадающем списке \"([^\"]*)\" пункт \"([^\"]*)\"$")
    public void пользователь_выбирает_выпадающем_списке_пункт(String arg1, String arg2) throws Throwable {
        InitialSteps.modalWindowSearchTable.choseOptions(arg2, driver);
    }

    @Тогда("^пользователь вводит в поле значение \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_значение(String arg1) throws Throwable {
        InitialSteps.modalWindowSearchTable.inputDate(arg1, driver);
    }
    @Тогда("^отображается\\(ются\\) \"([^\"]*)\" содержащий значение \"([^\"]*)\"$")
    public void отображается_ются(String arg1, String arg2) throws Throwable {

        Assert.assertTrue(HelpSteps.checkPresentOfElements(arg2, driver));
    }
    @Дано("^пользователь нажимает кнопку c выпадающем списком Сбор и ведение данных$")
    public void пользователь_нажимает_кнопку_c_выпадающем_списком_Сбор_и_ведение_данных() throws Throwable {
        InitialSteps.header.buttonCollectClick();
    }
//
    @Тогда("^отображается элемент с текстом \"([^\"]*)\"$")
    public void отображается_элемент_с_текстом(String arg1) throws Throwable {
        HelpSteps.checkElementByText(arg1, driver);
    }
    @Когда("^пользователь заполняет форму значениями$")
    public void пользователь_вводит_в_строку_значение(DataTable arg1) throws Throwable {
        List<List<String>> list = arg1.cells(0);
        for (int x= 0; x<list.size(); x++) {
            InitialSteps.mainpage.enterDataInActive(list.get(x).get(0), list.get(x).get(1), driver);
        }
    }
    @Когда("^пользователь кликает на свободном месте страницы$")
    public void пользователь_кликает_на_свободном_месте_страницы() throws Throwable {
            InitialSteps.mainpage.freeSpaceClick();
    }
    @Когда("^пользователь нажимает кнопку Сохранить$")public void пользователь_нажимает_кнопку_Сохранить() throws Throwable {
        InitialSteps.mainpage.clickSaveButton();
    }

}
