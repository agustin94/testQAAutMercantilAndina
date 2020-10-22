package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.ElementsPage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected ElementsPage elementsPage = new ElementsPage();

}
