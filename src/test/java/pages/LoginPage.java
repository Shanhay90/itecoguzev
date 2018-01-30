package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
        public LoginPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15),this);
        }
        //Логотип
        @FindBy(xpath = "//img[@title = 'Агентство по страхованию вкладов']")
        private WebElement logo;

        public void logoPresent(WebDriver driver, String log){
            logo.isDisplayed();
            Assert.assertEquals(logo.getAttribute("title"), log);
        }
        //Форма
        @FindBy(xpath = "//form[@class = 'form-signin']")
        private WebElement loginForm;

        public void checkLoginForm(WebDriver driver, String text) {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(loginForm));
            loginForm.isDisplayed();
            Assert.assertEquals(loginForm.findElement(By.xpath("//h3")).getText(), text);
        }
//        //Поле логин
//        @FindBy
//
//
//        //Поле пароль
//        @FindBy
//
//
//        //Кнопка Войти
//        @FindBy
}
