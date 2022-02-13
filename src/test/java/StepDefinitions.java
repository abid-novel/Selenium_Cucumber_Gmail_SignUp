import Pages.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    SignUp signUp;
    @Given("user visit to google signup page")
    public void user_visit_to_google_signup_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headed");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");

    }
    @When("user input less than eight character {string}")
    public void user_input_less_than_eight_character_password(String shortpass) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        signUp.doSignUp(shortpass);

    }
    @Then("user cannot signup")
    public void user_cannot_signup() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        String message = signUp.shortPassErrorMsg();
        Assert.assertEquals(message, "Use 8 characters or more for your password");
        driver.close();
    }

    @When("user input {string}")
    public void user_input_weak_password(String weakpass) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        signUp.doSignUp(weakpass);

    }
    @Then("user cannot signup again")
    public void user_cannot_signup_again() {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        String message = signUp.weakPassErrorMsg();
        Assert.assertEquals(message, "Please choose a stronger password. Try a mix of letters, numbers, and symbols.");
        driver.close();
    }
}
