package configuration;

import com.codeborne.selenide.Configuration;
import pageobject.AuthorizationPage;
import pageobject.HomePage;
import pageobject.ProjectPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public AuthorizationPage authorizationPage;
    public HomePage homePage;
    public ProjectPage projectPage;

    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://localhost:4200";
        open("/");
        homePage = new HomePage();
        authorizationPage = new AuthorizationPage();
        projectPage = new ProjectPage();
    }
}
