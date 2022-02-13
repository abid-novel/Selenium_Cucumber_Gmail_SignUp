package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUp {
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(name = "Passwd")
    WebElement Passwd;
    @FindBy(name = "ConfirmPasswd")
    WebElement ConfirmPasswd;
    @FindBy(tagName = "button")
    List<WebElement> btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement msgShortPassError;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of letters, numbers, and symbols.')]")
    WebElement msgWeakPassError;

    public SignUp(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void doSignUp(String password) throws InterruptedException {
        firstName.sendKeys("Abid");
        lastName.sendKeys("Novel");
        username.sendKeys("abidnovel0303");
        Passwd.sendKeys(password);
        ConfirmPasswd.sendKeys(password);
        Thread.sleep(2000);
        btnNext.get(1).click();
    }

    public String shortPassErrorMsg() throws InterruptedException {
        Thread.sleep(1000);
        return msgShortPassError.getText();
    }

    public String weakPassErrorMsg() {
        return msgWeakPassError.getText();
    }
}
