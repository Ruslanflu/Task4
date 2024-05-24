
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RunTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    @Parameters( {"BrowserType"} )
    public static void setup(String browserType) throws InterruptedException {
        if (browserType.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("Edge")) {
//            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browserType.equalsIgnoreCase("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек(неявное ожидание).
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://devcs.avtodoria.ru/dashboard/");

//        loginPage.inputLogin("1");
//        loginPage.inputP("1");
//        loginPage.clickBtn();
//
//        profilePage.clickDatSelection();
//        new Actions(driver).moveByOffset(1059, 190).click().build().perform();
//        System.out.println("Мы зачеркнули столбец!");
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.inputLogin("1");
        loginPage.inputP("1");
        loginPage.clickBtn();

        profilePage.clickDatSelection();
        new Actions(driver).moveByOffset(1059, 190).click().build().perform();
        System.out.println("Мы зачеркнули столбец!");
    }

    @AfterClass
    public static void tearDown() {
//        profilePage.clickBtnExit();
        System.out.println("Вы удачно вышли с аккаунта");
    }
}
