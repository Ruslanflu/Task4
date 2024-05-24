import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/app-root/app-dashboard/div/header/app-dashboard-header/div/div[2]/app-scroll-calendar/div/div/div[2]")
    private WebElement BtnDate;
    @FindBy(xpath = "/html/body/div/div/p-calendar/span/div/div[1]/div/div/button[1]")
    private WebElement BtnMart;
    @FindBy(xpath = "/html/body/div/div/p-calendar/span/div/div/div/div[2]/table/tbody/tr[1]/td[7]/span")
    private WebElement BtnDay;

    public void clickDatSelection() throws InterruptedException {
        BtnDate.click();
        Thread.sleep(1000);
        BtnDay.click();
        Thread.sleep(1000);
    }
    //20 марта0

    @FindBy(xpath = "/html/body/app-root/app-dashboard/div/header/app-dashboard-header/div/div[3]/p-button/button/span")
    private WebElement BtnMenu;
    @FindBy(xpath = "/html/body/app-root/app-dashboard/div/p-sidebar/div/div[2]/div/app-dashboard-user-profile/div/p-button/button")
    private WebElement BtnExit;

    public void clickBtnExit() {
        BtnMenu.click();
        BtnExit.click();
    }


}
