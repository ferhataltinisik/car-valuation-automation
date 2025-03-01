package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "input.homepage-input-vrn")
    private WebElement regInput;

    @FindBy(css = "button.fw-bold")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Searches a vehicle by its registration number.
     */
    public void searchCarByRegNumber(String regNumber) {
        regInput.sendKeys(regNumber);
        searchButton.click();
    }
}
